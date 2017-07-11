package mappTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MappTaskPage extends WebPage {

    @FindBy(id = "name")
    private WebElement formName;
    @FindBy(id = "occupation")
    private WebElement formOccupation;
    @FindBy(id = "submitbutton")
    private WebElement submitButton;
    @FindBy(xpath = "//span[contains(@style,'background:#00f')]")
    private List<WebElement> blueBoxes;
    @FindBy(linkText = "click me")
    private WebElement linkClickMe;
    @FindBy(xpath = "//span[contains(@style,'background:#f00')]")
    private WebElement redBox;
    @FindBy(xpath = "//input[@value='wrotebook']")
    private WebElement formWroteBook;
    @FindBy(xpath = "//input[@value='didntwritebook']")
    private WebElement formDidntWroteBook;
    @FindBy(xpath = "//h3[text()='Boxes to check arrangement of']/following-sibling::span[1]")
    private WebElement firstArrangedBox;
    @FindBy(linkText = "click then wait")
    private WebElement linkClickThenWait;
    private By linkClickAfterWaitLocator = By.linkText("click after wait");

    @FindBy(id = "answer1")
    private WebElement answer1;
    @FindBy(id = "answer4")
    private WebElement answer4;
    @FindBy(id = "answer6")
    private WebElement answer6;
    @FindBy(id = "answer8")
    private WebElement answer8;
    @FindBy(id = "answer10")
    private WebElement answer10;
    @FindBy(id = "answer11")
    private WebElement answer11;
    @FindBy(id = "answer13")
    private WebElement answer13;
    @FindBy(id = "answer14")
    private WebElement answer14;

    public MappTaskPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void fillInFormName(String text) {
        formName.sendKeys(text);
    }

    public void selectOccupationByText(String text) {
        Select select = new Select(formOccupation);
        select.selectByVisibleText(text);
    }

    public List<WebElement> findAllBlueBoxes() {
        return blueBoxes;
    }

    public void clickLinkClickMe() {
        linkClickMe.click();
    }

    public WebElement findRedBox() {
        return redBox;
    }

    public void markFormWroteBook(boolean wroteBook) {
        WebElement radio;
        if (wroteBook) {
            radio = formWroteBook;
        } else {
            radio = formDidntWroteBook;
        }
        if (!radio.isSelected()) {
            radio.click();
        }
    }

    public WebElement findFirstArrangedBox() {
        return firstArrangedBox;
    }

    public void clickLinkClickThenWait() {
        linkClickThenWait.click();
    }

    public void clickLinkClickAfterWait() {
        Selenium.safeClickElement(webDriver, linkClickAfterWaitLocator);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void fillInAnswer1(String text) {
        answer1.sendKeys(text);
    }

    public void fillInAnswer4(String text) {
        answer4.sendKeys(text);
    }

    public void fillInAnswer6(String text) {
        answer6.sendKeys(text);
    }

    public void fillInAnswer8(String text) {
        answer8.sendKeys(text);
    }

    public void fillInAnswer10(String text) {
        answer10.sendKeys(text);
    }

    public void fillInAnswer11(String text) {
        answer11.sendKeys(text);
    }

    public void fillInAnswer13(String text) {
        answer13.sendKeys(text);
    }

    public void fillInAnswer14(String text) {
        answer14.sendKeys(text);
    }

}
