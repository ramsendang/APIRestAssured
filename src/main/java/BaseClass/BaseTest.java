package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected ExtentReports extent;
    protected ExtentSparkReporter spark;
    @BeforeSuite
    public void suitSetUP(){
        String dateName = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("src/main/resources/reports/"+dateName+"report.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void suitTearDown(){
        extent.flush();
    }
}
