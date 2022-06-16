/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NguyenKhoa
 */
public class ServerConsole {
    public static void main(String[] args) {
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
                System.out.println(mes);
                int kq = TinhGiaiThua(mes);
                ouput = new DataOutputStream(client.getOutputStream());
                ouput.writeUTF(String.valueOf(kq));
                client.close();
            }
        } catch (Exception e) {
        }
    }
    
    static int TinhGiaiThua(String n) {
        int kq = 1;        
        int num = Integer.parseInt(n);
        for (int i = 1; i <= num; i++) {
            kq *= i;
        }        
        return kq;
    }
}
