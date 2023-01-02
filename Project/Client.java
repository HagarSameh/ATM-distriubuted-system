package com.company;

public class Client {
    private String username = "";
    private String password = "";
    private int balance=0 ;
    static int noOfObjects = 0;
    {
        noOfObjects+=1;
    }


    public  String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }

    public  int getBalance() {
        return balance;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public  void setBalance(int balance) {
        this.balance = balance;
    }

}