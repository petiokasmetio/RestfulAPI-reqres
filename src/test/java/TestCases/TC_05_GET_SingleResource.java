package TestCases;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_05_GET_SingleResource extends TestBase {

    @BeforeClass
    void getSingleResource() throws InterruptedException
    {
        response = httpRequest.request(Method.GET, "/api/unknown/2");
        Thread.sleep(1);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertNotNull(responseBody);
        Assert.assertTrue(responseBody.contains("id"));
        Assert.assertTrue(responseBody.contains("fuchsia rose"));
        Assert.assertTrue(responseBody.contains("2001"));
        Assert.assertTrue(responseBody.contains("#C74375"));
        Assert.assertTrue(responseBody.contains("17-2031"));
        Assert.assertTrue(responseBody.contains("https://reqres.in/#support-heading"));
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
        Assert.assertTrue(responseTime < 4999);
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
    void checkServerType()
    {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "cloudflare");
    }

    @Test
    void checkContentEncoding()
    {
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding, "gzip");
    }

    @AfterClass
    void tearDown()
    {
        System.out.println("Finish");
    }
}
