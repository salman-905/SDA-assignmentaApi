package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Hw11BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api/")
                .setContentType(ContentType.JSON)
                .build();

    }
}
