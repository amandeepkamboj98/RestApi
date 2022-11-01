package RestAssured;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GET_Request_Autherization {
     @Test
    public void auth(){
         RestAssured.baseURI = "https://www.ptuexam.com/Webportal";
         // create object of class for authorization
         PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
         auth.setUserName("");
         auth.setPassword("");

         RestAssured.authentication=auth;

         //Request object
         RequestSpecification httpRequest=RestAssured.given();

         //Response object
         Response response=httpRequest.request(Method.GET,"/");

         //print response in console window
         String responseBody=response.getBody().asString();
         System.out.println("Response Body is:" +responseBody);

         //status code validation
         int statusCode=response.getStatusCode();
         System.out.println("Status code is: "+statusCode);
         Assert.assertEquals(statusCode, 200);
    }
}
