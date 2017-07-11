package mappTask;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MappTaskTest {
    private WebDriver webDriver;
    private MappTaskPage page;

    @BeforeClass
    public void beforeClass() {
        Selenium selenium = new Selenium();
        webDriver = selenium.createWebDriver();
        webDriver.get("http://timvroom.com/selenium/playground/");
    }

    @AfterClass
    public void afterClass() {
        webDriver.close();
    }

    //    @BeforeTest
    public void beforeTest() {
        page = new MappTaskPage(webDriver);
    }

    @Test
    public void task01() {
        beforeTest();
        String title = page.getTitle();
        System.out.println("title: " + title);
        page.fillInAnswer1(title);
    }

    @Test
    public void task02() {
        beforeTest();
        page.fillInFormName("Kilgore Trout");
    }

    @Test
    public void task03() {
        beforeTest();
        page.selectOccupationByText("Science Fiction Author");
    }

    @Test
    public void task04() {
        beforeTest();
        int blueBoxCount = page.findAllBlueBoxes().size();
        page.fillInAnswer4("" + blueBoxCount);
    }

    @Test
    public void task05() {
        beforeTest();
        page.clickLinkClickMe();
    }

    @Test
    public void task06() {
        beforeTest();
        String classAttribute = page.findRedBox().getAttribute("class");
        page.fillInAnswer6(classAttribute);
    }

    @Test
    public void task07() {
        beforeTest();
        Selenium.runJavaScript(webDriver, "ran_this_js_function();");
    }

    @Test
    public void task08() {
        beforeTest();
        Long jsOutput = (Long) Selenium.runJavaScript(webDriver, "return got_return_from_js_function();");
        page.fillInAnswer8(jsOutput.toString());
    }

    @Test
    public void task09() {
        beforeTest();
        page.markFormWroteBook(true);
    }

    @Test
    public void task10() {
        beforeTest();
        String redBoxText = page.findRedBox().getText();
        page.fillInAnswer10(redBoxText);
    }

    @Test
    public void task11() {
        beforeTest();
        WebElement firstBox = page.findFirstArrangedBox();
        page.fillInAnswer11(Selenium.extractColorFromStyle(firstBox));
    }

    @Test
    public void task12() {
        beforeTest();
        webDriver.manage().window().setSize(new Dimension(850, 650));
    }

    @Test
    public void task13() {
        beforeTest();
        page.fillInAnswer13(Selenium.isElementPresent(webDriver, By.id("ishere")) ? "yes" : "no");
    }

    @Test
    public void task14() {
        beforeTest();
        page.fillInAnswer14(Selenium.isElementVisible(webDriver, By.id("purplebox")) ? "yes" : "no");
    }

    @Test
    public void task15() {
        beforeTest();
        page.clickLinkClickThenWait();
        page.clickLinkClickAfterWait();
    }

    @Test
    public void task16() {
        beforeTest();
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void task17() {
        beforeTest();
        page.clickSubmitButton();
    }

}
