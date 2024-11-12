package testbase;

public class Locator {
    private String locator;  // testbase.Locator türü (örn. "css", "id" vb.)
    private String value;    // testbase.Locator değeri (örn. "span[data-test-id='account']")

    // Getter ve Setter metodları
    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
