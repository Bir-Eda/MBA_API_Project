package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class TestUtil {

    RequestSpecification request;
    Response response;
    ResponseSpecification resspec;

    /**
     * The common methods in order which means use the methods the same order in test classes
     * @return
     */

    public RequestSpecification createRequest() {
        request = given().log().all().spec(new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseURI")).
                addHeader("Content-type", "application/json").
              //  addHeader("Authorization", ConfigReader.getProperty("token")).
                setContentType(ContentType.JSON).build());

        return request;
    }














    /**
     *
     * This method is for ...
     * @return
     */

    public ResponseSpecification responseSpecification(int statusCode) {

        // ResponseSpecification designates how the response looks like, it is interface
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        return resspec;

    }
    public void executeAPI(String httpMethod, String pathParam){
        switch (httpMethod){
            case "GET":
                response=request.when().get(pathParam);   // response
                break;
            case "POST":
                response=request.when().post(pathParam);
                break;
            case "DELETE":
                response=request.when().delete(pathParam);
                break;
            case "PUT":
                response=request.when().put(pathParam);
                break;
            default:
                System.out.println("Please pass the correct http method");
                break;

        }

    }
    public Response getResponse(){
        return response.then().log().all().spec(resspec).extract().response();
    }
    public JsonPath getJsonPath(Response response){ //JsonPath validation common method
        return new JsonPath(response.asString());

    }
}
