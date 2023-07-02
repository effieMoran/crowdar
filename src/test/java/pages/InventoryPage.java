package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {

    protected final static String URI = "inventory.html";

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    private By titleLocator = By.className("app_logo");

    private By secondaryTitleLocator = By.cssSelector(".header_secondary_container > span");

    public String getPageUri() {
        return PAGE_URL + URI;
    }

    public String getTitleText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(titleLocator).getText();
    }
    public String getSecondaryTitleText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(secondaryTitleLocator).getText();
    }
}
