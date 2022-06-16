/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author NguyenKhoa
 */
public class ClientConsole {
    public static void main(String[] args) {
        Socket client = null;
        DataOutputStream output;   
        DataInputStream input;
        
        Scanner sc = new Scanner(System.in);
        
        try {
            while (true) {                
                System.out.print("Nhap vao chuoi bat ky: ");
                String mes = sc.nextLine();
                client = new Socket(InetAddress.getLocalHost(), 9010);
                output = new DataOutputStream(client.getOutputStream());            
                output.writeUTF(mes);
                
                input = new DataInputStream(client.getInputStream());
                mes = input.readUTF();
                System.out.println(mes);
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
