/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.awt.Container;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author NguyenKhoa
 */
public class Server extends JFrame {            

    JTextArea txtArea;
    
    public Server() {
        super("Server");
        txtArea = new JTextArea(10, 30);
        Container con = getContentPane();
        con.add(txtArea);
        setSize(400, 300);
        setVisible(true);
    }
    
    public void StartServer() {
        ServerSocket server = null;
        Socket client = null;
        DataInputStream input;
        DataOutputStream ouput;
        String mes;
        
        try {
            server = new ServerSocket(9010);
            while (true) {                
                client = server.accept();
                input = new DataInputStream(client.getInputStream());
                mes = input.readUTF();
                txtArea.append(mes);
                int kq = TinhGiaiThua(mes);
                ouput = new DataOutputStream(client.getOutputStream());
                ouput.writeUTF(String.valueOf(kq));
                client.close();
            }
        } catch (Exception e) {
        }
    }
    
    public int TinhGiaiThua(String n) {
        int kq = 1;        
        int num = Integer.parseInt(n);
        for (int i = 1; i <= num; i++) {
            kq *= i;
        }        
        return kq;
    }
    
    public static void main(String[] args) {
        Server sv = new Server();
        sv.StartServer();
        sv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
