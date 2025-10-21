package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout_page {
	WebDriver dr;
	
	public  checkout_page(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
		
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	public
	WebElement name;
	
	@FindBy(xpath="//input[@name='continue']")
	WebElement clickk;
	
	public void done() {
		clickk.click();
	}
	
	
	// finish button
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish;
	public void fin() {
		finish.click();
	}
	
	@FindBy(xpath="//h2[@class='complete-header']")
	public
	WebElement text;
	
	
	
}
