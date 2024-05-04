package request.Homework_13;

import Pojo.PojoHw12;
import Pojo.PojoHw13;
import base_url.Hw13BaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class Homework_13Create extends Hw13BaseUrl {


//Write an automation test that will create a 'user' then read, update and delete the created user
// using the "https://petstore.swagger.io/" document. (Create a classes for each request.)


    @Test(priority = 1)

    public void createRequestTest( ) {
        spec.pathParams("first", "user");
//crete
        PojoHw13 createUser = new PojoHw13("salman","aq","123",1,"12334",5,"xx@hod.co","salman");

        Response responseCrete = given(spec).body(createUser).post("{first}");

        Assert.assertEquals(responseCrete.statusCode(), 200);
    }





}