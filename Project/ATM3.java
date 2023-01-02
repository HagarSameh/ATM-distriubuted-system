package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ATM3 {

    public ATM3(String address, int port) {

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
                line = input.readUTF();
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
        form.setVisible(true);  //make form visible to the user
        form.setLocationRelativeTo(null);


        ATM3 s1 = new ATM3("127.0.0.3", 5000);

    }
}
