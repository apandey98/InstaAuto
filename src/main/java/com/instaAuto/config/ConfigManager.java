package com.instaAuto.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigManager {



    private static Properties prop = new Properties();
static{
try{
        FileInputStream fis = new FileInputStream("src/test/java/properties/proper.properties");
        prop.load(fis);

    }catch(Exception exception){
    throw new RuntimeException("File not found");
    }
}
public static String get(String key){
    return prop.getProperty(key);
}
}
