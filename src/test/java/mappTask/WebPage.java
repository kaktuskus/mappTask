package mappTask;

import org.openqa.selenium.WebDriver;

public class WebPage {

    protected final WebDriver webDriver;

    public WebPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
