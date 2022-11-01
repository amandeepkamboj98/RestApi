package FileUpload_Download;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class File_Download {

    @Test
    public void download_File() throws IOException {
        Response res = RestAssured.given().log().all().when().get("https://reqres.in/api/users/2").andReturn();

        byte[] bytes = res.getBody().asByteArray();
        File file = new File("D:\\Aman Work\\Download File\\AmanData.json");
        Files.write(file.toPath(),bytes);
    }
}
