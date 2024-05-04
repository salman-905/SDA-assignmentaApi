package request.Homework_13;

import Pojo.PojoHw12;
import Pojo.PojoHw13;
import Utils.ObjectMapperUtils;
import base_url.Hw13BaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class Homework_13update extends Hw13BaseUrl {


//Write an automation test that will create a 'user' then read, update and delete the created user
// using the "https://petstore.swagger.io/" document. (Create a classes for each request.)




    @Test(priority =3)
    public void update() {

      //  PojoHw13 updateUser = new PojoHw13("salman","aq","053222",1,"079876",5,"xx@hod.com","salman");

        //read
        spec.pathParams("first", "pet", "second", "salman");

        //Set the expected data
        String strJson = """
                        {
                            "firstName" : "salman",
                            "lastName" : "al ghanem",
                            "password" : "432",
                            "userStatus" : 5,
                            "phone" : "06544",
                            "id" : "5",
                            "email":"xx@hhh.cm",
                             "username" : "salman"
                          
                        }
                """;

        PojoHw13 expectedData = ObjectMapperUtils.convertJsonToJava(strJson, PojoHw13.class);
        System.out.println("expectedData = " + expectedData);


        Response updateResponse = given(spec)
                .body(expectedData)
                .put("{first}/{second}");

        updateResponse.prettyPrint();


        // do assertion
Assert.assertEquals(updateResponse.statusCode(),200);
    }

    @Test(priority =4)
    public void delete()
    {
        spec.pathParams("first", "pet", "second", "3");
        Response responseDelete = given(spec).delete("{first}/{second}");
        responseDelete.prettyPrint();

        Assert.assertEquals(responseDelete.statusCode(),200);


    }



}