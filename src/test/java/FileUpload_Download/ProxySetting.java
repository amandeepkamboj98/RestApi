package FileUpload_Download;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProxySetting {

    @Test
    public  void handleProxy(){
      // RestAssured.proxy("127.0.0.1",8888);
       RestAssured.given().proxy("127.0.0.1",8888)
               .when().get("http://localhost:3000/Students").andReturn();

    }
}
