package request;

import io.restassured.response.Response;
import base_url.base_url;

import static io.restassured.RestAssured.given;

public class Homework4  extends base_url {
    public void testapi() {
        //https://reqres.in/api/users/2
        String url = " https://reqres.in/api/users/3";
        Response response = given().get(url);
        response.prettyPrint();

        //  HTTP Status Code should be 200
        response.then().statusCode(200);

        // Content Type should be JSON

        response.then().contentType("application/json");

        //    Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");


//       Given
//           https://reqres.in/api/users/2
//       When
//           User send GET Request to the URL
//       Then
//           HTTP Status Code should be 200
//       And
//           Response format should be "application/json"
//       And
//           "email" is "janet.weaver@reqres.in",
//       And
//           "first_name" is "Janet"
//       And
//           "last_name" is "Weaver"
//       And
//           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"

    }
}
