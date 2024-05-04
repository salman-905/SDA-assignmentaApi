package request;

import base_url.Hw14BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Homework_14  extends Hw14BaseUrl {

    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */


    @Test()
    public void get() {
        //read
        spec.pathParams("first", "employees");
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //  Status code is 200
        Assert.assertEquals(response.statusCode(), 200);

        response.then()
                .body(
                        "data", hasSize(24),
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"),
                        //The greatest age is 66
                        //"data.employee_age",greaterThanOrEqualTo(66)
                        "data.max { it.employee_age }.employee_age", equalTo(66),
                        //The name of the lowest age is "Tatyana Fitzpatrick"
                        "data.min { it.employee_age }.employee_name", equalTo("Tatyana Fitzpatrick"),
                        //Total salary of all employees is 6,644,770
                        "data.collect { it.employee_salary }.sum()", equalTo(6644770)
                );
    }}
