package org.cus.fx.account.model;

import java.io.Serializable;

public class AccountModel implements Serializable {

    private String username;

    private String password;

    private String yzm;

    private int types;

    //商家编码
    private String coding;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public AccountModel() {
        super();
    }

    public AccountModel(String username, String password, String yzm, int types, String coding) {
        this.username = username;
        this.password = password;
        this.yzm = yzm;
        this.types = types;
        this.coding = coding;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", yzm='" + yzm + '\'' +
                ", types=" + types +
                ", coding='" + coding + '\'' +
                '}';
    }
}
