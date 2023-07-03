package test;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

@Epic("Mercado libre")
@Feature("Rest - Categories")
public class CategoriesRestTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://www.mercadolibre.com.ar/menu/departments";
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test categories is not empty")
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();

        response.then().assertThat().body("departments", notNullValue());
        response.then().assertThat().body(containsString("categories"));
        response.then().assertThat().body("departments[0].categories[0]", notNullValue());
    }
}