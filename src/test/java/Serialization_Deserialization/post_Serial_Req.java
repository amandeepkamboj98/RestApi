package Serialization_Deserialization;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class post_Serial_Req {

    @BeforeClass
    public void uri_setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/";
    }

    @Test
    public void create_User() {
        Serialization ser = new Serialization("aman", "leader");

      //  Serialization ser = new Serialization();
        given()
                .contentType("application/json")
                .body(ser)

                .when()
                    .post()

                .then()
                    .statusCode(201)
                    .log().all();
    }
}
