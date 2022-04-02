package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfProperties {

    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fs = new FileInputStream("src\\test\\resources\\conf.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fs);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
