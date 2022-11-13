package TestCases;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_02_GET_SingleUser extends TestBase {

    @BeforeClass
    void getSingleUser() throws InterruptedException
    {
        response = httpRequest.request(Method.GET, "/api/users/2");
        Thread.sleep(1);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("id"));
        Assert.assertTrue(responseBody.contains("janet.weaver@reqres.in"));
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime()
    {
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime < 3000);
    }

    @Test
    void checkStatusLine()
    {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }

    @Test
    void checkContentLength()
    {
        String contentLength = response.header("Content-Length");
        //Assert.assertTrue(Integer.parseInt(contentLength) < 1500);
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("FINISH");
    }
}
