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
    public static String getUsername() {

        String user = System.getenv("APP_CREDS_USR");

        if (user == null || user.isEmpty()) {
            user = get("username");
        }

        return user;
    }

    public static String getPassword() {

        String pass = System.getenv("APP_CREDS_PSW");

        if (pass == null || pass.isEmpty()) {
            pass = get("password");
        }

        return pass;
    }
}
