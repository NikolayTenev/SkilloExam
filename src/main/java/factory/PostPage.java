package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class PostPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "//h3[text()='Post a picture to share with your awesome followers']")
    private static WebElement newPostTitle;

    @FindBy(xpath = "//input[@class='form-control input-lg'][@type='text']")
    public WebElement uploadPictureText;

    @FindBy(name = "caption")
    private WebElement postCaption;

    @FindBy(id = "create-post")
    private WebElement createpostButton;

    @FindBy(xpath = "//*[@class='form-group']/input[@type='file']")
    private WebElement uploadFile;


    @FindBy(xpath = "//*[@class='form-control input-lg']")
    private WebElement actualText;

    @FindBy(id = "choose-file")
    private WebElement chooseFile;

    public PostPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }


public static boolean isNewPostLoaded() {
    return newPostTitle.isDisplayed();
}



    public void uploadPicture(File file) {
        uploadFile.sendKeys(file.getAbsolutePath());
    }

    public boolean isImageUploaded(String fileName) {
        String actualText = uploadPictureText.getAttribute("//*[@class='form-control input-lg']");
        return Objects.equals(actualText, fileName);
    }

    public String uplaodedImageText() {
        return uploadPictureText.getAttribute(actualText.getText());
    }

    public void typePostCaption(String text) {
        postCaption.sendKeys(text);
    }

    public boolean isVIsibleChooseFile() {
        chooseFile.isDisplayed();
        return true;
    }



    public void clickCreatePost() {
        if (createpostButton.isEnabled()) {
            createpostButton.click();
        }
    }

    public void waitForImageUpload() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(uploadPictureText));
    }

}
