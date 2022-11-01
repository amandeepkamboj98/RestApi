package Authentications;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class Demo {

    @Test        // OAuth 2.0 Authorization
    void testOAuth2Authentication()
    {
        Response res = given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos");
        JsonPath js =new JsonPath((InputStream) res);
        String responseBody = res.asString();  // get data in single string
        System.out.println(responseBody);

        int code =res.getStatusCode();
        System.out.println(code);

        String header = res.header("Content-Type");
        System.out.println(header);
    }
}
