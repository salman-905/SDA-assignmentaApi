package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Hw15BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://documenter.getpostman.com/view/4012288/TzK2bEa8")
                .setContentType(ContentType.JSON)
                .build();

    }
}
