package request;

import Pojo.PojoHw9;
import base_url.Hw9BaseUrl;
import base_url.base_urlTask8;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Homework_09 extends Hw9BaseUrl {
/*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
    public void userRequestTest(){
spec.pathParams("first","user");

        PojoHw9 pojoHw9 = new PojoHw9(905,"Salman905","salman","al ghanem","ss@hia.com","1234","74637",5);

Response response = given(spec).body(pojoHw9).post("{first}");

response.prettyPrint();

    }
}