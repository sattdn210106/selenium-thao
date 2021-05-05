package models;

import common.helpers.DataHelper;

public class Account {
    private String email;
    private String password;
    private String confirmPassword;
    private String pid;

    public Account(String email, String password, String confirmPassword, String pid) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pid = pid;
    }

    public Account() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String setPid() {
        return pid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPid() {
        return pid;
    }

    public Account getRandomAccount() {
        email = DataHelper.getRandomEmail();
        password = DataHelper.getRandomText();
        confirmPassword = password;
        pid = DataHelper.getRandomPID();
        return this;
    }
}
