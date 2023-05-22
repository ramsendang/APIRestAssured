package APIObjects;

import BaseClass.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETRequest extends BaseTest {
    public Response response;
    public void checkHTTPSResponse(){
        ExtentTest statuscodeTest = extent.createTest("checking status code");
        response = RestAssured.get("https://reqres.in/api/users");
        int statusCode = response.getStatusCode();
        statuscodeTest.info("the status code is " + statusCode);
        if(statusCode == 200){
            statuscodeTest.info("The request was successfull");
        }else if(statusCode == 201){
            statuscodeTest.info("the request was successfull and resource was created");
        } else if (statusCode == 204) {
            statuscodeTest.info("the request was successfull but the response was empty");
        } else if (statusCode == 400) {
            statuscodeTest.info("Bad Request: The request could not be understood or was missing required parameters.");
        } else if (statusCode == 401){
            statuscodeTest.info("Unauthorized: Authentication failed or user does not have permissions for the requested operation.");
        } else if (statusCode == 403) {
            statuscodeTest.info("Forbidden: Access denied.");
        } else if (statusCode == 404) {
            statuscodeTest.info("Not Found: Resource was not found.");
        } else if (statusCode == 500) {
            statuscodeTest.info("Internal Server Error: Something went wrong on the server");
        }
    }
}
