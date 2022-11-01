package Authentications;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONArray_EmployeesAPI {

	@Test
    public 	void testJsonResponseBodyData()
	{
		JsonPath js = new JsonPath(Payload.book());
		String title = js.getString("book.title[0]");
		System.out.println("title of book is :"+title);

		float price = js.getFloat("book.price[1]");
		System.out.println("price of book is :"+price);

		int count = js.getInt("book.size()");
		System.out.println("count number of book is :"+count);

    	for(float i=0; i<count; i++)
		{
		float price1 = js.get("book[" +i+ "].price");
			System.out.println("price of all books :"+price1);
		}
	}
}
