package testbase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {BaseTest.class, WebDriverConfig.class})  // Spring konfigürasyonlarını yüklüyoruz

public class HepsiburadaWebTest extends BaseTest {

    // Burada manuel olarak hepsiburadaWeb nesnesi başlatılmasına gerek yok, testbase.BaseTest üzerinden erişebilirsiniz.

    @Test
    public void HepsiburadaWebEndtoEnd() throws InterruptedException {

        //5 sn beklenir
        hepsiburadaWeb.waitSeconds(5);

        By loginButtonLocator = hepsiburadaWeb.getLocator("girisYapAlani");

        // testbase.Locator'ı konsola yazdırarak kontrol edelim
        System.out.println("Login Button testbase.Locator: " + loginButtonLocator);

        // Daha sonra elemente tıklama yapalım
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();

        hepsiburadaWeb.waitSeconds(5);
    }
}
