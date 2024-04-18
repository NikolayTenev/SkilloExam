package WebTesting;

import factory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class FolowPostTest extends TestObject {
    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        File postPicture = new File("C:\\Users\\Nikolay\\IdeaProjects\\SkilloExam\\src\\test\\resources\\upload\\sampleFile.jpeg");
        String caption = "Testing upload file";
        return new Object[][]{
                {"Nikito123.", "Qwerty123", "5532",postPicture, caption},

        };
    }

    @Test(dataProvider = "getUser")
    public void testCreatePost( String username, String password, String userId, File postPicture, String caption) {
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);
        FolowPost folowPost = new FolowPost(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember my is not checked.");
        loginPage.clickSignUpButton();
        header.clickProfile();
        profilePage.isUrlLoaded(userId);
        profilePage.isUrlLoaded();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), STR."Current page is not profile page for \{userId}");


        header.clickNewPostLink();
        Assert.assertTrue(PostPage.isNewPostLoaded(), "The new post form is not loaded");


        postPage.uploadPicture(postPicture);
        String actualImageText = postPage.uplaodedImageText();
        Assert.assertTrue(postPage.isImageUplaoded("sampleFile.jpeg"), "Image is not uploaded");
        Assert.assertEquals(actualImageText, "sampleFile.jpeg", "Incorrect image is uploaded");

        postPage.typePostCaption(caption);
        postPage.clickCreatePost();

        Assert.assertTrue(profilePage.isUrlLoaded(userId), STR."Current page is not profile page for \{userId}");

        FolowPost.setPicturePost();
        FolowPost.likePost();
    }
}
