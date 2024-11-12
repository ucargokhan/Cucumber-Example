package testbase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component  // Spring tarafından yönetilecek bir Bean olduğunu belirtiyoruz
public class JSONReader {

    @Value("${json.file.path}")  // JSON dosyasının yolunu properties dosyasından alıyoruz
    private String filePath;

    // Constructor Injection ile filePath parametresini alıyoruz
    public JSONReader(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
    }

    // JSON'dan locator'ları okuyacak metod
    public Map<String, Locator> readLocatorsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, Locator>>() {});
    }
}
