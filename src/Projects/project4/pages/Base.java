package Projects.project4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Projects.project4.utilities.Driver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Base {

    public WebDriver driver = Driver.getDriver();;
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));

    protected void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeysToElement(WebElement element, String key) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(key);
    }

    protected String getTextOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected void selectFromDropDownMenuByIndex(WebElement dropDownMenu, int index) {
        Select select = new Select(dropDownMenu);
        select.selectByIndex(index);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void quitDriver() {
        Driver.quitDriver();
    }
}
