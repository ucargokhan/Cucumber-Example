package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import testbase.BaseTest;
import testbase.HepsiburadaWeb;

import java.time.Duration;

@ContextConfiguration(classes = BaseTest.class)  // Spring context'ini sağlamak için BaseTest sınıfını kullanıyoruz
public class LoginSteps {

    private final WebDriver driver;
    private final HepsiburadaWeb hepsiburadaWeb;

    @Autowired  // Spring tarafından yönetilmesini sağlamak için bu anotasyonu kullanıyoruz
    public LoginSteps(BaseTest baseTest) {
        this.driver = BaseTest.driver;  // BaseTest'ten WebDriver alınır
        this.hepsiburadaWeb = new HepsiburadaWeb(driver, BaseTest.locators);
    }

    @Given("Kullanıcı giriş sayfasına gider")
    public void kullaniciGirisSayfasinaGider() {
        // Giriş sayfasına gidiyoruz
        driver.get("https://www.hepsiburada.com/");
    }

    @When("Kullanıcı geçerli kullanıcı adı ve şifre girer")
    public void kullaniciGecerliKullaniciAdiVeSifreGirer() throws InterruptedException {
        // Email alanına kullanıcı adı ve şifre girilir
        By emailLocator = hepsiburadaWeb.getLocator("emailAlani");
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys("testuser@example.com");

        // Şifre alanına şifre girilir
        By passwordLocator = hepsiburadaWeb.getLocator("sifreGirmeButon");
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys("TestPassword123");
    }

    @And("Kullanıcı giriş butonuna tıklar")
    public void kullaniciGirisButonunaTiklar() {
        // Giriş yap butonuna tıklanır
        By loginButtonLocator = hepsiburadaWeb.getLocator("girisYapButonu");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    @Then("Kullanıcı ana sayfaya yönlendirilir")
    public void kullaniciAnaSayfayaYonlendirilir() {
        // Ana
    }}