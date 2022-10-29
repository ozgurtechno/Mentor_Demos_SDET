package select;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class UnsafeSelectCheckBox extends BaseStaticDriver {

    @Test
    public void testMultipleCheckBox() throws Exception {

        driver.navigate().to("https://www.webpagetest.org/");

        WebElement element1 = driver.findElement(By.cssSelector("input[aria-labelledby='tt-Mobile_4G']"));
        WebElement element2 = driver.findElement(By.cssSelector("input[aria-labelledby='tt-Desktop_Chrome']"));
        WebElement element3 = driver.findElement(By.cssSelector("input[aria-labelledby='tt-Mobile_3G']"));
        WebElement element4 = driver.findElement(By.cssSelector("input[aria-labelledby='tt-Desktop_Edge']"));
        WebElement element5 = driver.findElement(By.cssSelector("input[aria-labelledby='tt-Desktop_Firefox']"));
        WebElement[] elements = { element1, element2, element3, element4, element5 };
        unSafeSelectCheckBoxes(elements);
        BekleKapat();
    }

    public void unSafeSelectCheckBoxes(WebElement... elements) throws Exception {
        for (WebElement currentElement : elements) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(currentElement));

            WebElement checkBox = currentElement;
            if (checkBox.isSelected())
                System.out.println("CheckBox " + currentElement
                        + " is already selected");
            else
                checkBox.click();
        }
    }

}
