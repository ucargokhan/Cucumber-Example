package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.springframework.test.context.ContextConfiguration;
import configuration.CucumberSpringConfig;

@ContextConfiguration(classes = CucumberSpringConfig.class)  // Spring context'ini yüklüyoruz
@CucumberOptions(
        features = "src/test/java/features",  // Feature dosyasının yolu
        glue = {"stepdefinitions", "configuration"},    // Step Definitions ve Configuration paketleri
        plugin = {"pretty", "html:target/cucumber-reports"}  // Çıktı formatları
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
