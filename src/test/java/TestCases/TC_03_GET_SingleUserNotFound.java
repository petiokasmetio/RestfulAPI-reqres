package TestCases;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_03_GET_SingleUserNotFound extends TestBase {

    @BeforeClass
    void userNotFound() throws InterruptedException
    {
        response = httpRequest.request(Method.GET, "/api/users/23");
        Thread.sleep(1);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
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
        Assert.assertEquals(statusLine, "HTTP/1.1 404 Not Found");
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
        System.out.println("Finish");
    }
}
