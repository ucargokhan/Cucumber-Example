package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import testbase.BaseTest;
import testbase.HepsiburadaWeb;

import java.util.Objects;

@ContextConfiguration(classes = BaseTest.class)  // BaseTest sınıfını Spring context'ine dahil ediyoruz
public class LoginSteps {

    private final WebDriver driver;
    private final HepsiburadaWeb hepsiburadaWeb;

    @Autowired
    public LoginSteps(BaseTest baseTest) {
        this.driver = BaseTest.driver;  // BaseTest'ten WebDriver alıyoruz
        this.hepsiburadaWeb = new HepsiburadaWeb(driver, BaseTest.locators);
    }

    @Given("Kullanıcı giriş sayfasına gider")
    public void kullaniciGirisSayfasinaGider() {
        driver.get("https://www.hepsiburada.com/");
    }

    @When("Kullanıcı geçerli kullanıcı adı ve şifre girer")
    public void kullaniciGecerliKullaniciAdiVeSifreGirer() {
        By emailLocator = hepsiburadaWeb.getLocator("emailAlani");
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys("testuser@example.com");

        By passwordLocator = hepsiburadaWeb.getLocator("sifreGirmeButon");
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys("TestPassword123");
    }

    @And("Kullanıcı giriş butonuna tıklar")
    public void kullaniciGirisButonunaTiklar() {
        By loginButtonLocator = hepsiburadaWeb.getLocator("girisYapButonu");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    @Then("Kullanıcı ana sayfaya yönlendirilir")
    public void kullaniciAnaSayfayaYonlendirilir() {
        String currentUrl = driver.getCurrentUrl();
        assert Objects.requireNonNull(currentUrl).contains("hepsiburada.com");
    }
}
