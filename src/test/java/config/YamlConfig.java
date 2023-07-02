package config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

public class YamlConfig {

    private Map<String, ServiceConfig> application;

    public Map<String, ServiceConfig> getApplication() {
        return application;
    }

    public void setApplication(Map<String, ServiceConfig> application) {
        this.application = application;
    }

    @Override public String toString() {
        return "YamlConfig{" +
                "application=" + application +
                '}';
    }

    public static Map<String, ServiceConfig> init() {
        Constructor constructor = new Constructor(YamlConfig.class);
        Yaml yaml = new Yaml( constructor );

        InputStream input = YamlConfig.class
                .getClassLoader()
                .getResourceAsStream("application.yml");

        YamlConfig yamlConfig = yaml.loadAs( input, YamlConfig.class );
        return yamlConfig.getApplication();
    }
}
