package Cookies;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {

    //https://reqres.in/api/users?page=2& =5



    @Test
    void testQueryAndPathParameters()
    {
        given()
                .pathParam("mypath","users")    // path parameters
                .queryParam("page",2)  // query parameter
                .queryParam("id",5)  // query parameters
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
