package FileUpload_Download;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class File_Upload {

    @Test
    public void upload_File(){
        File file = new File("C:\\Users\\Testing\\Pictures\\Screenshots\\User.png");

        Response res = RestAssured.given()
                      .multiPart("file",file,"multipart/form-data")
                      .post("https://the-internet.herokuapp.com/upload").thenReturn();

        System.out.println(res.prettyPrint());

    }
}
