package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatData {
    @Test(dataProvider ="employee")
    public void creatRecord(String name,String sal, String age) {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification http = RestAssured.given();

        JSONObject js = new JSONObject();
        js.put("name",name);
        js.put("salery",sal);
        js.put("age",age);

        http.header("Content-Type", "application/json");
        http.body(js.toJSONString());
        Response res = http.request(Method.POST, "/create");

        String responseBody = res.getBody().asString();
        System.out.println("Response body is :" + responseBody);

        int statusCode = res.getStatusCode();
        System.out.println("status code id " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
        @DataProvider(name = "employee")
             public Object[][] empdata(){
             return new Object[][] {{"Aman","10000","23"},{"Deep","20000","25"},{"Kamboj","25000","24"}};
        }
    }


