package Projects.project4.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Projects.project4.pages.HomePage;

public class Hook {

    HomePage homePage = new HomePage();

    @BeforeTest(groups = "Regression")
    public void navigateToContactUsPage() {
        homePage.maximizeWindow();
        homePage.navigateTo("http://automationpractice.com/");
    }

    @AfterTest(groups = "Regression")
    public void closeBrowser() {
        homePage.quitDriver();
    }

}
