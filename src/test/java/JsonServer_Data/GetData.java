package JsonServer_Data;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetData {       // db.json file
    @Test
    public void getRecord(){
        Response res = RestAssured.get("http://localhost:3000/Students");
        System.out.println(res.asString());
        System.out.println(res.getBody().asString());
        System.out.println(res.getStatusCode());
        System.out.println(res.getTime());
        System.out.println(res.getContentType());
        System.out.println(res.getHeaders());
    }

    @Test
    public void getRecord1(){
        RestAssured.baseURI = "http://localhost:3000/Students";

       String res = given().header("Content-Type","application/json")
                .when().get("/1")
                   .then().statusCode(200).log().all().extract().response().asString();

        JsonPath js =new JsonPath(res);
        System.out.println(js.getInt("id"));
        System.out.println(js.getInt("subjectId"));
        System.out.println((String) js.get("name"));
        System.out.println((String) js.get("roll-no"));
    }
 @Test
    public void getrecord2(){
        RestAssured.baseURI = "http://localhost:3000/Students";
     RequestSpecification http = RestAssured.given();
     Response res = http.request(Method.GET);
     String data = res.asString();
     System.out.println(data);

     int statuscode = res.getStatusCode();
     System.out.println(statuscode);

     JsonPath js1 = new JsonPath(data);
     System.out.println(js1.getString("name"));
     System.out.println(js1.getInt("id[4]"));
     System.out.println(js1.getInt("subjectId[4]"));

    }

    @Test
    void postRecord(){
        RestAssured.baseURI = "http://localhost:3000";


        JSONObject js = new JSONObject();
        js.put("name","Pardeep");
        js.put("roll-no","188908");
        js.put("subjectId","8");

        System.out.println(js.toJSONString());


         String res = given().header("Content-Type","application/json")
              .body(js.toJSONString())
              .when().post("/Students")
              .then().statusCode(201).log().all().extract().response().asString();


         JsonPath js1 = new JsonPath(res);
        System.out.println(js1.getInt("id"));
    }

    @Test
    void putRecord(){
        RestAssured.baseURI = "http://localhost:3000/Students";


        JSONObject js = new JSONObject();
        js.put("name","deepkamboj");
        js.put("roll-no","1801977");
        js.put("subjectId","7");

        System.out.println(js.toJSONString());


        given().header("Content-Type","application/json")
                .body(js.toJSONString())
                .when().put("/6")
                .then().statusCode(200).log().all();

    }

    @Test
    void deleteRecord(){
        RestAssured.baseURI = "http://localhost:3000/Students";


//        JSONObject js = new JSONObject();
//        js.put("name","deepkumar");
//        js.put("roll-no","1801977");
//        js.put("subjectId","7");

       // System.out.println(js.toJSONString());


        given().header("Content-Type","application/json")

                .when().delete("/7")
                .then().statusCode(200).log().all();
    }
 }
