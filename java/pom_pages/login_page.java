package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	
	WebDriver dr;
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement user_name;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement button;
	
	public login_page(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	public void uname(String un) {
		user_name.sendKeys(un);
	}
	
	public void pwd(String pd) {
		password.sendKeys(pd);
	}
	
	public void btn() {
		button.click();
	}

}
