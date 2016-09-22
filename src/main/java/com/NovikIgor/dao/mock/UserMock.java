package com.NovikIgor.dao.mock;

/**
 * Created by Novik Igor on 20.09.2016.
 */

public class UserMock {
    private String login;
    private String password;
    private ClientType role;

    public UserMock(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientType getRole() {
        return role;
    }

    public void setRole(ClientType role) {
        this.role = role;
    }
}
