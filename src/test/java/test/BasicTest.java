package test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverHelper;

public class BasicTest extends BaseTest {

    private WebDriver driver = new WebDriverHelper().generateWebDriver();

    private WebDriverWait wait = new WebDriverWait(driver, 100);

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
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
