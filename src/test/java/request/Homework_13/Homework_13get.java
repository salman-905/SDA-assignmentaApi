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

public class Homework_13get extends Hw13BaseUrl {


//Write an automation test that will create a 'user' then read, update and delete the created user
// using the "https://petstore.swagger.io/" document. (Create a classes for each request.)



    @Test(priority =2)
    public void get() {
        //read
        spec.pathParams("first", "user", "second", "salman");
        Response responseRead = given(spec).get("{first}/{second}");
        responseRead.prettyPrint();

        //  assertion
        Assert.assertEquals(responseRead.getStatusCode(), 200);
    }



    }



