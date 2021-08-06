package com.tokyotreat.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.tokyotreat.Utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static JavascriptExecutor jse;
	public static Logger logger;

	public BaseClass() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src\\main\\java\\com\\tokyotreat\\config\\config.properities");
			
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@BeforeClass
	public void LoggerSetup() {
		logger = logger.getLogger(BaseClass.class);

		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);

	}

	public static void intialisation() {
		String browser = prop.getProperty("browser");
		
		
		if (browser.equals("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
driver.manage().window().maximize();

driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
		
	}
	public void waitForDocumentCompleteState(int secondsToWait) {
		new WebDriverWait(driver, secondsToWait).until((ExpectedCondition<Boolean>) wd -> {

			while (true) {
				String readyState = getDocumentReadyState();

				if (readyState.equals("complete")) {
					logger.info("Document Ready State is : " + readyState);
					return true;
				} else {
					logger.info("Document is not in Ready State : " + readyState);
				}

			}
		});
	}

	private String getDocumentReadyState() {
		jse = (JavascriptExecutor) driver;
		try {
			return jse.executeScript("return document.readyState").toString();

		} catch (WebDriverException e) {
			return null;
		}

	}
}
