package com.NovikIgor.command;

/**
 * Created by nolik on 29.09.16.
 */
public enum CommandEnum {


    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
             this.command = new LogoutCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }


}

