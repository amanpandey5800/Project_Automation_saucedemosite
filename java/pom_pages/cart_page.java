package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cart_page {
	
	WebDriver dr;
	
	public  cart_page(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout;
	
	public void checkclick() {
		checkout.click();
	}
	

}
