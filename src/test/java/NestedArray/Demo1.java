package NestedArray;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Demo1 {
	@Test
	public void test() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.asString());

		int statusCode = res.statusCode();
		Assert.assertEquals(statusCode, 200);

		String statusLine = res.statusLine();
		System.out.println(statusLine);
	}
	@Test
       void getData() {
		String res = given()

				.when().get("https://reqres.in/api/users?page=2")
				.then().statusCode(200).log().body()
			//	.body("data.email",equalTo("janet.weaver@reqres.in"))
				.extract().response().asString();

		JsonPath js =new JsonPath(res);
		String id  = js.getString("data.id[1]");
		System.out.println(id);
		String email  = js.getString("data.email[1]");
		System.out.println(email);
		String url = js.getString("support.url");
		System.out.println(url);
		System.out.println("successfully completed.....");


		System.out.println("3rd way.......");

		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification http = RestAssured.given();
		Response res1 = http.request(Method.GET);

		// JSONObject js =new JSONObject();

		String responseBody = res1.getBody().asString();
		System.out.println(responseBody);

		JsonPath js1 = new JsonPath(responseBody);
		int dataId = js1.getInt("data.id");
		System.out.println("id is :"+dataId);

		String dataEmail = js1.getString("data.email");
		System.out.println("email is :"+dataEmail);

		String dataName = js1.getString("data.first_name");
		System.out.println("namee is :" +dataName);

		int statuscode = res1.getStatusCode();
		System.out.println(statuscode);

		Assert.assertEquals(statuscode,200);

		System.out.println("successfully completed.....");
	}

	@Test
	public void postData() {

		RestAssured.baseURI = "https://reqres.in";

//		   HashMap<String, Object> map = new HashMap<String,Object>();
//
//		   map.put("name","Aman");
//		   map.put("job","Tester");

		JSONObject req = new JSONObject();
		req.put("name","Aman");
		req.put("job","Tester");



		System.out.println(req.toJSONString());

		String data =   given()//.header("Content-Type","application/json")
				 .contentType(ContentType.JSON)
				//.accept(ContentType.JSON)
				.body(req.toJSONString())
				.when().post("/api/users")
				.then().statusCode(201).log().all().extract().response().asString();

		JsonPath path = new JsonPath(data);
		System.out.println((String) path.get("id"));
		System.out.println((String) path.get("createdAt"));
		System.out.println((String) path.get("name"));
		System.out.println((String) path.get("job"));
	}


	@Test
	public void putData() {

		RestAssured.baseURI = "https://reqres.in";

//		   HashMap<String, Object> map = new HashMap<String,Object>();
//
//		   map.put("name","Aman");
//		   map.put("job","Tester");

		JSONObject req = new JSONObject();
		req.put("name","Aman");
		req.put("job","Tester");



		System.out.println(req.toJSONString());
		given()
		  .header("Content-Type","application/json")
				  .contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString())
				.when().put("/api/users/2")
				.then().statusCode(200).log().all();

//		JsonPath path = new JsonPath(data);
//		//	System.out.println(path.get("id"));
//		System.out.println((String) path.get("updatedAt"));

	}
}

