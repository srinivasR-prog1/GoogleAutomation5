package com.docker.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String BROWSER) throws MalformedURLException {

/*      String host = "localhost";
	 String HUB_HOST = "selenium-hub";
      
   //   String HUB_HOST = null;
*/		
	    String host = "selenium-hub";
	  
/*	  if(HUB_HOST  != null)
	  {
		   host=HUB_HOST;
		   System.out.println("Remote host :"+host);
	  }*/

		DesiredCapabilities dc = new DesiredCapabilities();

		if (BROWSER.equalsIgnoreCase("chrome")) {

			dc.setBrowserName(BrowserType.CHROME);

		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			dc.setBrowserName(BrowserType.FIREFOX);

		}
		
		
		
		String completeURL = "http://"+host+":4444/wd/hub";

		/*
		 * if (browserName.equals("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * } else if (browserName.equals("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new
		 * FirefoxDriver(); }
		 */

		driver = new RemoteWebDriver(new URL(completeURL), dc);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
