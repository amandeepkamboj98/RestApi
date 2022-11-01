package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetReqRes {

    @Test
    public void getData(){
        RestAssured.baseURI = "https://reqres.in/api";
     String res =   given()

                .when().get("/users/2")
                .then().statusCode(200).log().body().extract().response().asString();
        JsonPath js =new JsonPath(res);
        String id  = js.getString("data.id");
        System.out.println(id);
        String email  = js.getString("data.email");
        System.out.println(email);
        String url = js.getString("support.url");
        System.out.println(url);
    }
}
