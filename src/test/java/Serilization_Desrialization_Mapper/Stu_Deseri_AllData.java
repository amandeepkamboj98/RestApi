package Serilization_Desrialization_Mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

public class Stu_Deseri_AllData {   // for single data

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void getData(){

        String url = "http://localhost:3000/Students/5";

        Student_DataPojo stu_data = RestAssured.given().get(url).as(Student_DataPojo.class);

        System.out.println("data 1st id is :"+stu_data.toString());

            // List for to get all data

        String url2 = "http://localhost:3000/Students";
        Type  type = new TypeReference<List<Student_DataPojo>>() {}.getType();
        List<Student_DataPojo> list = RestAssured.get(url2).as(type);
        System.out.println("All Data of json-server :"+list.toString());

        // another way to get all data using Array[]

        Student_DataPojo allData[] = RestAssured.get(url2).as(Student_DataPojo[].class);
        System.out.println("All Data :"+allData);

    }
}
