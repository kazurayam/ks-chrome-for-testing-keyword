package com.kazurayam.ks.driver.chrome4testing

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.webui.driver.DriverFactory

public class ChromeForTestingDriverFactory {
	
	private Installation installation = Installation.mac_116_0_5793_0;

	public ChromeForTestingDriverFactory(Installation installation) {
		this.installation = installation
	}

	public WebDriver newChromeForTestingDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		return newChromeForTestingDriver(chromeOptions)
	}

	public WebDriver newChromeForTestingDriver(ChromeOptions chromeOptions) {
		setSystemProperty(installation)
		chromeOptions.setBinary(this.installation.getBrowserPath())
		println "Chrome installaton: " + installation.toString()
		//
		WebDriver driver = new ChromeDriver(chromeOptions)
		return driver
	}
	
	private void setSystemProperty(Installation installation) {
		System.setProperty("webdriver.chrome.driver", installation.getDriverPath());
	}
	
}
