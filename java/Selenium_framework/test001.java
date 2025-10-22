package Selenium_framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.common;
import Utilities.extentreports;
import pom_pages.cart_page;
import pom_pages.checkout_page;
import pom_pages.login_page;
import pom_pages.product_page;
import testdata.excelfunc;

public class test001 extends common{
	
	login_page lp;
	product_page pp;
	cart_page cp;
	checkout_page cpp;
	
	public ExtentReports extent;
    public ExtentTest test;
	
	@BeforeClass
	public void brow() {
		
		launch("https://www.saucedemo.com/");
		extent = new ExtentReports();
//		extent.
		// Initialize report
        extent = extentreports.setup();
		
	}
	
//	@BeforeMethod
//	public void reports(Method method) {
		
		
//		test=er.extent.createTest("Test Case : " + method.getName());
//		test.log(Status.PASS,"Test Case Passed is " + method.getName());

//	}
	@BeforeMethod
    public void startReport(Method method) {
        test = extent.createTest(method.getName());
    }
	
	@Test
	public void login_into() throws IOException {
		
		lp=new login_page(dr);
		
		String username=excelfunc.excel_read(1,0);
		String password=excelfunc.excel_read(1,1);
		
		lp.uname(username);
		lp.pwd(password);
		lp.btn();
		test.log(Status.PASS, "Login Successful");
										
	}
		
	@Test(dependsOnMethods="login_into")
	public void cart() {
		pp=new product_page(dr);
		// wait for page load
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		// selection Z-A 
		Select s1=new Select(pp.dropdown);
		s1.selectByIndex(1);
		
		// wait for items to load properly
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		// adding items
		pp.clic();
		pp.cartt();
		
		// cart validation
		
		String item=pp.badge.getText().trim();
		int actual=Integer.parseInt(item);
		int exp=1;
		Assert.assertEquals(actual,exp,"Cart is empty");
//		System.out.println("Cart not empty");	
		
		test.log(Status.PASS, "Cart has successfully added an item");
	}
	
	@Test(dependsOnMethods="cart")
	public void cart_checkout() {
		cp=new cart_page(dr);
		
		cp.checkclick();
		test.log(Status.PASS, "Proceeded to checkout page successfully");
	}
	
	@Test(dependsOnMethods="cart_checkout")
	public void final_step() {
		cpp=new checkout_page(dr);
		
		Actions act=new Actions(dr);
		act
		.sendKeys(cpp.name,"jon")
		.sendKeys(Keys.TAB)
		.sendKeys("jones")
		.sendKeys(Keys.TAB)
		.sendKeys("202002")
		.perform();
		
		cpp.done();
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		JavascriptExecutor jse=(JavascriptExecutor) dr;
		jse.executeScript("window.scrollBy(0,500)");		
		
		cpp.fin();
		
		String actual=cpp.text.getText();
		String expected="Thank you for your order!";
		Assert.assertEquals(actual, expected);
		System.out.println("Everything good");
		
		test.log(Status.PASS, "Final confirmation validated successfully");
	
	}	
	
	
	@AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        } else {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        }
    }
	
	 @AfterClass
	    public void tearDown() {
	        dr.quit();
	        extent.flush();
	    }
}