package com.ims.utility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_Reader {

    static Properties properties;
        //read data.properties
        public static String readKey(String propertyName) {
            properties = new Properties();

            try {
                String filename = System.getProperty("user.dir") + "/src/com/ims/properties/app.properties";
                properties.load(new FileInputStream(filename));
            } catch (IOException e) {
                throw new RuntimeException("Not able to find file");
            }
            return properties.getProperty(propertyName);
        }
    }




