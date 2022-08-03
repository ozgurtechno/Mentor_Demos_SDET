package actions;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;

public class ActionsDemo extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.get("http://automationpractice.com/index.php");
        Actions action = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("#homefeatured > li:nth-child(2)"));
        action.moveToElement(element).perform();

        Bekle(3);

        WebElement addToCart = driver.findElement(By.xpath("(//span[.='Add to cart']/parent::a)[2]"));
        action.moveToElement(addToCart).click().perform();

        Bekle(3);

        WebElement checkOutButton = driver.findElement(By.partialLinkText("Proceed to checkout"));
        action.moveToElement(checkOutButton).click().perform();

        Bekle(2);

        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        action.keyDown(searchInput, Keys.SHIFT).sendKeys("c").keyUp(Keys.SHIFT).sendKeys("omputer").perform();

        WebElement submitButton = driver.findElement(By.name("submit_search"));
        action.click(submitButton).perform();

        WebElement image = driver.findElement(By.cssSelector("#best-sellers_block_right > div > ul > li:nth-child(9) > a > img"));
        action.sendKeys(image, Keys.PAGE_DOWN).build().perform();
        Bekle(2);
        action.sendKeys(Keys.PAGE_UP).perform();





        BekleKapat();

    }
}
// hatali selektor secimi hata mesaji?
// gorunmeyen element secimi hata mesaji
// hatali locator secimi hata mesaji...

// Action bize ne zaman lazim olacak...?
