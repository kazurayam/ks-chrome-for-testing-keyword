# ks-chrome-for-testing-keyword

I have developed a Groovy class that enables users to use [Chrome for Testing](https://developer.chrome.com/blog/chrome-for-testing/) in their test cases in Katalon Studio quickly.

## Problem to solve

As of the 3rd week February 2024, in Katalon Studio, the "Tools > Update WebDriver > Chrome" failed. See https://forum.katalon.com/t/chrome-failed-to-start-exited-normally/119718/17 for the reason why. Consequently I could not run any test cases in Katalon Studio using Chrome browser.

## Solution

I would use "Chrome for Testing" instead of Chrome browser.

- https://developer.chrome.com/blog/chrome-for-testing/

"Chrome for Testing" does not auto-upgrade. I can keep the version of "Chrome for Testing" and ChromeDriver to be fixed to a older stable version. I would be no longer disturbed by the frequent upgrade of Chrome and unstable download of ChromeDriver.

## Solution explained

### Installing Chrome for Testing and ChromeDriver of the version

You need "Node" and "npx" installed on your machine.

To install a specific version of "Chrome for Testing", run the command

```
$ npx @puppeteer/browsers install chrome@116.0.5793.0
```

To install the corresponding version of "ChromeDriver", run the command

```
$ npx @puppeteer/borwsers install chromedriver@116.0.5793.0
```

I would fix the version of "Chrome for Testing" on my machine to this old version. I would not need any newer Chrome for my testings.

### Create a custom Groovy class

I developped 2 groovy codes at

- [com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory](https://github.com/kazurayam/ks-chrome-for-testing-keyword/blob/master/Keywords/com/kazurayam/ks/driver/chrome4testing/ChromeForTestingDriverFactory.groovy)
- [com.kazurayam.ks.driver.chrome4testing.Installation](https://github.com/kazurayam/ks-chrome-for-testing-keyword/blob/master/Keywords/com/kazurayam/ks/driver/chrome4testing/Installation.groovy)


The `Installation` class contains the information in which path you installed the binaries of the "Chrome for Testing" and the ChromeDriver. The code must be customized by you.

The `ChromeForTestingDriverFactory` class is just reusable, I meant.

### Test Case example that uses "Chrome for Testing"

See [TC1](https://github.com/kazurayam/ks-chrome-for-testing-keyword/blob/master/Scripts/TC1/Script1708343560671.groovy)

Let me copy&paste the source here:

```
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
```

This test case will run using Chrome for Testing version 116.0.5793.0.
