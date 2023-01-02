package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank extends JFrame implements ActionListener {
    JButton btn_check,btn_withdraw,btn_deposit,btn_transaction,btn_withdraw2,btn_deposit2,btn_trans2;
    JPanel newPanel, panel1,panel2,panel3,panel4, panel5,panel;
    JLabel lbl_balance, lbl_withdraw,lbl_deposit,lbl1_trans,lbl2_trans,lbl_header;
    JTextField  txt_withdraw, txt_deposit,txt_trans_amount , txt_trans_client;
    String username;
    int index;
    Server s;


    //constructor
    Bank(String user)
    {
        username=user;
        s=new Server();
        index= s.findIndex(username);
        btn_check=new JButton();
        btn_deposit=new JButton();
        btn_deposit2=new JButton();
        btn_trans2=new JButton();
        btn_withdraw=new JButton();
        btn_withdraw2=new JButton();
        btn_transaction=new JButton();
        lbl_balance=new JLabel();
        lbl2_trans=new JLabel();
        lbl_deposit=new JLabel();
        lbl_withdraw=new JLabel();
        lbl_header=new JLabel();
        lbl1_trans=new JLabel();
        txt_deposit=new JTextField(15);
        txt_trans_amount=new JTextField(15);
        txt_trans_client=new JTextField(15);
        txt_withdraw=new JTextField(15);

        lbl_withdraw.setText("Enter amount of $ to withdraw:");
        lbl1_trans.setText("Enter amount of $ to transact:");
        lbl_deposit.setText("Enter amount of $ to deposit:");
        lbl2_trans.setText("Enter Client name to transact to:");
        lbl_balance.setText("Your Balance is :");
        lbl_header.setText("Welcome to your Account");
        lbl_header.setFont(new Font("Serif", Font.PLAIN, 22));


        btn_withdraw.setText("Withdraw");
        btn_transaction.setText("Transaction");
        btn_withdraw2.setText("Withdraw");
        btn_deposit.setText("Deposit");
        btn_deposit2.setText("Deposit");
        btn_check.setText("Check Balance");
        btn_trans2.setText("Transact");

        btn_withdraw2.setVisible(false);
        btn_trans2.setVisible(false);
        btn_deposit2.setVisible(false);
        lbl_balance.setVisible(false);
        lbl2_trans.setVisible(false);
        lbl_withdraw.setVisible(false);
        lbl_deposit.setVisible(false);
        lbl1_trans.setVisible(false);
        txt_withdraw.setVisible(false);
        txt_trans_client.setVisible(false);
        txt_deposit.setVisible(false);
        txt_trans_amount.setVisible(false);

        panel1=new JPanel(new GridLayout(6,1,5,5));
        panel1.add(btn_check);
        panel1.add(lbl_balance);
        panel2=new JPanel(new GridLayout(6,1,5,5));
        panel2.add(btn_withdraw);
        panel2.add(lbl_withdraw);
        panel2.add(txt_withdraw);
        panel2.add(btn_withdraw2);
        panel3=new JPanel(new GridLayout(6,1,5,5));
        panel3.add(btn_deposit);
        panel3.add(lbl_deposit);
        panel3.add(txt_deposit);
        panel3.add(btn_deposit2);
        panel4=new JPanel(new GridLayout(6,1,5,5));
        panel4.add(btn_transaction);
        panel4.add(lbl1_trans);
        panel4.add(txt_trans_amount);
        panel4.add(lbl2_trans);
        panel4.add(txt_trans_client);
        panel4.add(btn_trans2);
        panel5=new JPanel(new GridLayout(1,4,20,20));
        panel5.add(panel1);
        panel5.add(panel2);
        panel5.add(panel3);
        panel5.add(panel4);
        panel=new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(lbl_header);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        newPanel = new JPanel(new BorderLayout());
        newPanel.add(panel,BorderLayout.NORTH);
        newPanel.add(panel5,BorderLayout.CENTER);


        add(newPanel, BorderLayout.CENTER);
        btn_check.addActionListener(this);
        btn_deposit.addActionListener(this);
        btn_withdraw.addActionListener(this);
        btn_transaction.addActionListener(this);
        btn_deposit2.addActionListener(this);
        btn_withdraw2.addActionListener(this);
        btn_trans2.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn_check){
            lbl_balance.setVisible(true);
            System.out.println("Check");
            lbl_balance.setText("Balance : "+s.Check_Balance(index)+" $.");
        }
        else if (e.getSource()==btn_withdraw){
            lbl_withdraw.setVisible(true);
            txt_withdraw.setVisible(true);
            btn_withdraw2.setVisible(true);
            System.out.println("Withdraw");


        }
        else if (e.getSource()==btn_deposit){
            lbl_deposit.setVisible(true);
            txt_deposit.setVisible(true);
            btn_deposit2.setVisible(true);
            System.out.println("Deposit");

        }
        else if (e.getSource()==btn_transaction){
            lbl1_trans.setVisible(true);
            txt_trans_amount.setVisible(true);
            lbl2_trans.setVisible(true);
            txt_trans_client.setVisible(true);
            btn_trans2.setVisible(true);
            System.out.println("Transaction");

        }
       else if (e.getSource()==btn_withdraw2){
            String amount1=txt_withdraw.getText();
            int amount2=Integer.parseInt(amount1);
            s.Withdraw(amount2,index);
        }
        else if (e.getSource()==btn_deposit2){
            String amount5=txt_deposit.getText();
            int amount2=Integer.parseInt(amount5);
            s.Deposit(amount2,index);
        }
        else if (e.getSource()==btn_trans2){

            String amount6=txt_trans_amount.getText();
            int amount7=Integer.parseInt(amount6);
            String index2=txt_trans_client.getText();
            int index22=Integer.parseInt(index2);
            s.Transaction(amount7,index,index22);
        }


    }
}
