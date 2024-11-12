package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = "testbase")  // testbase paketindeki tüm sınıfları tarar ve bean'leri bulur
public class BaseTest {

    @Autowired
    protected static HepsiburadaWeb hepsiburadaWeb;  // HepsiburadaWeb Bean

    @Autowired
    protected JSONReader jsonReader;  // JSONReader Bean

    @Autowired
    public static WebDriver driver;  // WebDriver Spring tarafından yönetilen bir Bean

    @Autowired
    public static Map<String, Locator> locators;  // Locator Bean'leri

    // WebDriver bean'ini Spring tarafından yönetilen bir şekilde tanımlıyoruz
    @Bean
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();  // ChromeDriver'ı dinamik olarak yükle
        return new ChromeDriver();
    }

    // Setup işlemi
    @BeforeClass
    public void setUp() throws Exception {
        // Spring tarafından sağlanan WebDriver bean'ini kullanabiliriz.
    }

    // Tear down işlemi
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
