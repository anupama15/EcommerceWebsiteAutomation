package com.ecommerce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ecommerce.qa.util.TestUtil;
import com.ecommerce.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
	public TestBase() throws FileNotFoundException, IOException{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Anupama Work\\Anupama_work\\Automation_SelJava\\EcommerseWebsitePractice\\src\\main\\java\\com\\ecommerce\\qa\\config\\config.properties");
		prop.load(ip);
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Anupama Work/Anupama_work/Automation_SelJava/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:/Anupama Work/Anupama_work/Automation_SelJava/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
	e_driver=new EventFiringWebDriver(driver);
		
		try {
			eventListener=new WebEventListener();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty(("url")));
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
