package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/db.properties", // Путь от корня проекта
        "classpath:db.properties"                // Путь в скомпилированных ресурсах
})
public interface DbConfig extends Config {
    @Key("db.url")
    String url();

    @Key("db.user")
    String user();

    @Key("db.password")
    String password();
}