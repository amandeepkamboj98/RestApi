package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Request1 {
    //  (right code)
    @Test
    public void registerCustomer() throws InterruptedException {
        RestAssured.baseURI = "https://reqres.in/api/users";   // site is not working

        RequestSpecification httpRequest = RestAssured.given();

        //Specifying request Payload in JSON format
        JSONObject requestParams = new JSONObject();  // JSONObject class is used for insert data as a body
        requestParams.put("name", "amandeep");
        requestParams.put("job", "hacker");

        //Specify body type is Json/content type
        httpRequest.header("Content-Type", "application/json");
        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());   // Must be there    given().body(requestParams.toJSONString())

        //POST request

        Response response = httpRequest.request(Method.POST);    // when().post(" ").
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);                          //   .then().log().all();

        System.out.println("....................");
        // validating each response body each line with Path name   x.name[1]
        JsonPath js = new JsonPath(responseBody);
        System.out.println(js.getString("name"));
        System.out.println(js.getString("job"));
        System.out.println(js.getInt("id"));
        System.out.println(js.getString("createdAt"));

        // validating response body contain something
         Assert.assertEquals(responseBody.contains("name"),true);

        Thread.sleep(3000);

        //Validate the Response status code
        int statusCode = response.getStatusCode();
        System.out.println("status code id " + statusCode);
        Assert.assertEquals(statusCode, 201);


    }
}