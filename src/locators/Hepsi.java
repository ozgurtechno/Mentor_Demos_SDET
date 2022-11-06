package locators;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hepsi extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("https://www.hepsiburada.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();


        WebElement picture = driver.findElement(By.xpath("//img[contains(@src,'thumbnailImage2122_20221104103149' )]"));
        action.scrollToElement(picture).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(picture)).click();



    }
}
