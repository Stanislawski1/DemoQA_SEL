package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {
    @Key("base.url")
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @Key("api.username")
    String username();

    @Key("api.password")
    String password();
}

