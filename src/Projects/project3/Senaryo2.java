package Projects.project3;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Senaryo2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));

        Bekle(2);
        WebElement demoEbook=driver.findElement(By.xpath("//div[@class='thumbnail'and @style='background-image: url(https://s3.amazonaws.com/static.e-junkie.com/products/thumbnails/1595015.png); border-radius: 4px 4px 0px 0px;']"));
        demoEbook.click();

        WebElement sepeteEkle=driver.findElement(By.cssSelector("[class='g_btn']"));
        sepeteEkle.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        Bekle(4);
        WebElement bankaKarti=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        bankaKarti.click();
        Bekle(2);
        WebElement odeBtn=driver.findElement(By.cssSelector("[class='Pay-Button']"));
        odeBtn.click();
        Bekle(1);
        String eMailString="Proje13@gmail.com";
        WebElement eMail= driver.findElement(By.cssSelector("[placeholder='Email']"));
        eMail.sendKeys(eMailString);
        Bekle(1);
        WebElement emailTekrar= driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        emailTekrar.sendKeys(eMailString);
        Bekle(1);
        WebElement name=driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        name.sendKeys("Grup16");
        Bekle(1);

        driver.switchTo().frame(2);

//        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        Bekle(2);
        WebElement cardNumber=driver.findElement(By.cssSelector("[class='InputElement is-empty Input Input--empty'][autocomplete='cc-number']"));
        cardNumber.sendKeys("1111 1111 1111 1111");

        WebElement frameson = driver.findElement(By.xpath("//*[@id=\"Stripe-Element\"]/div/iframe"));
      

        driver.switchTo().frame(frameson);

//
        WebElement assertOne=driver.findElement(By.xpath("//*[@id=\"SnackBar\"]/span"));
        Assert.assertTrue(assertOne.getText().contains("Your card number is invalid."));

//        driver.switchTo().frame(2);
//        Assert.assertTrue(driver.getPageSource().contains("Kart numaranız geçersiz."));

        BekleKapat();
    }
}
