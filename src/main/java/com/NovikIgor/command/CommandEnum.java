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
    },
    OPERATION {
        {
            this.command = new OperationCommand();
        }
    },
    SENT_MONEY {
        {
            this.command = new SentMoneyCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }


}

