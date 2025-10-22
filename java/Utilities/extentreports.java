
package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreports {

    private static ExtentReports extent;

    public static ExtentReports setup() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);

            // Optional styling and details
            reporter.config().setReportName("Sauce Demo Automation Report");
            reporter.config().setDocumentTitle("Test Results");
            reporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        
    }
        return extent;
}
}
