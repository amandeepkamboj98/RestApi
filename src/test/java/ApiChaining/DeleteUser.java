package ApiChaining;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void deleteUser(ITestContext context){

        int id = 4882;
       // String id = (String) context.getSuite().getAttribute("user_id");

        String bearerToken="c35e10e748c6f113775527bcef204e9929b4c9f4b995a8ee253eec46aed57b06";  // github token
        given()
                .headers("Authorization","Bearer " +bearerToken)
                .pathParam("id", id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();
    }
}
