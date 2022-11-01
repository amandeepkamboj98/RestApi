package Authentications;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingJSONArray_StudentsAPI {

	@Test
	void testJsonResponseBodyData()
	{
		Response res=
				given()
					.contentType(ContentType.JSON)
				.when()
					.get("http://localhost:3000/students");
		
				
		//using JSONArray class
	//	JSONArray jarr=new JSONArray(res.asString());  // converting reponse to json object
			//Print courses
//		for(int i=0; i<jarr.length();i++)
//		{
//			JSONArray courses=jarr.getJSONObject(i).getJSONArray("courses");
//			System.out.println(courses.get(0)+"       "+courses.get(1));
//		}
//
						
	}
	
}
