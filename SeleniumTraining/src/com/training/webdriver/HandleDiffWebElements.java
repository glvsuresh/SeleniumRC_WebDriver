package com.training.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class HandleDiffWebElements extends LaunchBrowser {

	public static void main(String[] args) throws InterruptedException,
			IOException {
		// TODO Auto-generated method stub
		// "http://www.salesforce.com"
		//String sURL = "https://www.facebook.com/";
		// String sURL="http://www.w3schools.com/html/html_tables.asp";
		// String sURL="http://www.rediff.com/";
		// String sURL = "http://www.hdfcbank.com/";
	    //String sURL="http://www.webreference.com/programming/javascript/mk/column2/index.html";
		//String sURL="https://gojs.net/latest/samples/htmlDragDrop.html";
		String sURL="http://interactjs.io/";
	    // String sURL="http://www.google.com";
		HandleDiffWebElements oTest = new HandleDiffWebElements();
		oTest.openBrowser("chrome");
		oTest.navigateToURL(sURL);
		// oTest.LoginToSalesForce();
		// oTest.RegisterUserFaceBook();
		// oTest.getAllLinksFromGoogle();
		// oTest.readDataFromWebTable();
		// oTest.handleAlert();
		// oTest.handleFrames();
		// oTest.navigateToHdfcBank();
		// oTest.mouseOverActions();
		// oTest.takeScreenshot();
		// oTest.launchFirefoxProfile();
		 oTest.dragAnddrop();
		//oTest.clickOnElemUsingJavaScript();
	}

	public void loginToSalesForce(String sUserName, String sPassword) {
		try {
			/*
			 * Entering the Value into TextBox Clicking on a button Check the
			 * check box Clicking on Radio Button Selecting List box values
			 * Clicking on a Link
			 */

			WebElement oBtnLogin = oBrowser.findElement(By.id("button-login"));
			oBtnLogin.click();
			WebElement edtUserName = oBrowser.findElement(By.name("username"));
			edtUserName.sendKeys(sUserName);
			WebElement edtPassword = oBrowser.findElement(By.name("pw"));
			edtPassword.sendKeys(sPassword);
			WebElement chkRemember = oBrowser.findElement(By.id("rememberUn"));
			chkRemember.click();
			WebElement btnSignIn = oBrowser.findElement(By.id("Login"));
			btnSignIn.click();

			/*
			 * oBrowser.findElement(By.id("button-login")).click();
			 * oBrowser.findElement
			 * (By.name("username")).sendKeys("suresh.gorantla@qa.com");
			 * oBrowser.findElement(By.name("pw")).sendKeys("Berkley@123");
			 * oBrowser.findElement(By.id("Login")).click();
			 * oBrowser.findElement(By.id("rememberUn")).click();
			 */

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
	}

	public void RegisterUserFaceBook() {
		try {
			oBrowser.findElement(By.name("firstname")).sendKeys("TestFN");
			oBrowser.findElement(By.name("lastname")).sendKeys("TestLN");
			oBrowser.findElement(By.name("reg_email__")).sendKeys(
					"tester.demo@gmail.com");
			oBrowser.findElement(By.name("reg_email_confirmation__")).sendKeys(
					"tester.demo@gmail.com");
			oBrowser.findElement(By.name("reg_passwd__")).sendKeys(
					"password1234");

			// Find the ListBox
			// Get all the values
			// Iterate through all values and print it
			// One method
			WebElement lstMonth = oBrowser.findElement(By
					.name("birthday_month"));
			/*
			 * List<WebElement>
			 * oAllMonths=lstMonth.findElements(By.tagName("option"));
			 * for(WebElement oMonth:oAllMonths) {
			 * System.out.println(oMonth.getText());
			 * if(oMonth.getText().equalsIgnoreCase("Aug")) { oMonth.click();
			 * 
			 * break; } }
			 */

			// Second way
			Select oMonth = new Select(lstMonth);
			oMonth.selectByVisibleText("Aug");

			WebElement lstDay = oBrowser.findElement(By.name("birthday_day"));
			/*
			 * List<WebElement>
			 * oAllDays=lstDay.findElements(By.tagName("option"));
			 * for(WebElement oDay:oAllDays) {
			 * System.out.println(oDay.getText());
			 * if(oDay.getText().equalsIgnoreCase("27")) { oDay.click(); break;
			 * } }
			 */

			Select oDay = new Select(lstDay);
			oDay.selectByVisibleText("21");

			WebElement lstYear = oBrowser.findElement(By.name("birthday_year"));
			/*
			 * List<WebElement>
			 * oAllYears=lstYear.findElements(By.tagName("option"));
			 * for(WebElement oYear:oAllYears) {
			 * System.out.println(oYear.getText());
			 * if(oYear.getText().equalsIgnoreCase("2013")) { oYear.click();
			 * break; } }
			 */

			Select oYr = new Select(lstYear);
			oYr.selectByVisibleText("2013");
			Thread.sleep(1000L);
			oBrowser.findElement(By.id("u_0_e")).click();
			oBrowser.findElement(By.name("websubmit")).click();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Test case got failed");
		}
	}

	public void getAllLinksFromGoogle() {
		List<WebElement> oAllLinks = oBrowser.findElements(By.tagName("a"));
		System.out.println("No. of Links available on Google is "
				+ oAllLinks.size());
		for (WebElement oLink : oAllLinks) {
			System.out.println(oLink.getText());
		}
		oBrowser.findElement(By.linkText("Sign in")).click();
		oBrowser.navigate().back();
		System.out.println("Navigated back successfully");
		oBrowser.findElement(By.partialLinkText("Sign")).click();
	}

	public void readDataFromWebTable() {
		// Get the table
		// Get the rows in a table
		// Get the columns for each row
		// Print the text

		WebElement oCustTable = oBrowser.findElement(By.id("customers"));
		List<WebElement> oAllRows = oCustTable.findElements(By.tagName("tr"));
		System.out.println("Number of rows is Table is " + oAllRows.size());
		List<WebElement> oTblHdrs = oAllRows.get(0).findElements(
				By.tagName("th"));
		for (WebElement oHdr : oTblHdrs) {
			System.out.println(oHdr.getText());
		}
		for (WebElement oRow : oAllRows) {
			List<WebElement> oAllCols = oRow.findElements(By.tagName("td"));
			System.out.println("No of Columns available is " + oAllCols.size());
			String sText = "";
			for (int i = 0; i < oAllCols.size(); i++) {
				sText = sText + "========" + oAllCols.get(i).getText();

			}
			System.out.println(sText);

			for (WebElement oCol : oAllCols) {

				System.out.println(oCol.getText());
			}
		}
	}

	public void handleAlert() throws InterruptedException {
		try {
			oBrowser.findElement(By.partialLinkText("Sign")).click();
			Thread.sleep(10000L);
			oBrowser.findElement(By.name("proceed")).click();
			Alert oAlert = oBrowser.switchTo().alert();
			System.out.println(oAlert.getText());
			oAlert.accept();
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
	}

	public void handleFrames() {
		oBrowser.switchTo().frame("moneyiframe");
		oBrowser.findElement(By.name("query")).sendKeys("MSFT");
		oBrowser.findElement(By.className("mw001-widget-getquote-btn")).click();

	}

	public void navigateToHdfcBank() {
		try {
			oBrowser.findElement(By.xpath("(//img[@alt='Close'])[3]")).click();
			oBrowser.findElement(By.id("loginsubmit")).click();
			handleWindows();
			oBrowser.findElement(By.xpath("//img[@alt='Continue']")).click();
			oBrowser.switchTo().defaultContent();

		} catch (Exception e) {
			// TODO: handle exception

			System.out
					.println("There is an error occured in performing this action");
		}
	}

	public void handleWindows() {
		System.out.println(oBrowser.getWindowHandle().toString());

		Set<String> oHWnds = oBrowser.getWindowHandles();
		for (String oHwnd : oHWnds) {
			oBrowser.switchTo().window(oHwnd);

		}
	}

	public void launchFirefoxProfile() {
		System.setProperty("webdriver.gecko.driver",
				"E:/SeleniumLibs/geckodriver.exe");
		ProfilesIni oProfile = new ProfilesIni();
		FirefoxProfile oFFProfile = oProfile.getProfile("SeleniumTester");
		oBrowser = new FirefoxDriver(oFFProfile);
		/*
		 * FirefoxProfile oFFProfile1=oProfile.getProfile("Default");
		 * oBrowser=new FirefoxDriver(oFFProfile1);
		 */
	}

	public void mouseOverActions() throws InterruptedException {
		oBrowser.findElement(By.xpath("(//img[@alt='Close'])[3]")).click();
		Actions oMouse = new Actions(oBrowser);
		oMouse.moveToElement(
				oBrowser.findElement(By.linkText("Making payments"))).build()
				.perform();
		Thread.sleep(10000);

	}

	public void takeScreenshot() throws IOException {
		File ScrFile = ((TakesScreenshot) oBrowser)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScrFile, new File("E:\\SeleniumTraining\\Demo.png"));

	}

	public void dragAnddrop() {
		Actions oMouse = new Actions(oBrowser);
		
		/*WebElement src = oBrowser.findElement(By.id("Item2"));
		WebElement tgt = oBrowser.findElement(By.id("Item5"));
		oMouse.dragAndDrop(src, tgt).build().perform();
		oMouse.clickAndHold(src).moveToElement(tgt).release(tgt).build().perform();
		WebElement oSrc=oBrowser.findElement(By.xpath("//div[text()='Tea']"));
		WebElement oTgt=oBrowser.findElement(By.xpath("//div[@id='myDiagramDiv']/div"));
		oMouse.dragAndDrop(oSrc, oTgt).build().perform();
		oMouse.clickAndHold(oSrc).build().perform();
		oMouse.moveToElement(oTgt).build().perform();
		oMouse.release(oTgt).perform();*/
		WebElement src = oBrowser.findElement(By.id("no-drop"));
		WebElement tgt = oBrowser.findElement(By.id("inner-dropzone"));
		oMouse.dragAndDrop(src, tgt).build().perform();
		
		
		
	}


	public void waitUntil() {
		WebDriverWait oWait = new WebDriverWait(oBrowser, 60);
		oWait.until(ExpectedConditions.visibilityOf(oBrowser.findElement(By
				.id("lst-ib"))));
		oWait.until(ExpectedConditions.alertIsPresent());
	}

	public void fluentWait() {
		Wait<WebDriver> oWait = new FluentWait<WebDriver>(oBrowser)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		oWait.until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver oDriver) {
				return oDriver.findElement(By.id("")).isDisplayed();
			}
		});
	}
	
	public void pauseScript(int iSec)
	{
		try {
			Thread.sleep(iSec*1000);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void clickOnElemUsingJavaScript() {
		JavascriptExecutor oJs = (JavascriptExecutor) oBrowser;
		System.out.println(oJs.executeScript("return document.title;")
				.toString());
		WebElement oElem = oBrowser.findElement(By.id("u_0_n"));
		oJs.executeScript("arguments[0].click()", oElem);
	}

	public void scrollIntoViewUsingJavaScript() {
		JavascriptExecutor oJs = (JavascriptExecutor) oBrowser;
		WebElement oElem = oBrowser.findElement(By.id("u_0_n"));
		oJs.executeScript("arguments[0].scrollIntoView(true);", oElem);
	}

	public void handleExceptions() {
		try {

		} catch (NoSuchElementException e) {

		} catch (StaleElementReferenceException e1) {

		} catch (TimeoutException e2) {

		} catch (ElementNotVisibleException e3) {

		}
	}

}