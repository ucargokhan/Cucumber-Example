package configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testbase.BaseTest;  // BaseTest sınıfı Spring konteynerinde kullanılacak

@CucumberContextConfiguration  // Cucumber için Spring entegrasyonu sağlar
@ContextConfiguration(classes = WebDriverConfig.class)  // WebDriverConfig'i Spring'e tanıttık
public class CucumberSpringConfig {
    // Bu sınıf, Cucumber testlerinin Spring ile çalışabilmesi için gerekli Spring konfigürasyonunu sağlar
}
