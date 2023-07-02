package test;

import config.ServiceConfig;
import config.YamlConfig;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Coding Exercise")
@Feature("Login")
public class LoginTest extends BasicTest{

    private LoginPage loginPage;

    private ServiceConfig properties;

    private static final String AUTOMATION = "automation";

    @BeforeEach
    public void beforeTest() {

        WebDriver driver = super.getDriver();
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

        loginPage.setPassword(properties.getPassword());

        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo("Swag Labhhhs");

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to login with a previously registered user.")
    public void loginSuccess() {

        loginPage.navigate();

        loginPage.setUsername(properties.getUsername());

        loginPage.setPassword(properties.getPassword());

        loginPage.clickSubmitButton();

        assertThat(loginPage.getTitleText()).isEqualTo("Swag Labs");

    }

}
