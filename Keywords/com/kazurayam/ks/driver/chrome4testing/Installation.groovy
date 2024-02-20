package com.kazurayam.ks.driver.chrome4testing

public enum Installation {

	mac_116_0_5793_0(
	"${System.getProperty("user.home")}/chrome/mac-116.0.5793.0/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing",
	"${System.getProperty("user.home")}/chromedriver/mac-116.0.5793.0/chromedriver-mac-x64/chromedriver");


	private String browserPath;
	private String driverPath;

	private Installation(String browserPath, String driverPath) {
		this.browserPath = browserPath;
		this.driverPath = driverPath;
	}

	public String getBrowserPath() {
		return browserPath
	}

	public String getDriverPath() {
		return driverPath
	}

	public String toString() {
		return "{\"browserPath\":\"${browserPath}\", \"driverPath\":\"${driverPath}\"}"
	}
}
