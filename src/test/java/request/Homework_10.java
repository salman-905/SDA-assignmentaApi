package request;

import Pojo.PojoHw9;
import base_url.Hw10BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Homework_10 extends Hw10BaseUrl {

   /*
    Using the https://petstore.swagger.io/ document,
    write an automation test that finds the number of
    "pets" with the status "available" and asserts that there are more than 100.

    https://petstore.swagger.io/v2/pet/
*/
    @Test
    public void userRequestTest(){
        spec.pathParams("first","pet","second","findByStatus");

        Response response = given()
                .spec(spec)
                .queryParam("status", "available")
                .get("/{first}/{second}");
        response.prettyPrint();

        List<String> statuses = response.jsonPath().getList("findAll { it.status == 'available' }.status");
        Assert.assertTrue(statuses.size() > 100);
    }
}