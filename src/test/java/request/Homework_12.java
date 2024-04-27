package request;

import Pojo.PojoHw12;
import Pojo.PojoHw9;
import base_url.Hw12BaseUrl;
import base_url.Hw9BaseUrl;
import io.restassured.response.Response;
import org.junit.experimental.categories.Category;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework_12 extends Hw12BaseUrl {
    /*  Write an automation test that will create, read, update, delete a 'pet'
    using the "https://petstore.swagger.io/" document
    (All actions must be done on same pet)
                (Use Pojo)
     */




    @Test(priority=1)

    public void createRequestTest( ) {
        spec.pathParams("first", "pet");

//crete
        PojoHw12.category category=   new PojoHw12.category(3, "cat");
        PojoHw12.Tag tag = new PojoHw12.Tag(2, "");
        PojoHw12 pet =   new PojoHw12(3, category, "cat", Arrays.asList("http://pho.com/photo"), Arrays.asList(tag), "sold");
        Response responseCrete = given(spec).body(pet).post("{first}");

        Assert.assertEquals(responseCrete.statusCode(), 200);
    }

    @Test(priority =2)
    public void get() {
        //read
        spec.pathParams("first", "pet", "second", "3");
        Response responseRead = given(spec).get("{first}/{second}");
        responseRead.prettyPrint();

        PojoHw12 actualPet = responseRead.as(PojoHw12.class);

        //  assertion
        Assert.assertEquals(responseRead.getStatusCode(), 200);
        Assert.assertEquals(actualPet.getId(), 3);
    }

    @Test(priority =3)
    public void update() {
        PojoHw12.category category=   new PojoHw12.category(3, "cat");
        PojoHw12.Tag tag = new PojoHw12.Tag(2, "");
        PojoHw12 pet =   new PojoHw12(3, category, "cat", Arrays.asList("http://pho.com/photo"), Arrays.asList(tag), "sold");

        //read
        spec.pathParams("first", "pet", "second", "3");
        pet.setName("Dog");
        pet.setStatus("availble");
        Response updateResponse = given(spec)
                .body(pet)
                .put("{first}/{second}");
        updateResponse.prettyPrint();


        // do assertion
        SoftAssert softAssert = new SoftAssert();
//        PojoHw12 actualPet = updateResponse.as(PojoHw12.class);
//        softAssert.assertEquals(updateResponse.getStatusCode(), 200);
//        softAssert.assertEquals(actualPet.getName(),"Doggie");
//        softAssert.assertEquals(actualPet.getStatus(),"sold");
//        softAssert.assertAll();

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