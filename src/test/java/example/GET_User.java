package example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ConfigReader;
import util.TestUtil;

public class GET_User extends TestUtil {
    @Test
    public void getNewUser(){
        createRequest().queryParam("id", "11" );
        executeAPI("GET", ConfigReader.getProperty("getPathParameter"));
        responseSpecification(200);
        getResponse();
        Response response = getResponse();
        JsonPath js = getJsonPath(response);
        Assert.assertEquals(js.getString("title"), "et ea vero quia laudantium autem");


    }
}
