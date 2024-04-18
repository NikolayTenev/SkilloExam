package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Objects;

public class PostPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "//h3[text()='Post a picture to share with your awesome followers']")
    private static WebElement newPostTitle;

    @FindBy(xpath = "//input[@class='form-control input-lg'][@type='text']")
    private  WebElement uploadPictureText;

    @FindBy(name = "caption")
    private  WebElement postCaption;

    @FindBy(id = "create-post")
    private  WebElement createpostButton;

    public PostPage(WebDriver driver) {
        this.webDriver= driver;
        PageFactory.initElements(webDriver,this);
    }

    public static boolean isNewPostLoaded() {
        return newPostTitle.isDisplayed();
    }

    public void uploadPicture(File file) {
        WebElement uploadFile = webDriver.findElement(By.xpath("//*[@class='form-group']/input[@type='file']"));
        uploadFile.sendKeys(file.getAbsolutePath());
    }

    public boolean isImageUplaoded(String fileName) {
        String actualText = uploadPictureText.getAttribute("placeholder");
        return Objects.equals(actualText, fileName);
    }

    public String uplaodedImageText() {
        return uploadPictureText.getAttribute("placeholder");
    }

    public void typePostCaption(String text) {
        postCaption.sendKeys(text);
    }

    public void clickCreatePost() {

        createpostButton.isEnabled();
        createpostButton.click();
    }
}
