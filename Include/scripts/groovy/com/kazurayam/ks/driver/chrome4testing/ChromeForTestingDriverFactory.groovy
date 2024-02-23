package com.kazurayam.ks.driver.chrome4testing

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.webui.driver.DriverFactory

public class ChromeForTestingDriverFactory {

	private Installation installation;

	public ChromeForTestingDriverFactory() {
		this(Installation.mac_116_0_5793_0_mac_x64)
	}

	public ChromeForTestingDriverFactory(Installation installation) {
		this.installation = installation
	}

	public WebDriver newChromeForTestingDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		return newChromeForTestingDriver(chromeOptions)
	}

	public WebDriver newChromeForTestingDriver(ChromeOptions chromeOptions) throws IOException {
		// check if the path information specified is OK or not
		installation.check()
		
		// set the path of ChromeDriver binary
		System.setProperty("webdriver.chrome.driver", installation.getDriverPath());
		
		// set the path of "Chrome for Tesing" binary
		chromeOptions.setBinary(this.installation.getBrowserPath())
		
		System.out.println("Chrome installaton: " + installation.toString())
		
		// open a browser window
		WebDriver driver = new ChromeDriver(chromeOptions)
		
		return driver
	}

}
