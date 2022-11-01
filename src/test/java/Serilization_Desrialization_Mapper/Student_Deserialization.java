package Serilization_Desrialization_Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.lexer.Da;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class Student_Deserialization {   // for single data

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void getData() {

        String url = "http://localhost:3000/Students/6";

        Student_DataPojo stu_data = RestAssured.given().post(url).as(Student_DataPojo.class);

        System.out.println("data 1st id is :" + stu_data.toString());

        String responseBody = stu_data.getName("name");
        System.out.println("Name is :" + responseBody);

        int Dataid = stu_data.getId("id");
        System.out.println("id is :" + Dataid);

        String rollNo = stu_data.getRollNo("roll_no");
        System.out.println("Rollno. is :" + rollNo);

    }
}
