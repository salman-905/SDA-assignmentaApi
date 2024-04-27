package request;

import Pojo.PojoHw9;
import base_url.Hw11BaseUrl;
import base_url.Hw9BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static groovy.json.JsonOutput.prettyPrint;
import static io.restassured.RestAssured.given;

public class Homework_11 extends Hw11BaseUrl {
/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/

    @Test
    public void userRequestTest(){
spec.pathParams("first","productsList");


Response response = given(spec).get("{first}");

response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<Integer> LIST = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women'}category.usertype.usertype");
        System.out.println(LIST);
        response.jsonPath().prettyPrint();
        //"products.findAll { it.category.usertype.usertype == 'Women' }.category.usertype.usertype"
        Assert.assertEquals(LIST.size(),12);


    }
}