package mappTask;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class Selenium {

    public WebDriver createWebDriver() {
        return createWebDriver(FIREFOX);
    }

    public WebDriver createWebDriver(String browser) {
        if (FIREFOX.equals(browser)) {
            return createFirefoxWebDriver();
        } else {
            throw new UnsupportedOperationException("Cannot create " + browser + " browser");
        }
    }

    private WebDriver createFirefoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        return new FirefoxDriver(new FirefoxProfile());
    }

    public static Object runJavaScript(WebDriver webDriver, String javaScriptCode) {
        JavascriptExecutor js;
        if (webDriver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) webDriver;
        } else {
            throw new UnsupportedOperationException("Cannot run java script on webDriver");
        }
        return js.executeScript(javaScriptCode);
    }

    public static String extractColorFromStyle(WebElement firstBox) {
        return firstBox.getAttribute("style").replaceFirst(".*background: *", "").replaceFirst("[; ].*", "");
    }

    public static boolean isElementPresent(WebDriver webDriver, By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    public static boolean isElementVisible(WebDriver webDriver, By by) {
        try {
            WebElement webElement = webDriver.findElement(by);
            return webElement.isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    public static void safeClickElement(WebDriver webDriver, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, 11, 250);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        webElement.click();
    }
}
