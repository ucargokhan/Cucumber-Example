package testbase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component  // Spring tarafından yönetilecek bir Bean olduğunu belirtiyoruz
public class JSONReader {

    private String filePath;  // Dosya yolu

    // Constructor ile filePath parametresini alıyoruz
    public JSONReader(String filePath) {
        this.filePath = filePath;
    }

    // JSON'dan locator'ları okuyacak metod
    public Map<String, Locator> readLocatorsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // TypeReference ile Map<String, Locator> türünü belirtiyoruz
        return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, Locator>>() {});
    }
}
