package select;

import Utils.BaseStaticDriver;
import org.testng.annotations.Test;

public class SelectDemo extends BaseStaticDriver {

    @Test
    public void selectTest(){

        driver.get("https://sqengineer.com/practice-sites/basic-web-elements/");
    }
}
