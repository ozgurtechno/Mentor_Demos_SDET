package waits;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Waits extends BaseStaticDriver {

    public static void main(String[] args) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/dynamic-properties");

        // Bazi elemanlar DOM da olmasina ragmen ENABLE degildir...
        WebElement element = driver.findElement(By.cssSelector("#enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#enableAfter")));

        // Bazi elemanlar belirli kosullar olusana kadar DOM da bulunmazlar...
        WebElement element1 = driver.findElement(By.cssSelector("#visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(element1)).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));

        driver.navigate().to("https://demoqa.com/alerts");

        // Alert varsa ona gecis yapmadan once bekleyebiliriz...
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        driver.navigate().to("https://demoqa.com/frames");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(), "This is a sample page");

        driver.switchTo().defaultContent();
        driver.navigate().to("https://demoqa.com/checkbox");

        driver.findElement(By.xpath("//button[@aria-label='Toggle']")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@type='checkbox']")));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='rct-title']"));
        for (WebElement el : checkboxes){
            System.out.println(el.getText());
        }

    }
}
