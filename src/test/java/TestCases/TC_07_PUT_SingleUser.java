package TestCases;

import Utilities.RestUtils;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_07_PUT_SingleUser extends TestBase {

    String userName = RestUtils.userName();
    String userJob = RestUtils.userJob();

    @BeforeClass
    void putSingleUser() throws InterruptedException
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", userName);
        requestParams.put("job", userJob);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.request(Method.PUT, "api/users/2");
        Thread.sleep(1);
    }

    @Test
    void checkResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(userName));
        Assert.assertTrue(responseBody.contains(userJob));
        Assert.assertTrue(responseBody.contains("updatedAt"));
        System.out.println(userName);
        System.out.println(userJob);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }

    @Test
    void checkStatusLine()
    {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
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
