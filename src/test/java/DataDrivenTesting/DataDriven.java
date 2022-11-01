package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DataDriven {
    @Test
    public void data(String firstName,String lastName,int supportId) {
        RestAssured.baseURI = "url";

        JSONObject obj = new JSONObject();
        obj.put("firstname",firstName);
        obj.put("lastname",lastName);
        obj.put("supportid",supportId);

        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(obj.toJSONString())
                .body(obj);
                   }
}