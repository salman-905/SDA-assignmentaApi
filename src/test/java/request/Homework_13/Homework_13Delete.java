package request.Homework_13;

import Pojo.PojoHw13;
import base_url.Hw13BaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework_13Delete extends Hw13BaseUrl {


//Write an automation test that will create a 'user' then read, update and delete the created user
// using the "https://petstore.swagger.io/" document. (Create a classes for each request.)


    @Test(priority = 1)

    public void delete( ) {
        spec.pathParams("first", "user","second","salman");
//crete

        Response responseCrete = given(spec).delete("{first}/{second}");

        Assert.assertEquals(responseCrete.statusCode(), 200);
    }





}