package JsonServer_Data;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParametrizationTest {
    @Test(dataProvider = "empdataprovider")
        // correctly working
    void postRecord(String name, int roll_no, int subjectId) {

        RestAssured.baseURI = "http://localhost:3000";

        JSONObject js = new JSONObject();
        js.put("name", name);
        js.put("roll-no", roll_no);
        js.put("subjectId", subjectId);

        System.out.println(js.toJSONString());


        String res = given().header("Content-Type", "application/json")
                .body(js.toJSONString())
                .when().post("/Students")
                .then().statusCode(201).log().all().extract().response().asString();

        JsonPath js1 = new JsonPath(res);
        System.out.println(js1.getInt("id"));
    }

    @DataProvider(name = "empdataprovider")
    public Object[][] dataForPost() {
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Preet";
//        data[0][1] = 1801978;
//        data[0][2] = 10;
//
//        data[1][0] = "Sandeep";
//        data[1][1] = 1802899;
//        data[1][2] = 11;
//
//        return data;

        return new Object[][]{{"Sandeep", 1801978, 10}, {"ritu", 1801979, 11}, {"Rohit", 1801980, 12}};
    }

  //  @Test(dataProvider = "DeleteData")
    void deleteRecord(int id) {
        RestAssured.baseURI = "http://localhost:3000/";
        given().header("Content-Type", "application/json")
                .when().delete("Students/"+id)
                .then().statusCode(200).log().all();
    }

  //  @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[] {6,7,8};
    }
}