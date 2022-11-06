package locators;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleTest extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.google.com/");

        WebElement KSHButton = driver.findElement(By.cssSelector(".FPdoLc center input + input"));
        WebElement KSHButton2 = driver.findElement(By.xpath("//div[contains(@class,'FPdoLc')]//center//input/following-sibling::input"));
        KSHButton2.click();

        BekleKapat();

    }
}
