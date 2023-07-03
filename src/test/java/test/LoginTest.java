package test;

import config.ServiceConfig;
import config.YamlConfig;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.InventoryService;
import service.LoginService;

import java.util.Map;


@Epic("Swag Labs")
@Feature("Login")
public class LoginTest extends BasicTest{

    private LoginService loginService;

    private InventoryService inventoryService;

    private Map<String, ServiceConfig> configuration;

    private static final String STANDARD_USER = "standard_user";
    private static final String LOCKED_OUT_USER = "locked_out_user";

    @BeforeEach
    public void beforeTest() {

        configuration = YamlConfig.init();

        WebDriver driver = super.getDriver();
        WebDriverWait wait = super.getWait();

        loginService = new LoginService(driver,wait);
        inventoryService = new InventoryService(driver, wait);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    public void login() {

        ServiceConfig properties = configuration.get(STANDARD_USER);

        //Given
        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        //When
        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        //Then
        inventoryService.assertProductsLabel();
        inventoryService.assertHeader("Swag Labs");
        inventoryService.assertUrl();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to login with locked out user")
    public void loginWithLockedOutUser() {

        String ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";

        ServiceConfig properties = configuration.get(LOCKED_OUT_USER);

        //Given
        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        //When
        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        //Then
        loginService.assertLockedOutUserMessage(ERROR_MESSAGE);
        loginService.assertFieldUsernameContainsError();
        loginService.assertFieldPasswordContainsError();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Wrong password")
    public void loginWithWrongPassword() {

        final String ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service";
        final String WRONG_PASSWORD = "123456";
        ServiceConfig properties = configuration.get(STANDARD_USER);

        //Given
        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        //When
        loginService.setUsername(properties.getUsername());
        loginService.setPassword(WRONG_PASSWORD);
        loginService.clickLoginButton();

        //Then
        loginService.assertLockedOutUserMessage(ERROR_MESSAGE);
        loginService.assertFieldUsernameContainsError();
        loginService.assertFieldPasswordContainsError();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("No username is provided")
    public void tryToLoginWithoutUsername() {

        final String ERROR_MESSAGE = "Epic sadface: Username is required";
        ServiceConfig properties = configuration.get(STANDARD_USER);

        //Given
        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        //When
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        //Then
        loginService.assertLockedOutUserMessage(ERROR_MESSAGE);
        loginService.assertFieldUsernameContainsError();
        loginService.assertFieldPasswordContainsError();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("No password is provided")
    public void tryToLoginWithoutPassword() {

        final String ERROR_MESSAGE = "Epic sadface: Password is required";
        ServiceConfig properties = configuration.get(STANDARD_USER);

        //Given
        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        //When
        loginService.setUsername(properties.getUsername());
        loginService.clickLoginButton();

        //Then
        loginService.assertLockedOutUserMessage(ERROR_MESSAGE);
        loginService.assertFieldUsernameContainsError();
        loginService.assertFieldPasswordContainsError();
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Login with valid credentials and fail because of the wrong header")
    public void loginFail() {
        ServiceConfig properties= configuration.get(STANDARD_USER);
        loginService.navigate();

        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        inventoryService.assertHeader("Swag Labshhhhh");
    }
}
