package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @Test
    void testCreateProductAndAppearInList(WebDriver driver) {
        driver.get("http://localhost:8080/product/list");

        WebElement createButton = driver.findElement(By.linkText("Create Product"));
        createButton.click();

        driver.findElement(By.name("productName")).sendKeys("Sampo Cap Bambang");
        driver.findElement(By.name("productQuantity")).sendKeys("100");

        driver.findElement(By.tagName("form")).submit();

        assertTrue(driver.getCurrentUrl().contains("/product/list"));

        WebElement body = driver.findElement(By.tagName("body"));
        assertTrue(body.getText().contains("Sampo Cap Bambang"));
        assertTrue(body.getText().contains("100"));
    }
}
