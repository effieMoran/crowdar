package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    public String getCurrentURL() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }
}
