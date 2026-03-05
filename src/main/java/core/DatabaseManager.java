package core;

import config.DbConfig;
import org.aeonbits.owner.ConfigFactory;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    private static final DbConfig cfg = ConfigFactory.create(DbConfig.class);

    public static Map<String, String> getUserCredentials(String userRole) {
        Map<String, String> credentials = new HashMap<>();

        String query = "SELECT username, password FROM users WHERE role = ?";

        try (Connection conn = DriverManager.getConnection(cfg.url(), cfg.user(), cfg.password());
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userRole);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                credentials.put("username", rs.getString("username"));
                credentials.put("password", rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}