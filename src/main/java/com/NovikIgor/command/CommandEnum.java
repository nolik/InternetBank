package com.NovikIgor.command;

/**
 * ENUM of existing command for command factory.
 *
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
    OPERATION_FOR_SENDING_MONEY {
        {
            this.command = new OperationCommandForSendingMoney();
        }
    },
    SENT_MONEY {
        {
            this.command = new SentMoneyCommand();
        }
    },
    TRANSACTION_HISTORY {
        {
            this.command = new TransactionHistoryCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }


}

