package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("Demo Web Shop Automation Report");
            spark.config().setReportName("Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Application", "Demo Web Shop");
            extent.setSystemInfo("Environment", "Test");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "ASWA");
        }

        return extent;
    }
}