package actions;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_Demo extends BaseStaticDriver {

    Actions action = new Actions(driver);

    @BeforeTest
    public void testInitial(){
        driver.get("https://www.browserstack.com/");
    }

    @Test
    public void clickAction(){

        action.moveToElement(driver.findElement(By.linkText("Get started free"))).click().perform();
    }

    @Test
    public void doubleClick(){
        WebElement trialaction = driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));

        //Double click on element
        action.doubleClick(trialaction).perform();
    }

    @Test
    public void moveToElement() throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        Bekle(2);
        action.scrollByAmount(0,-300).perform();
        Bekle(2);

        WebElement live= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
        action.moveToElement(live).build().perform();



        Thread.sleep(3000);

        WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
        automate.click();

    }

    @Test
    public void keydownandUp(){

        WebElement search = driver.findElement(By.xpath("(//button[@aria-label='Search'])[2]"));
        action.click(search).perform();

        WebElement input = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
        action.sendKeys(input, "Merhaba").moveToElement(input)
                .sendKeys(" Merhaba")
                .keyDown(input, Keys.getKeyFromUnicode('\uE03D'))
                .sendKeys("A").perform();
        action.keyDown(Keys.DELETE).perform();
        Bekle(3);
    }

    @Test
    public void scrollDown(){

        WebElement link = driver.findElement(By.cssSelector("#view-all-testimonials"));
        action.scrollToElement(link).click().perform();
    }

    @AfterTest
    public void close(){
        BekleKapat();
    }
}
