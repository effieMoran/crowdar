package service;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginService {

    private LoginPage loginPage;

    public LoginService(WebDriver driver, WebDriverWait wait) {
        loginPage = new LoginPage(driver, wait);
    }

    private String ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
    @Step("I navigate to the 'Log-in' page")
    public void navigate() {
        loginPage.navigateToLogin();
    }

    @Step("Enter username {0}")
    public void setUsername(String username) {
        loginPage.setUsername(username);
    }

    @Step("Enter password {0}")
    public void setPassword(String password) {
       loginPage.setPassword(password);
    }

    @Step("I click the 'Login' button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("the field 'Username' is empty")
    public void assertUsernameFieldIsEmpty() {
        assertThat(loginPage.getUsername()).isNullOrEmpty();
    }

    @Step("the field 'Password' is empty")
    public void assertPasswordFieldIsEmpty() {
        assertThat(loginPage.getPassword()).isNullOrEmpty();
    }

    @Step("the field 'Password' is empty")
    public void assertLockedOutUserMessage() {
        assertThat(ERROR_MESSAGE).isEqualTo(loginPage.getLockedOutErrorMessage());
    }
}
