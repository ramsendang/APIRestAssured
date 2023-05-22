package TestRunner;

import APIObjects.GETRequest;
import BaseClass.BaseTest;
import org.testng.annotations.Test;

public class GetRequestTest extends BaseTest {
    @Test
    public void StatusCodeTest(){
        GETRequest get = new GETRequest();
        get.checkHTTPSResponse();
    }
}
