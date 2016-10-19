package com.NovikIgor.recourceManagment;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class load messages from recources/massages.property files.
 * <p>
 * Created by nolik on 27.09.16.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle
            .getBundle("messages", Locale.getDefault());

    // class extract information from file messages.properties
    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
