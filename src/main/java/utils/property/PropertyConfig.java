package utils.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {
    private static Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить файл config.properties", e);
        }
    }

    private static String getDecodedProperty(String key) {
        String value = System.getenv(key.replace(".", "_").toUpperCase());

        if (value == null) {
            value = props.getProperty(key);
        }

        if (value != null && value.startsWith("enc_")) {
            return CryptoUtils.decode(value.substring(4));
        }
        return value;
    }


    public static String getApiPassword() {
        return getDecodedProperty("api.password");
    }

    public static String getDbPassword() {
        return getDecodedProperty("db.password");
    }

    public static String getBaseUrl() {
        return props.getProperty("base.url"); // Тут декодирование не нужно
    }

    public static String getApiUsername() {
        return props.getProperty("api.username");
    }

    public static String getGridUrl() {
        return props.getProperty("grid.url");
    }

    public static String getBrowser() {
        return props.getProperty("grid.browser", "chrome");
    }
}