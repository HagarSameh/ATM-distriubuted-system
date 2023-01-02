package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ATM1 {
    public ATM1(String address, int port) {

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream out = null;
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException u) {System.out.println(u);}

        String line = "";
        while (!line.equals("Over"))
        {
            try {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i) {System.out.println(i);}
        }
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i) {System.out.println(i);}
    }

    public static void main(String[] args) {
        CreateLoginForm form = new CreateLoginForm();
        form.setSize(300,100);  //set size of the frame
        form.setLocationRelativeTo(null);
        form.setVisible(true);  //make form visible to the user

        ATM1 s1 = new ATM1("127.0.0.1", 5000);

    }
}
