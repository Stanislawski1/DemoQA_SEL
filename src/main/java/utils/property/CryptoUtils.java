package utils.property;
import java.util.Base64;

class CryptoUtils {

    static String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    static String decode(String encodedPassword) {
        return new String(Base64.getDecoder().decode(encodedPassword));
    }
}