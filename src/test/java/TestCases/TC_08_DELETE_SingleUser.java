package TestCases;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_08_DELETE_SingleUser extends TestBase {

    @BeforeClass
    void deleteSingleUser() throws InterruptedException
    {
        response = httpRequest.request(Method.DELETE, "/api/users/2");
        Thread.sleep(1);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertNotNull(responseBody);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
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
        Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertNull(contentType, null);
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
