package TestCases;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_04_GET_ListResource extends TestBase {

    @BeforeClass
    void getListResource() throws InterruptedException
    {
        response = httpRequest.request(Method.GET, "/api/unknown");
        Thread.sleep(1);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertNotNull(responseBody);
        Assert.assertTrue(responseBody.contains("id"));
        Assert.assertTrue(responseBody.contains("cerulean"));
        Assert.assertTrue(responseBody.contains("fuchsia rose"));
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
