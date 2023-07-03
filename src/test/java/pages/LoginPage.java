package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By usernameLocator = By.cssSelector("input[data-test=username]");

    private By passwordLocator = By.cssSelector("input[data-test=password]");

    private By submitButtonLocator = By.cssSelector("input[data-test=login-button]");

    private By lockedOutUserError = By.cssSelector("h3[data-test=error]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void navigateToLogin() {
        driver.get(super.getUrl());
    }

    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public String getUsername() {
        return driver.findElement(usernameLocator).getText();
    }

    public String getPassword() {
        return driver.findElement(passwordLocator).getText();
    }

    public void clickLoginButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public String getLockedOutErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(lockedOutUserError));
        return driver.findElement(lockedOutUserError).getText();
    }

    public String getUsernameErrorClass() {
        return driver.findElement(usernameLocator).getAttribute("class");
    }

    public String getPasswordErrorClass() {
        return driver.findElement(passwordLocator).getAttribute("class");
    }
}
