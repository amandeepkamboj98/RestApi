package NestedArray;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ParameterizationLibraryData {
	

	@Test(dataProvider ="BooksData") // Get Parameterization Data
	public void AddBook(String isbn, String aisle) {  // pass element of array in each run
		RestAssured.baseURI = "http://216.10.245.166";

		String res = given().log().all().header("Content-Type", "application/json")
				.body(Methods.addBook(isbn,aisle))  
				.when().post("Library/Addbook.php")
				.then().assertThat().statusCode(200).log().all().extract().response()
				.asString();

		JsonPath js = new JsonPath(res);
		String id = js.get("ID");
		System.out.println(id);
	}
	@DataProvider(name="BooksData")  // Parameterization
	
	// array = collection of elements
	// multidimensional array =  collection of array
	 public Object[][] getData() {                      //multiple set of data and pass in TestNG notation
		return new Object[][] {{"amandeep","50`"},{"deep Kumar","92"},{"druning","88"}}; // set 3 array as 3 book data
	}
}
