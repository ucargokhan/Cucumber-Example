package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import java.io.IOException;
import java.util.Map;

@SpringBootTest(classes = {BaseTest.class})  // Spring Boot test konfigürasyonu
@ContextConfiguration(classes = BaseTest.class) // Spring context'ini tanımlıyoruz
public class BaseTest {

    @Autowired
    public static WebDriver driver;  // Spring tarafından enjekte edilecek WebDriver

    @Autowired
    protected static HepsiburadaWeb hepsiburadaWeb;  // HepsiburadaWeb sınıfı da Spring tarafından enjekte edilecek

    @Autowired
    protected static JSONReader jsonReader;  // JSONReader sınıfının Spring tarafından yönetilmesini sağlıyoruz

    @Autowired
    public static Map<String, Locator> locators;  // Locator'lar da Spring tarafından yönetilecek

    // Setup işlemi Spring'in lifecycle yönetimi ile yapılacak
    @BeforeAll
    public static void setUp() throws IOException {
        // WebDriverManager'ı manuel olarak başlatıyoruz çünkü @BeforeAll metodu static'tir
        System.out.println("ChromeDriver ayağa kaldırılıyor...");

        // WebDriverManager kullanarak ChromeDriver'ı dinamik olarak ayarlayın
        WebDriverManager.chromedriver().setup();  // WebDriverManager doğru sürümü indirip ayarlayacak.

        // ChromeDriver'ı başlat
        driver = new ChromeDriver();
        System.out.println("ChromeDriver ayağa kaldırıldı.");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("Driver kapatıldı.");
    }
}
