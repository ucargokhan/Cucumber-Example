package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component  // Spring tarafından yönetilecek bir Bean olduğunu belirtiyoruz
public class HepsiburadaWeb {

    private final WebDriver driver;  // WebDriver aynı şekilde kalmalı
    private final Map<String, Locator> locators;  // 'final' kaldırıldı

    // Constructor Injection ile WebDriver ve Locator'ları alıyoruz
    public HepsiburadaWeb(WebDriver driver, Map<String, Locator> locators) {
        this.driver = driver;
        this.locators = locators;  // Artık locators final değil, dolayısıyla atama yapılabilir
    }

    // testbase.Locator'ı almak için metod
    public By getLocator(String key) {
        Locator locator = locators.get(key);  // JSON'dan alınan locator
        if (locator != null) {
            switch (locator.getLocator().toLowerCase()) {  // testbase.Locator türünü kontrol et
                case "xpath":
                    return By.xpath(locator.getValue());  // Xpath kullanılarak element bulunur
                case "id":
                    return By.id(locator.getValue());  // ID kullanılarak element bulunur
                case "name":
                    return By.name(locator.getValue());  // Name kullanılarak element bulunur
                case "css":
                    return By.cssSelector(locator.getValue());  // CSS Selector kullanılarak element bulunur
                case "linktext":
                    return By.linkText(locator.getValue());  // LinkText kullanılarak element bulunur
                case "partiallinktext":
                    return By.partialLinkText(locator.getValue());  // PartialLinkText kullanılarak element bulunur
                default:
                    throw new IllegalArgumentException("Locator type not supported: " + locator.getLocator());
            }
        }
        return null;  // Eğer locator bulunamazsa null döndürür
    }

    // Elemente tıklama
    public void clickOnElement(By elementPath) {
        WebElement element = driver.findElement(elementPath);
        element.click();
    }

    // Elemente metin gönderme
    public void sendKeysToTheElement(By elementPath, String keyText) {
        WebElement element = driver.findElement(elementPath);
        element.click();
        element.sendKeys(keyText);
    }

    // Bekleme işlemi
    public void waitSeconds(long seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    // Diğer metotlar aynı şekilde devam eder
}
