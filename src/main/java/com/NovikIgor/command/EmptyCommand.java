package com.NovikIgor.command;



import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 29.09.16.
 */
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
		/* in case of mistake with directly connection to controller redirect to index.jsp page */
       //TODO realize get page from propertyFile (now can't throw MissingResourceException)
		// String page = ConfigurationManager.getProperty("path.page.index");
        return "/index.jsp";
    }
}
