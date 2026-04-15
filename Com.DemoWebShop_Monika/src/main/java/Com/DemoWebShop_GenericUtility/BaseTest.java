package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {
	
    public WebDriver driver;
    public static WebDriver sDriver;
    public FileUtility fileutility=new FileUtility();
    public ExtentSparkReporter spark;
    public ExtentReports report;
    public ExtentTest test;
	
    public 	Welcome_Page welcomePage = new Welcome_Page(driver);
    public	Login_page loginpage = new Login_page(driver);
    public Home_Page homepage = new Home_Page(driver);
    public WebDriverUtility webDriverUtility=new WebDriverUtility();
	
	
	@BeforeSuite
	public void bs() {
		System.out.println("@BeforeSuite   Database connected");
		
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("@BeforeTest    Report started");
		spark=new ExtentSparkReporter("./Reports/extentreport.html");
		report=new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest("Demo");
	}
	
	@BeforeClass
	public void bc() throws IOException {
		System.out.println("@BeforeClass   Browser launched");
		
		String browser=fileutility.readDataFromPropertyFile("browserName");
		String url=fileutility.readDataFromPropertyFile("baseUrl");
		
//		String browser=System.getProperty("browserName");
//		String url=System.getProperty("baseUrl");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
		 driver=new EdgeDriver();	
		}
		else {
			System.out.println("Enter valid browser name");
		}
		
		
		sDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
	}
	
	@BeforeMethod
	public void bm() throws IOException {
		System.out.println("@BeforeMethod  login");
		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginBtn().click();

		loginpage = new Login_page(driver);
		loginpage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("Emailid"));
		loginpage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginpage.getLoginBtn().click();

		homepage = new Home_Page(driver);
		
	}
	
	@AfterMethod
	public void am() {
		System.out.println("@AfterMethod   logout");
		homepage.getLogoutBtn().click();
	}
	
	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("@AfterClass  Browser closed");
		
		Thread.sleep(3000);
	    driver.quit();
	}
	
	@AfterTest
	public void at() {
		System.out.println("@AfterTest  Report ended");
	    report.flush();
	}
	
	@AfterSuite
	public void as() {
		System.out.println("@AfterSuite Database disconnected");
	}

}
