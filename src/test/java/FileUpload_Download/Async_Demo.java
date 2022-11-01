package FileUpload_Download;


import io.restassured.path.json.JsonPath;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Async_Demo {

    @Test
    public void async() throws ExecutionException, InterruptedException {

        Future<Response> resFuture = Dsl.asyncHttpClient()
                .prepareGet("https://reqres.in/api/users?delay=5").execute();

        Response res = resFuture.get();
        System.out.println(res);
        System.out.println(res.getStatusCode());

        String data = res.getResponseBody();
        System.out.println(data);

        JsonPath js = new JsonPath(data);
        System.out.println(js.getInt("data.id[1]"));
    }
}
