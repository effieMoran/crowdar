package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By usernameLocator = By.cssSelector("input[data-test=username]");

    private By passwordLocator = By.cssSelector("input[data-test=password]");

    private By submitButtonLocator = By.cssSelector("input[data-test=login-button]");

    private By titleLocator = By.className("app_logo");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    @Step("Navigate to the Log-in page")
    public void navigate() {
        driver.get(super.getUrl());
    }

    @Step("Enter username {0}")
    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    @Step("Enter password {0}")
    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public String getTitleText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(titleLocator).getText();
    }

}
