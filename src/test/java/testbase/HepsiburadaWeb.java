package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component  // Spring tarafından yönetilecek bir Bean olduğunu belirtiyoruz
public class HepsiburadaWeb {

    private final WebDriver driver;  // WebDriver aynı şekilde kalmalı
    private final Map<String, Locator> locators;  // Locator'lar Map olarak alınacak

    // Constructor Injection ile WebDriver ve Locator'ları alıyoruz
    @Autowired
    public HepsiburadaWeb(WebDriver driver, Map<String, Locator> locators) {
        this.driver = driver;
        this.locators = locators;
    }

    // testbase.Locator'ı almak için metod
    public By getLocator(String key) {
        Locator locator = locators.get(key);  // JSON'dan alınan locator
        if (locator != null) {
            switch (locator.getLocator().toLowerCase()) {
                case "xpath":
                    return By.xpath(locator.getValue());
                case "id":
                    return By.id(locator.getValue());
                case "name":
                    return By.name(locator.getValue());
                case "css":
                    return By.cssSelector(locator.getValue());
                case "linktext":
                    return By.linkText(locator.getValue());
                case "partiallinktext":
                    return By.partialLinkText(locator.getValue());
                default:
                    throw new IllegalArgumentException("Locator type not supported: " + locator.getLocator());
            }
        }
        return null;
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
}
