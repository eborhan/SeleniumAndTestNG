package com.ersan.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties properties;

    static {
        try {
            //what file to be read?
            String path = "configuration.properties";
            //read the file into java, find the file using the string path
            FileInputStream input = new FileInputStream(path);
            //properties --> a class that stores properties in a key/value (dictionary) format
            properties = new Properties();
            //the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
