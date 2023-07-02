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
    private ServiceConfig properties;
    private Map<String, ServiceConfig> configuration;
    private static final String STANDARD_USER = "standard_user";

    @BeforeEach
    public void beforeTest() {

        WebDriver driver = super.getDriver();
        WebDriverWait wait = super.getWait();

        loginService = new LoginService(driver,wait);
        inventoryService = new InventoryService(driver, wait);
        configuration = YamlConfig.init();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    public void login() {

        properties = configuration.get(STANDARD_USER);

        loginService.navigate();
        loginService.assertPasswordFieldIsEmpty();
        loginService.assertUsernameFieldIsEmpty();

        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        inventoryService.assertHeader("Swag Labs");
        inventoryService.assertUrl();
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Login with valid credentials and fail because of the wrong header")
    public void loginFail() {

        loginService.navigate();

        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        inventoryService.assertHeader("Swag Labshhhhh");
    }
}
