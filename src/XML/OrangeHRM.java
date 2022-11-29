package XML;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class OrangeHRM extends BaseStaticDriver {

    @BeforeClass(alwaysRun = true)
    public void LaunchApp() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Parameters({"username", "password"})
    @Test(groups = "login", priority = 1)
    public void login(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(groups = "Full_Test", priority = 3)
    public void NavigateToMyInfo() {
        driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(6) > a")).click();
    }

    @Test(groups = "Full_Test", priority = 4)
    public void VerifyMyInfo() {
        Bekle(2);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")).getText(), "Chaman Kumar");
        //driver.quit();
    }

    @Test(groups = {"login"}, priority = 2)
    public void VerifyLogin() {
        WebElement element = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6"));
        System.out.println(element.isDisplayed());
        System.out.println(element.getText());
        //driver.quit();
    }

    @Test(groups = "logout", priority = 5)
    public void LogOut(){
        System.out.println("logged-uot from system");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
