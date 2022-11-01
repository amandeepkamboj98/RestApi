package Parametrization;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Parametrization_AddNewEmployee {

    // Parametrizaqtion

    @Test(dataProvider = "empdataprovider")
     void postNewEmployees(String ename, String esal, int eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        // Here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name",ename);
        requestParams.put("salary",esal);
        requestParams.put("age",eage);

        // Add a header stating the Request body is a JSON  what kind of data(json)
        httpRequest.header("Content-Type","application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());  // parsing the json response

        //POST REQUEST
        Response response=httpRequest.request(Method.POST,"/create");

        //capture response body to perform validations
        String responseBody=response.getBody().asString();
        System.out.println("Response body is:"+ responseBody);

        // validate body contains these data or not
//        Assert.assertEquals(responseBody.contains(ename),true);
//        Assert.assertEquals(responseBody.contains(esal),true);
//        Assert.assertEquals(responseBody.contains(eage),true);
//
      //   validating statuscode is 200
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        Assert.assertEquals(statuscode, 200);
    }

    @DataProvider(name="empdataprovider")
    public Object[][] getEmpData()
    {
        return new Object[][] {{"Dee4","3590",38}, {"Dee126","40605",48},{"Deeak9","65900",41}};
         // return string type of array
    }
}
