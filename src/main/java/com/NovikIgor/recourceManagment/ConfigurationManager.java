package com.NovikIgor.recourceManagment;

import java.util.ResourceBundle;

/**
 * Created by nolik on 29.09.16.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle
            .getBundle("resources.config");

    // class extract information from file config.properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
