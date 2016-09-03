package com.training.remotecontrol;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class GoogleSearchUsingJunit {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome", "https://www.google.com/");
		selenium.start();
	}

	@Test
	public void testGoogleSearchRC() throws Exception {
		// This is Google Search Test case
		selenium.open("/");
		selenium.type("id=lst-ib", "automation");
		selenium.click("name=btnG");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
