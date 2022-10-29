package waits;

import Utils.BaseStaticDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class WaitDemo extends BaseStaticDriver {

    @Test
    public void T01_FirstFailedSeleniumWaitTest() {

        driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Declare a Webdriver Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Wait until presence of container
        wait.until(driver -> ExpectedConditions.presenceOfElementLocated(By.cssSelector(".demo-container.size-narrow")).apply(driver));

        //Get the selected date text before AJAX call
        String selectedDateTextBeforeAjaxCall = driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextBeforeAjaxCall to the console
        System.out.println("selectedDateTextBeforeAjaxCall: " + selectedDateTextBeforeAjaxCall + "\n");

        //Find 3rd Day on the calendar
        WebElement thirdDayOfMonth = driver.findElement(By.xpath(".//*[contains(@class, 'rcRow')]/td/a[.='3']"));

        //Click 3rd Day
        thirdDayOfMonth.click();

        //Wait until invisibility of loader
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver -> ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")).apply(driver));
        //Wait until visibility of selected date text
        //Actually it is not necessary, I added this control to see an example of visibilityOfElementLocated usage.
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver ->
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).apply(driver));

        //Get the selected date text after AJAX call
        String selectedDateTextAfterAjaxCall = driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextAfterAjaxCall to the console
        System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall + "\n");

        //Check the Actual and Expected Text
        Assert.assertEquals("Wednesday, August 3, 2022", selectedDateTextAfterAjaxCall);

        driver.quit();
    }


}

