package ApiChaining;

import org.testng.ITestContext;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void test_createuser(ITestContext context)
    {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name",faker.name().fullName());
        data.put("gender","Male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");
        String bearerToken="c35e10e748c6f113775527bcef204e9929b4c9f4b995a8ee253eec46aed57b06";  // github token
        int id=	given()  // only id is capture
                .headers("Authorization","Bearer " +bearerToken)
                .contentType("application/json")
                .body(data.toString())    // (data.toJSONString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

       System.out.println("Genrated is :" +id);
        // Chain (Share Data with) APIs in same Test Tag
        //context.setAttribute("user_id", id);

        //Chain (Share Data with) APIs in same Suite Tag
      //  context.getSuite().setAttribute("user_id", id);
    }
}
