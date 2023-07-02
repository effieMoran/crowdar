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


@Epic("Coding Exercise")
@Feature("Login")
public class LoginTest extends BasicTest{

    private LoginService loginService;

    private InventoryService inventoryService;
    private ServiceConfig properties;

    private static final String AUTOMATION = "automation";

    @BeforeEach
    public void beforeTest() {

        WebDriver driver = super.getDriver();
        WebDriverWait wait = super.getWait();

        loginService = new LoginService(driver,wait);
        inventoryService = new InventoryService(driver, wait);
        Map<String, ServiceConfig> configuration = YamlConfig.init();
        properties = configuration.get(AUTOMATION);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    public void login() {

        loginService.navigate();

        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        inventoryService.assertHeader("Swag Labs");
        inventoryService.assertUrl();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials and fail because of the wrong header")
    public void loginFail() {

        loginService.navigate();

        loginService.setUsername(properties.getUsername());
        loginService.setPassword(properties.getPassword());
        loginService.clickLoginButton();

        inventoryService.assertHeader("Swag Labshhhhh");
    }
}
