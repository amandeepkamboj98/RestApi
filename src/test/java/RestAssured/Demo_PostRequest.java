package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_PostRequest {           // not working
    @Test
    public void registerCustomer() throws InterruptedException
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";   // site is not working

        RequestSpecification httpRequest=RestAssured.given();

        //Specifying request Payload in JSON format
        JSONObject requestParams=new JSONObject();  // JSONObject class is used for insert data as a body
        requestParams.put("FirstName","xydddzabc123233");
        requestParams.put("LastName","abcdddxyz123222");
        requestParams.put("UserName","xydddzabc123221");
        requestParams.put("Password","abddcxyz123122");
        requestParams.put("Email","xyz1dd23567abc2111@gmail.com");

        //Specify body type is Json/content type
        httpRequest.header("Content-Type","application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());   // Must be there

        //POST request

        Response response=httpRequest.request(Method.POST,"/register");
     //   Response response=request.post("/register");
        System.out.println(response);

        Thread.sleep(3000);

        //Validate the Response status code
        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,201);


        //Validate the Response success code
        String successCode=response.jsonPath().get("SuccessCode");
        System.out.println(successCode);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
    }
}
