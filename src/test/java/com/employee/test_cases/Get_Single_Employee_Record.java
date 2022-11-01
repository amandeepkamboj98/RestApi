/******************************************************
 Test Name:Get a single employee data
 URI: http://dummy.restapiexample.com/api/v1/employee/{id}
 Request Type: GET
 Request Payload(Body): NA

 ********* Validations **********
 Status Code : 200
 Status Line : HTTP/1.1 200 OK
 Content Type : text/html; charset=UTF-8
 Server Type :  nginx/1.14.1
 Content Encoding : gzip
 Content Length <800
 *********************************************************/
                              // get single record based on EmpID
package com.employee.test_cases;
import com.employee.base.Basetest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Get_Single_Employee_Record extends Basetest{

    RequestSpecification httpRequest;
    Response response;

    @BeforeClass
    void getEmployeeData() throws InterruptedException
    {
      //  logger.info("*********Started TC002_Get_Single_Employee_Record **********");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/employee/"+empID); //hardcoded value

        Thread.sleep(5000);
    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(empID), true);
        System.out.println(responseBody);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);
    }

    @Test
    void checkResponseTime()
    {
        long responseTime = response.getTime(); // Getting status Line
        Assert.assertTrue(responseTime<6000);
        System.out.println(responseTime);
    }

    @Test
    void checkstatusLine()
    {
        String statusLine = response.getStatusLine(); // Gettng status Line
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        System.out.println(statusLine);
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json");
        System.out.println(contentType);
    }

    @Test
    void checkserverType()
    {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "nginx/1.21.6");
        System.out.println(serverType);
    }

    @Test
    void checkContentLenght()
    {
        String contentLength = response.header("Content-Length");
        Assert.assertTrue(Integer.parseInt(contentLength)<1500);
        System.out.println(contentLength);
    }

  //  @AfterClass
    void tearDown()
    {
        logger.info("*********  Finished TC002_Get_Single_Employee_Record **********");
    }

}
