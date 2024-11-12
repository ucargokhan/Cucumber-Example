package runners;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)  // Spring entegrasyonunu sağlıyoruz
@Cucumber // JUnit 5 ile uyumlu Cucumber'ı kullanıyoruz
public class CucumberRunner {
    // Bu sınıf sadece Cucumber'ı çalıştırmak için gerekli konfigürasyonu içerir
}
