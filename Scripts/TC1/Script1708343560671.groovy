import org.openqa.selenium.WebDriver

import com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory
import com.kazurayam.ks.driver.chrome4testing.Installation
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

ChromeForTestingDriverFactory driverFactory =
    new ChromeForTestingDriverFactory(Installation.mac_116_0_5793_0)
WebDriver driver = driverFactory.newChromeForTestingDriver()
DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl("http://demoaut.katalon.com/")
WebUI.delay(3)
WebUI.closeBrowser()
