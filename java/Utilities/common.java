package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class common {
	public WebDriver dr;
	
	public void launch(String url) {
		dr=new FirefoxDriver();
		dr.get(url);
		dr.manage().window().maximize();
	}

}
