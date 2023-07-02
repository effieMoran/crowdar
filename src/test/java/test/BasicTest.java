package test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.WebDriverHelper;

public class BasicTest extends BaseTest {

    WebDriver driver = new WebDriverHelper().generateWebDriver();

    WebDriver getDriver() {
        return driver;
    }

    @Attachment
    @Step("Take screenshot")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    protected void failedAfter() {
        takeScreenShot();
    }

    @Override
    protected void succeededAfter() {
        // success
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
