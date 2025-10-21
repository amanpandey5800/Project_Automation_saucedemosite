package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product_page {
	
	WebDriver dr;
	

	public product_page(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	public
	WebElement dropdown;
	
	
	@FindBy(xpath="//div[@class='inventory_item'][1]//button")
	WebElement add;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']")
	WebElement cart;
	
	public
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement badge;
	
	public void clic() {
		add.click();
		
	}
	public void cartt() {
		cart.click();
	}
	
}
