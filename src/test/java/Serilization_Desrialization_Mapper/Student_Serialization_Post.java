package Serilization_Desrialization_Mapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Student_Serialization_Post {

    private static final ObjectMapper MAPPER = new ObjectMapper();

   // public static void main(String[] args) throws JsonProcessingException {

    @Test
        public void postData() throws JsonProcessingException {
        Student_DataPojo stu = new Student_DataPojo();    //raw data creat
       // stu.setId(6);
        stu.setName("Rajeev");
        stu.setRollNo("1801978");
        stu.setSubjectId(7);

        String url = "http://localhost:3000/Students";

        String json = MAPPER.writeValueAsString(stu);  // convert data into json

        Response res = RestAssured.given().contentType("application/json")
                .log().all(true).body(json).when().post(url).andReturn();

        Assert.assertEquals(res.getStatusCode(),201,"HTTP Message");  // validation

        int status = res.statusCode();
        System.out.println(status);

        String responseData = res.getBody().asString();
        System.out.println(responseData);

        JsonPath js = new JsonPath(responseData);
        System.out.println(js.getString("name"));
    }
}
