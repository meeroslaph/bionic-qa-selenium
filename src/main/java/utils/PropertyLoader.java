package utils;

import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final String PROPERTY_FILE = "/application.properties";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        String value = "";
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            Assert.fail(name + " property can't be loaded. " + e + " exception has been thrown.");
        }
        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}