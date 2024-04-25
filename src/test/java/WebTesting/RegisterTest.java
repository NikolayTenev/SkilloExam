package WebTesting;

import factory.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends TestObject {


    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {generateAlphabeticString(5,10),generateRandomEmail(5,10),password, password}
        };
    }

    String password = generateAlphabeticString(5,10);

    @Test(dataProvider = "getUser", groups = "TestGroupA")
    public void registerTest(String userNameRegister, String email, String password, String confirmPassword) {




        HomePage homePage = new HomePage(getWebDriver());
        Header header = new Header(getWebDriver());
        LoginPage loginPage = new LoginPage(getWebDriver());
        RegisterPage registerPage = new RegisterPage(getWebDriver());
        ProfilePage profilePage = new ProfilePage(getWebDriver());


        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");

        header.clickRegister();
        Assert.assertTrue(registerPage.isUrlLoaded(),"Register page is not loaded.");



        registerPage.userNameRegister(userNameRegister);
        registerPage.setEmailTextField(email);
        registerPage.setPasswordTextFiled(password);
        registerPage.setConfirmPasswordTextField(confirmPassword);

        registerPage.clickSignInButton();


        profilePage.isUrlLoaded();
        Assert.assertTrue(profilePage.isUrlLoaded(), "Current page is not profile page");

        Assert.assertTrue(loginPage.downArrow.isDisplayed(), "Down arrow is not displayed.");

    }

    private String generateRandomEmail(int minLenghtInclusive, int maxLenghtInclusive) {
        return generateAlphabeticString(minLenghtInclusive, maxLenghtInclusive) + "@gmail.com";
    }

    private String generateAlphabeticString(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLenghtInclusive, maxLenghtInclusive);
    }

}
