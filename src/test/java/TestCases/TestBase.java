package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static RequestSpecification httpRequest;
    public static Response response;

    @BeforeClass
    public void setup()
    {
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();
    }

}
