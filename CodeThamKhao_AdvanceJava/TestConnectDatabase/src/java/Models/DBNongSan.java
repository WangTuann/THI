/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;

/**
 *
 * @author NguyenKhoa
 */
public class DBNongSan {    
    
    List<NongSan> list = new ArrayList<>();
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/nongnghiep";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "root";
    String pwd = "";     
    
    public DBNongSan() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, pwd);            
        } catch (Exception e) {
        }
    } 
    
    public ResultSet getAllNongSan() {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("Select * From nongsan");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return rs;
    }
    
    public int addNongSan(NongSan ns) {
        int kq = 0;
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("INSERT INTO nongsan VALUES (NULL, '%s', '%s', '2%f')", ns.tenNongSan, ns.donViTinh, ns.giaTien);
            kq = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return kq;
    }
    
    public int updateNongSan(NongSan ns) {
        int kq =0;
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("Update nongsan Set tenNongSan = '%s', donViTinh = '%s', giaTien = '%2f' Where maNongSan = %d", ns.tenNongSan, ns.donViTinh, ns.giaTien, ns.maNongSan);
            kq = stmt.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }  
        return kq;
    }
    
    public int deleteNongSan(int maNongSan) {
        int kq = 0;
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("DELETE FROM nongsan WHERE maNongSan = %d", maNongSan);
            kq = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return kq;
    }
    
    public NongSan getNongSanByID(int maNongSan) {
        NongSan kq = null;
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("Select * FROM nongsan WHERE maNongSan = %d", maNongSan);
            rs = stmt.executeQuery(query);
            while (rs.next()) {                
                 kq = new NongSan(maNongSan, rs.getString(2), rs.getString(3), rs.getDouble(4));  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return kq;
    }
}
