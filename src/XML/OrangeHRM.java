package XML;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test(groups = "Full_Test", priority = 3)
    public void NavigateToMyInfo() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
    }

    @Test(groups = "Full_Test", priority = 3)
    public void VerifyMyInfo() {
        System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
        //driver.quit();
    }

    @Test(groups = {"login"}, priority = 2)
    public void VerifyLogin() {
        WebElement element = driver.findElement(By.id("welcome"));
        System.out.println(element.isDisplayed());
        System.out.println(element.getText());
        //driver.quit();
    }

    @Test(groups = "logout", priority = 4)
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
