package com.company;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EchoThread extends Thread {
    protected Socket socket;
    private static Client[] clients;
    private static int cInd ;
    private static  int client_id;
    private final ServerSocket  server   = null;
    /*


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

       public int Check_Balance(int client_id)
       {
           return clients[client_id].getBalance();
       }

       public void Withdraw(int amount, int client_id) {
           int balance = clients[client_id].getBalance();
           if(amount<=7000 && amount <= balance)
           {
               clients[client_id].setBalance(balance - amount);
           }


       }

       public void Deposit(int amount , int client_id) {
           clients[client_id].setBalance(clients[client_id].getBalance()+amount);
       }

       public void Transaction(int amount , int client_id , int to_client_id){
           int balance=clients[client_id].getBalance();
           if(amount<=7000 && amount<=balance){
               clients[client_id].setBalance(balance-amount);
               clients[to_client_id].setBalance(balance+amount);
           }

       }
    */
    Server s= new Server();

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        // starts server and waits for a connection
        try
        {
            DataInputStream in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

            String line = "";
            String username;
            String Password;
            String withdraw_amount;
            String deposit_amount;
            String Transaction_amount;
            String client_for_trans;

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    if(line.equals("L")){
                        System.out.println("Login");
                        // Login()
                        username=in.readUTF();
                        System.out.println("Username is: "+username);
                        Password=in.readUTF();
                        System.out.println("Password is:"+Password);
                        if(s.Login(username,Password)){
                            System.out.println("User: " +username+" Logged in successfully.");
                        }else {
                            System.out.println("Username or password is wrong please try again");
                        }

                    }
                    if(line.equals("D")){
                        deposit_amount=in.readUTF();
                        int deposit=Integer.parseInt(deposit_amount);
                        s.Deposit(deposit,client_id);
                        System.out.println("User number: "+client_id+ " Deposit: "+ deposit+" $ to his account.");

                    }
                    if(line.equals("W")){
                        withdraw_amount=in.readUTF();
                        int withdraw=Integer.parseInt(withdraw_amount);
                        s.Withdraw(withdraw,client_id);
                        System.out.println("User number: "+ client_id+ " withdraw: "+ withdraw+ " $.");

                    }
                    if(line.equals("C")){
                        System.out.println("User number:" +client_id + " Wants to check Balance.");
                        System.out.println(s.Check_Balance(client_id)+" $.");

                    }
                    if(line.equals("T")){
                        Transaction_amount=in.readUTF();
                        int trans=Integer.parseInt(Transaction_amount);
                        client_for_trans=in.readUTF();
                        int c=Integer.parseInt(client_for_trans);
                        s.Transaction(trans,client_id,c);
                        System.out.println("User number :"+ client_id+ "transact by "+ trans+"$ to user number: "+c);
                    }


                }
                catch(IOException i){ System.out.println(i); }

            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)  { System.out.println(i);  }
    }
}

