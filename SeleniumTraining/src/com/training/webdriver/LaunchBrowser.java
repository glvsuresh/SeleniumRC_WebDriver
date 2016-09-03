package com.training.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {

	public WebDriver oBrowser;
	public static String sBrowserName="ff";
	public static String sURL="http://www.google.com";
	
	

	public static void main(String[] args) {
		LaunchBrowser oTest = new LaunchBrowser();
		oTest.openBrowser(sBrowserName);
		oTest.navigateToURL(sURL);
		oTest.closeBrowser();
		oTest.launchIE();
		oTest.launchChrome();
		oTest.launchFirefox();
	}

	public void launchIE() {
		System.setProperty("webdriver.ie.driver",
				"E:/SeleniumLibs/IEDriverServer.exe");
		oBrowser = new InternetExplorerDriver();
		oBrowser.get("http://www.google.com");
	}

	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver",
				"E:/SeleniumLibs/chromedriver.exe");
		oBrowser = new ChromeDriver();
		oBrowser.get("http://www.google.com");
	}

	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver",
				"E:/SeleniumLibs/geckodriver.exe");
		oBrowser = new FirefoxDriver();
		oBrowser.get("http://www.google.com");
	}

	public void openBrowser(String sBrowserName) {
		switch (sBrowserName.toUpperCase()) {
		case "IE":
		case "INTERNET EXPLORER": {
			System.setProperty("webdriver.ie.driver",
					"E:/SeleniumLibs/IEDriverServer.exe");
			oBrowser = new InternetExplorerDriver();
			break;
		}
		case "CHROME": {
			System.setProperty("webdriver.chrome.driver",
					"E:/SeleniumLibs/chromedriver.exe");
			oBrowser = new ChromeDriver();
			break;
		}
		case "FF":
		case "FIREFOX": {
			System.setProperty("webdriver.gecko.driver",
					"E:/SeleniumLibs/geckodriver.exe");
			oBrowser = new FirefoxDriver();
			oBrowser.get("http://www.google.com");
		}
		default: {
			System.setProperty("webdriver.chrome.driver",
					"E:/SeleniumLibs/chromedriver.exe");
			oBrowser = new ChromeDriver();
			break;
		}
		}
	}

	public void navigateToURL(String sURL) {
		//First Way to navigate
		oBrowser.get(sURL);
		//Second way to navigate
		oBrowser.navigate().to(sURL);
		oBrowser.navigate().back();
		oBrowser.navigate().forward();
		oBrowser.navigate().refresh();
		oBrowser.manage().window().maximize();
	}
	
	
	

	public void closeBrowser() {
		oBrowser.close();
		oBrowser.quit();
	}

}
