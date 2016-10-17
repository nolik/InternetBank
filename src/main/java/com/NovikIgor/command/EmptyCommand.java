package com.NovikIgor.command;



import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 29.09.16.
 */
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
		/* in case of mistake with directly connection to controller redirect to index.jsp page */
        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
