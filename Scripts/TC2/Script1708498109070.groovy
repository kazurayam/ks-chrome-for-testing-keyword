import org.openqa.selenium.WebDriver

import com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory
import com.kazurayam.ks.driver.chrome4testing.Installation

import com.kms.katalon.core.util.KeywordUtil

// I expect this will trhow an exception as I do not have this version installed
ChromeForTestingDriverFactory df =
	new ChromeForTestingDriverFactory(Installation.mac_121_0_6167_184_mac_x64)

try {
	WebDriver driver = df.newChromeForTestingDriver()
	KeywordUtil.markFailed("Here I expect a FileNotFoundException to be thrown, but actually not");
} catch (FileNotFoundException e) {
	;   // as expected
}