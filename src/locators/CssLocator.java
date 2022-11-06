package locators;

import Utils.BaseStaticDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CssLocator extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.get("https://accounts.lambdatest.com/register");

        //css=(Html tag )(#) (value of the ID attribute)
        WebElement passwordInput = driver.findElement(By.cssSelector("input#userpassword"));
        passwordInput.sendKeys("Hello");

        driver.navigate().to("https://accounts.lambdatest.com/login");
        Bekle(2);

        //css=(HTML tag)(.)(Value of Class attribute)
        WebElement submitButton = driver.findElement(By.cssSelector("button.submit-btn"));

        //css=(HTML Page)[Attribute=Value]
        WebElement phoneInput = driver.findElement(By.cssSelector("input[name=\"phone\"]"));

        //css=(HTML tag>)(. )(Class attribute value)([attribute=Value of attribute])
        WebElement submitButtonRegister = driver.findElement(By.cssSelector("button.submit-btn[data-callback=\"onSubmit\"]"));

        //css=(HTML tag)([attribute^=start of the string])
        WebElement emailInput = driver.findElement(By.cssSelector("input[name^='em']"));

        //css=(HTML tag)([attribute$=end of the string])
        WebElement emailInput2 = driver.findElement(By.cssSelector("input[name$='ail']"));

        //css=(HTML tag)([attribute*=partial string])
        WebElement emailInput3 = driver.findElement(By.cssSelector("input[class*='control']"));

        // ----------------------------- child - sibling --------------------------------------------------------------

        WebElement fullNameInput = driver.findElement(By.cssSelector(".form > div input"));
        fullNameInput.sendKeys("Merhaba");
        BekleKapat();
        //  ->     .form div input        -> XPath: //form//div//input
        //  ->     .form > div > input    -> XPath: //form/div/input
        //  ->     .form + div            -> XPath: //form//following-sibling::div
    }

    @Test
    public void locatorTest(){

    }
}
