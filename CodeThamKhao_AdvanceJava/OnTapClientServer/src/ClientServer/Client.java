/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author NguyenKhoa
 */
public class Client extends JFrame implements ActionListener {
    
    JTextField txtField, txtResult; 
    JButton btnSend;

    public Client() {
        super("Client");
        txtField = new JTextField(20);
        txtResult = new JTextField(20);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        
        btnSend = new JButton("send");
        btnSend.addActionListener(this);
        con.add(txtField);
        con.add(btnSend);
        con.add(txtResult);
        setSize(400, 300);
        setVisible(true);
    }       
            
    public static void main(String[] args) {
        Client client = new Client();
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Socket client = null;
        DataOutputStream output;
        DataInputStream input;
        
        try {
            client = new Socket(InetAddress.getLocalHost(), 9010);
            output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(txtField.getText());
            
            input = new DataInputStream(client.getInputStream());
            String mes = input.readUTF();
            txtResult.setText(mes);
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}
