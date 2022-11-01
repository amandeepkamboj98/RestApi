package Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Basic_Authentications {

   // @Test
    public void basicAuthenticaion() {
        given()
                .auth().basic("amandeep.kamboj@testingxperts.com", "K@mboj123")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                // .body("authenticated", equalTo(false))  // validating
                .log().all();
    }

    //@Test(priority=2)
    void testDigestAuthentication()
    {
        given()
                .auth().digest("Username","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    //@Test(priority=3)
    void testPreemptivecAuthentication()
    {
        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority=4)
    void testBearerTokenAuthentication()
    {
        String bearerToken="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";

        given()    // bearer token add in headers
                .headers("Authorization","Bearer "+bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().body();
    //.log().all();
    }

    //@Test
    void testOAuth1Authentication()
    {
        given()
                .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate") // this is for OAuth1.0 authentication
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }
                      // Most important mostly used now
  //  @Test
   void testOAuth2Authentication()
    {
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
          //      .body("455425609",equalTo(true))
                .log().all();
    }

    @Test
    void testAPIKeyAuthentication()
    {
        //Method1
		/*given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is APIKey
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
			.statusCode(200)
			.log().all();
		*/

        //Method2

        given()
                .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") // appid is APIKey
                .pathParam("mypath","data/2.5/forecast/daily")
                .queryParam("q", "Delhi")
                .queryParam("units", "metric")
                .queryParam("cnt", "7")
                .when()
                .get("https://api.openweathermap.org/{mypath}")
                .then()
                .statusCode(200)
                .log().all();
    }
}



