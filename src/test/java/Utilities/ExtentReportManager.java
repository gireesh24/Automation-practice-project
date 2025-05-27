package Utilities;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
public class ExtentReportManager {
//        implements ITestListener {
//        public ExtentSparkReporter sparkReporter; // Ui for the report
//        public ExtentReports extent; // populate common infrom to report
//        public ExtentTest test; //creating test case entire status of the repor
//
//        public void onStart(ITestContext context) {
////		sparkReporter=new ExtentSparkReporter("D://intellij Idea/Project2/reports/myReport.html");
//            sparkReporter=new ExtentSparkReporter(System.getProperty("users")+"/reports/myReport.html");
//
//            sparkReporter.config().setDocumentTitle("Automation report");
//            sparkReporter.config().setReportName("functional testing");
//            sparkReporter.config().setTheme(Theme.STANDARD);
//
//            extent= new ExtentReports();
//            extent.attachReporter(sparkReporter);
//
//            extent.setSystemInfo("computer anme", "local host");
//            extent.setSystemInfo("environment", "QA");
//            extent.setSystemInfo("Tester name", "raju");
//            extent.setSystemInfo("os", "wondows 10");
//            extent.setSystemInfo("browser name", "chrome");
//        }
//        public void onTestSuccess(ITestResult result) {
//            test= extent.createTest(result.getName());
//            test.log(Status.PASS, "test case passed:"+ result.getName());
//        }
//        public void onTestFailure(ITestResult result) {
//            test=extent.createTest(result.getName());
//            test.log(Status.FAIL, "Test cases failed:"+result.getName());
//            test.log(Status.FAIL, "test cases failed cause is:"+ result.getThrowable());
//        }
//        public void onTestSkipped(ITestResult result) {
//            test=extent.createTest(result.getName());
//            test.log(Status.SKIP, "test cases skiped"+result.getName());
//        }
//        public void onFinish(ITestContext context) {
//            extent.flush();
//            System.out.println("Extent report generated successfully.");
//        }
//
}
