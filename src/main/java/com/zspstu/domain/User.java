package com.zspstu.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private double currentSize;
    private double maxSize;

    public User() {
    }

    public User(Integer uid, String username, String password, String email, double currentSize, double maxSize) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.currentSize = currentSize;
        this.maxSize = maxSize;
    }

    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(double currentSize) {
        this.currentSize = currentSize;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(double maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", currentSize=" + currentSize +
                ", maxSize=" + maxSize +
                '}';
    }
}
