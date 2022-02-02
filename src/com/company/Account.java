package com.company;

public class Account{
    private String email;
    private String password;

    public Account( String email, String password )
    {
            this.email = email;
            this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
