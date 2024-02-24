# ks-chrome-for-testing-support

I have developed a Groovy class that enables users to use [Chrome for Testing](https://developer.chrome.com/blog/chrome-for-testing/) in their test cases in Katalon Studio quickly.

## Problem to solve

As of the 3rd week February 2024, in Katalon Studio, the "Tools > Update WebDriver > Chrome" failed. See https://forum.katalon.com/t/chrome-failed-to-start-exited-normally/119718/17 for the reason why. Consequently I could not run any test cases in Katalon Studio using Chrome browser.

## Solution

I will use "Chrome for Testing" instead of Chrome browser.

- https://developer.chrome.com/blog/chrome-for-testing/

"Chrome for Testing" is a flavor of Chrome browser. It was released in July 2023. I has a special characteristic: it does not auto-upgrade itself. I can keep the "Chrome for Testing" and the associated ChromeDriver to a certain older stable version that I choose. With "Chrome for Testing", I would no longer be disturbed by the frequent upgrade of Chrome and unstable download of ChromeDriver. Of course, I can upgrade the version manually when I want to.

## Solution explained

### Installing Chrome for Testing and ChromeDriver of the version

See [the blog](https://developer.chrome.com/blog/chrome-for-testing?lh=en#how_can_i_get_chrome_for_testing_binaries) for detail.You need ["Node" and "npx"](https://tubemint.com/install-nodejs-npm-npx-yarn/) installed on your machine.

To install a specific version of "Chrome for Testing", run the command

```
$ npx @puppeteer/browsers install chrome@116.0.5793.0
```

To install the corresponding version of "ChromeDriver", run the command

```
$ npx @puppeteer/browsers install chromedriver@116.0.5793.0
```

You can find more detail about the `npx @puppeteer/browsers` command at [the doc page](https://pptr.dev/browsers-api).

The above demo installs an old version `116.0.5793.0`. This just an example. You can specify any available version in the commandline.

How to know the available versions? --- You can check the most recent available versions at https://googlechromelabs.github.io/chrome-for-testing/

![avalilability](https://kazurayam.github.io/ks-chrome-for-testing-support/images/availability.png)

If you just want to get the "latest" one and don't like to be asked to specify a concrete version number, you can type "latest", as:

```
$ npx @puppeteer/browsers install chrome@latest

Downloading chrome r123.0.6312.10 - 165 MB [====================] 100% 0.0s
chrome@123.0.6312.10 /Users/kazurayam/chrome/mac-123.0.6312.10/chrome-mac-x64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing
```

and

```
$ npx @puppeteer/browsers install chromedriver@latest

Downloading chromedriver r123.0.6312.10 - 9.3 MB [==================] 100% 0.0s
chromedriver@123.0.6312.10 /Users/kazurayam/chromedriver/mac-123.0.6312.10/chromedriver-mac-x64/chromedriver
```

It is up to you which version you try.

### Create a custom Groovy class

I developped 2 groovy codes in the `Include/scripts/groovy` directory of a Katalon project:

- [com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory](https://github.com/kazurayam/ks-chrome-for-testing-support/blob/master/Include/scripts/groovy/com/kazurayam/ks/driver/chrome4testing/ChromeForTestingDriverFactory.groovy)
- [com.kazurayam.ks.driver.chrome4testing.Installation](https://github.com/kazurayam/ks-chrome-for-testing-support/blob/master/Include/scripts/groovy/com/kazurayam/ks/driver/chrome4testing/Installation.groovy)


The `Installation` class contains the information in which path you installed the binaries of the "Chrome for Testing" and the ChromeDriver. The code must be customized by you.

The `ChromeForTestingDriverFactory` class is just reusable, I meant.

### Sample Test Case that uses "Chrome for Testing"

See [TC1](https://github.com/kazurayam/ks-chrome-for-testing-support/blob/master/Scripts/TC1/Script1708343560671.groovy)

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

### Headless Chrome for Testing

You can open Chrome for Testing in Headless mode.

See [TC3](https://github.com/kazurayam/ks-chrome-for-testing-support/blob/master/Scripts/TC3_headless/Script1708568445937.groovy)

You want to create a `ChromeOptions` object, give `'--headless'` argument. Then pass it to the `newChromeForTestingDriver(options)` method call.



