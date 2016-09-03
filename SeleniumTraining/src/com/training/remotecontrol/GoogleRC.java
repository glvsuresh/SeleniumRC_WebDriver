package com.training.remotecontrol;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class GoogleRC {
	
	
    public Selenium oBrowser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GoogleRC oTest=new GoogleRC();
		oTest.searchGoogle();

	}
	
	/* *firefox
	 * *iexplore
	 * *googlechrome
	 */
	
	public void searchGoogle()
	{
		oBrowser=new DefaultSelenium("localhost", 4444, "*googlechrome", "https://www.google.com");
		
		oBrowser.start();
		oBrowser.open("/");
		oBrowser.type("id=lst-ib", "Selenium");
		oBrowser.click("name=btnG");
		oBrowser.stop();
	}
	

}
