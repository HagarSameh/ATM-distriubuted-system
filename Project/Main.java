package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JButton checkBalanceButton;
    private JButton withdrawButton;
    private JButton depositeButton;
    private JButton transactionButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton transactButton;
    private JButton depositeButton1;
    private JButton withdrawButton1;
    private JButton checkButton;
    private JTextField textField1;
    private JLabel balance;

    public static void main(String[] args) {

        JFrame f=new JFrame();//creating instance of JFrame


        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible



    }
}
