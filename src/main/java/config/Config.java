package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties properties;

    // Private constructor to prevent instantiation
    private Config() {
        properties = new Properties();
        loadProperties();
    }

    // Synchronized method to control simultaneous access
    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    // Load properties from file
    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Cannot find application.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method to get a property value
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
