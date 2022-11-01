// through deserialization, we convert from json data into Java Object


package Serialization_Deserialization;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class get_deserialize {
    public HashMap<String, Integer> map = new HashMap<String, Integer>();

    @BeforeClass
    public void con_uri() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/";
    }

    @BeforeClass
    public void generateQueryParam() {
        map.put("page",2);
    }

    @Test
    public void get_Rest() {
       Pojo pojo = given()
                .queryParams(map)

                .when()
                   .get()

                .as(Pojo.class);
          System.out.println(pojo.getTotal_pages());
          System.out.println(pojo.getData());
          System.out.println(pojo.getData().get(0));
          System.out.println(pojo.getData().get(4).getFirst_name());
          String str = pojo.getData().get(4).getFirst_name();
          Assert.assertEquals(str,"George");



    }
}