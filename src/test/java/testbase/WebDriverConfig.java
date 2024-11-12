package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Spring configuration sınıfı
public class WebDriverConfig {

    @Bean
    public WebDriver webDriver() {
        // WebDriverManager ile doğru sürümü indiriyoruz ve WebDriver'ı başlatıyoruz
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();  // ChromeDriver örneği oluşturuluyor
    }
}
