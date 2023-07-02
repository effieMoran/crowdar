package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected final static String PAGE_URL = "https://www.saucedemo.com/";

    public String getUrl() {
        return PAGE_URL;
    }

    public BasePage(WebDriver driver, WebDriverWait wait) {
       this.driver = driver;
       this.wait = wait;
    }

    public void quit() {
        driver.quit();
    }

    @Attachment
    @Step("Take screenshot")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
