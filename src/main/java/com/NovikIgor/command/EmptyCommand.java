package com.NovikIgor.command;



import com.NovikIgor.recourceManagment.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nolik on 29.09.16.
 */
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
		/* в случае ошибки или прямого обращения к контроллеру

 * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
