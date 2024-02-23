import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory
import com.kazurayam.ks.driver.chrome4testing.Installation
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// specify the path information of browser and driver binaries
ChromeForTestingDriverFactory df =
	new ChromeForTestingDriverFactory(Installation.mac_116_0_5793_0_mac_x64)

// require Headless
ChromeOptions options = new ChromeOptions()
options.addArguments("--headless")

// open a window of "Chrome for Testing"
WebDriver driver = df.newChromeForTestingDriver(options)

// tell Katalon Studio to use this WebDriver instance so that the WebUI keyword can work with it
DriverFactory.changeWebDriver(driver)

// your ordinary katalon life begins here

WebUI.navigateToUrl("http://demoaut.katalon.com/")
WebUI.delay(3)
WebUI.closeBrowser()
