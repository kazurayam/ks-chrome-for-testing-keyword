package com.kazurayam.ks.driver.chrome4testing

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

public enum Installation {

	mac_116_0_5793_0_mac_x64(
		"${System.getProperty("user.home")}/chrome/mac-116.0.5793.0/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing",
		"${System.getProperty("user.home")}/chromedriver/mac-116.0.5793.0/chromedriver-mac-x64/chromedriver"),
	mac_121_0_6167_184_mac_x64(
		"${System.getProperty("user.home")}/chrome/mac-121.0.6167.184/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing",
		"${System.getProperty("user.home")}/chromedriver/mac-121.0.6167.184/chromedriver-mac-x64/chromedriver")
	;


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

	public void check() throws FileNotFoundException {
		checkIfFileExists(this.getBrowserPath())
		checkIfFileExists(this.getDriverPath())
	}

	private void checkIfFileExists(String path) throws FileNotFoundException {
		Path f = Paths.get(path)
		boolean exists = Files.exists(f)
		if (!exists) {
			throw new FileNotFoundException(path + " is not present")
		}
	}
}
