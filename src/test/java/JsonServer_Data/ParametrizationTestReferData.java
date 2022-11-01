package JsonServer_Data;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParametrizationTestReferData extends Referdata {
    // @Test(dataProvider = "empdataprovider")
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

    //  @Parameters({"id"}) // this parameter data comes from TestNG.xml file
    // when data is very less then we use parameters annotations we use multiple parameters here
    @Test(dataProvider = "DeleteData")
    void deleteRecord(int id) {
        RestAssured.baseURI = "http://localhost:3000/";
        given().header("Content-Type", "application/json")
                .when().delete("Students/" + id)
                .then().statusCode(200).log().all();
    }
}