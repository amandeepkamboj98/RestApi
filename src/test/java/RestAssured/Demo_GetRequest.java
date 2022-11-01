package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Demo_GetRequest {
    @Test
    public void getWeatherDetials() {

        //baseURI
        RestAssured.baseURI = "https://www.google.com/search?q=chandigarh+weather&rlz=1C1GCEU_enIN985IN985&oq=&aqs=chrome.1.69i59i450l8.89735j0j7&sourceid=chrome&ie=UTF-8"; // URI

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET);

        //Extract body from response
        String responsebody = response.getBody().asString(); // captured the response body from json to string format
        System.out.println(responsebody);

        // validating response body
        Assert.assertEquals(responsebody.contains("Headers"),false);  //Assertion
        Assert.assertEquals(responsebody,equalTo(""));  //  hamcreat library
        int statusCode = response.getStatusCode(); //CAPTURE STATUS CODE
        String statusLine = response.getStatusLine();  // CAPTURE STATUS LINE
        System.out.println("......................");
        System.out.println(statusCode);
        System.out.println(statusLine);

        // 2nd way to write script
        //     given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();

        //validatation

         // 1st way to parsing full data
//        JsonPath js =  response.jsonPath();
//        String name = js.getString("name");
//        System.out.println(name);
//
//        // 2nd way to parsing data
//        JsonPath js1 = new JsonPath(responsebody);
//        System.out.println(js1.getString("name"));

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        // 3rd way to write script
//        Response res= RestAssured.get("uri_site");
//        System.out.println(res.getBody().asString());  convert response boy into string

        // validate the headers
        String contentType = response.header("Content-Type");
        System.out.println("Header is " + contentType);
        Assert.assertEquals(contentType,"text/html; charset=ISO-8859-1");

         // validating the all headers
        Headers allheaders=response.headers(); // capture all the headers from response
        for(Header header:allheaders)
        {
            System.out.println(header.getName()+"     "+header.getValue());
        }
    }
}
