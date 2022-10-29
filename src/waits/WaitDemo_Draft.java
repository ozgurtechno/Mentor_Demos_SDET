package waits;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class WaitDemo_Draft extends BaseStaticDriver {

    @Test
    public void T01_FirstFailedSeleniumWaitTest() {

        driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Get the selected date text before AJAX call
        String selectedDateTextBeforeAjaxCall = driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextBeforeAjaxCall to the console
        System.out.println("selectedDateTextBeforeAjaxCall: " + selectedDateTextBeforeAjaxCall + "\n");

        //Find 3rd Day on the calendar
        WebElement thirdDayOfMonth = driver.findElement(By.xpath(".//*[contains(@class, 'rcRow')]/td/a[.='3']"));

        //Click 3rd Day
        thirdDayOfMonth.click();

        //Get the selected date text after AJAX call
        String selectedDateTextAfterAjaxCall = driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextAfterAjaxCall to the console
        System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall + "\n");

        //Check the Actual and Expected Text
        Assert.assertEquals("Wednesday, August 3, 2022", selectedDateTextAfterAjaxCall);

        driver.quit();
    }


}

