package request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework_03 {
  /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void testApi()
    {

        String url = " https://reqres.in/api/users/3";
        Response response = given().get(url);
        response.prettyPrint();

        //  HTTP Status Code should be 200
        response.then().statusCode(200);

       // Content Type should be JSON

        response.then().contentType("application/json");

        //    Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");




    }

}
