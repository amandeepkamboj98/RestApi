package Deserialization;

//import Serialization_Deserialization.Pojo;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class get_result {
public HashMap<String, String> map = new HashMap<String, String>();

    @BeforeClass
    public void con_uri(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api/users/2";
        }

        @BeforeClass
    public void map_get(){
        map.put("page","");

    }
    @Test
    public void get_req(){
     PojoClass pojo = (PojoClass) given()
             .queryParams(map)

              .when()
                  .get()

             .as(PojoClass.class);
             System.out.println(pojo.getData());
             System.out.println(pojo.getData().getFirst_name());
             System.out.println(pojo.getData().getLast_name());
             System.out.println(pojo.getSupport());
             System.out.println(pojo.getSupport().getText());
    }
}
