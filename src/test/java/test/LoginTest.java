package test;

import config.ServiceConfig;
import config.YamlConfig;
import io.qameta.allure.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import util.WebDriverHelper;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Coding Exercise")
@Feature("Login")
public class LoginTest {

    private LoginPage loginPage;

    private ServiceConfig properties;

    private static final String AUTOMATION = "automation";

    @BeforeEach
    public void beforeTest() {
        WebDriver driver = new WebDriverHelper().generateWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        loginPage = new LoginPage(driver,wait);

       Map<String, ServiceConfig> configuration = YamlConfig.init();
       properties = configuration.get(AUTOMATION);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to login with a previously registered user.")
    public void login() {

        loginPage.navigate();

        loginPage.setUsername(properties.getUsername());
        loginPage.takeScreenShot();

        loginPage.setPassword(properties.getPassword());
        loginPage.takeScreenShot();

        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo("Swag Labs");
        loginPage.takeScreenShot();
    }

    @AfterEach
    public void quit() {
        loginPage.quit();
    }

}
