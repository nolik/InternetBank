package com.NovikIgor.command;

import com.NovikIgor.recourceManagment.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 29.09.16.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {

        ActionCommand current = new EmptyCommand();
        // get command name from request
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // if don't have command
            return current;
        }
        // get object according command
        try {
            CommandEnum currentEnum =
                    CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
