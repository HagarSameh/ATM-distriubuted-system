package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

public class Server {
    private static final Client[] clients = new Client[4];
    private static int cInd ;
    private static  int client_id;


    Server(){

            for (int i = 0; i < 4; i++) {
                clients[i] = new Client();
                clients[i].setBalance(500);
                clients[i].setPassword("1234");
            }
            clients[0].setUsername("Hagar");
            clients[1].setUsername("Samy");
            clients[2].setUsername("Joe");
            clients[3].setUsername("Atia");



    }

    public static boolean Login(String Username, String Password) {
        for(int i=0;i<4;i++){
            if(Objects.equals(clients[i].getUsername(), Username)){
                if(Objects.equals(clients[i].getPassword(), Password)){
                    client_id=i;
                    return true;
                }
            }
        }
        return false;
    }

    public int Check_Balance(int client_id4)
    {
        return clients[client_id4].getBalance();
    }

    public void Withdraw(int amount, int client_id3) {
        int balance = clients[client_id3].getBalance();
        if(amount<=7000 && amount <= balance)
        {
            clients[client_id3].setBalance(balance - amount);
        }


    }

    public void Deposit(int amount , int client_id2) {
        clients[client_id2].setBalance(clients[client_id2].getBalance()+amount);
    }

    public void Transaction(int amount , int client_id1 , int to_client_id){
        int balance=clients[client_id1].getBalance();
        if(amount<=7000 && amount<=balance){
            clients[client_id1].setBalance(balance-amount);
            clients[to_client_id].setBalance(balance+amount);
        }

    }
    public  int findIndex(String t) {
        for(int i=0;i<clients.length;i++){
            if(Objects.equals(t, clients[i].getUsername())){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args)throws IOException {


        System.out.println("Waiting...");
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Client accepted");
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new EchoThread(socket).start();
        }
    }
}

