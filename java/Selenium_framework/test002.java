package Selenium_framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Utilities.common;
import pom_pages.login_page;
import testdata.excelfunc;

public class test002 extends common{
	
	login_page lp;
	@Test
	public void all_links() throws IOException {
		
		
		launch("https://www.saucedemo.com");
		lp=new login_page(dr);
		String username=excelfunc.excel_read(1, 0);
		String password=excelfunc.excel_read(1, 1);
		
		lp.uname(username);
		lp.pwd(password);
		lp.btn();
		
		
		List<WebElement> links=dr.findElements(By.tagName("a"));
		System.out.println("=======================================================================");
		System.out.println("Total Links Found ==  " + links.size());
		System.out.println("=======================================================================\n");
		
		for(WebElement link : links) {
			System.out.println(link.getText() + " \n " + link.getAttribute("href"));
			
		}
		
	}
	@AfterClass
	public void endd() {
		dr.close();
	}

}
