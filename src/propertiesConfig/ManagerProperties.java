package propertiesConfig;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ManagerProperties {
    Properties properties = new Properties();

    public ManagerProperties() {
        load();
    }

    public void load() {
        try {
            properties.load(new FileInputStream("data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}