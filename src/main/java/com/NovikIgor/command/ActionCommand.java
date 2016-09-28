package com.NovikIgor.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface with method execute String execute(HttpServletRequest request)
 * for the command in CommandFactory.
 * <p>
 * Created by nolik on 28.09.16.
 */
public interface ActionCommand {

    /**
     *  This method it's execute method in Command pattern, that
     *  implemented in different commands.
     *
     * @param request
     * @return
     */
    String execute(HttpServletRequest request);
}
