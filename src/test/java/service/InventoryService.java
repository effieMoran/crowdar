package service;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryService {

    private InventoryPage inventoryPage;

    public InventoryService(WebDriver driver, WebDriverWait wait) {
        inventoryPage = new InventoryPage(driver, wait);
    }

    @Step("the title '{0}' is displayed")
    public void assertHeader(String title) {
        inventoryPage.getTitleText();
        assertThat(title).isEqualTo(inventoryPage.getTitleText());
    }
}
