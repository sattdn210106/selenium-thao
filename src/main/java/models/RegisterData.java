package models;

import common.helpers.DataHelper;

public class RegisterData {
    private String email;
    private String password;
    private String confirmPassword;
    private String pid;
    private String message;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        if (email.equals("valid data")) {
            return DataHelper.getRandomEmail();
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPid() {
        if(pid.equals("valid data")) {
            return DataHelper.getRandomPID();
        }
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
