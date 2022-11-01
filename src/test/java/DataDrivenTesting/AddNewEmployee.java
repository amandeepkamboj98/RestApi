package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewEmployee {
                             // DataDriven Testing
    @Test(dataProvider = "empdataprovider")
    public void postNewEmployees(String ename, String esal, String eage) {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        // Here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name",ename);
        requestParams.put("salary",esal);
        requestParams.put("age",eage);

        // Add a header stating the Request body is a JSON  what kind of data(json)
        httpRequest.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        //POST REQUEST
        Response response = httpRequest.request(Method.POST, "/create");

        //capture response body to perform validations
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);

        // validate body contains these data or not
//        Assert.assertEquals(responseBody.contains("AmanKamboj"),true);
//        Assert.assertEquals(responseBody.contains("50000"),true);
//        Assert.assertEquals(responseBody.contains("25"),true);

        //   validating statuscode is 200
        int statuscode = response.getStatusCode();
        System.out.println("status code is " +statuscode);
         Assert.assertEquals(statuscode, 200);
    }

         // drive data into excel sheet
    @DataProvider(name = "empdataprovider")
    Object[][] getEmpData() throws IOException {

        // Read data from excel sheet
        String path =  System.getProperty("user.dir")+"/src/test/java/DataDrivenTesting/empdata.xlsx";
        int rowCount = XL_Utility.getRowCount(path, "Sheet1");
        int cellCount = XL_Utility.getCellCount(path, "Sheet1", 1);

        // taking multiple data from excel
        String empdata[][] = new String[rowCount][cellCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                empdata[i-1][j] = XL_Utility.getCellData(path, "Sheet1", i, j);
            }
        }
        return empdata;
    }
}
       // String empdata[][]={ {"abc123","30000","40"}, {"xyz123","40000","30"}, {"pqr123","80000","50"}};
     //   return(empdata);  // return string type of array}

