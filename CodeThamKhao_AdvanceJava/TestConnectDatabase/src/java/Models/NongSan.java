/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NguyenKhoa
 */
public class NongSan {
    int maNongSan;
    String tenNongSan;
    String donViTinh;
    double giaTien;

    public NongSan(int maNongSan, String tenNongSan, String donViTinh, double giaTien) {
        this.maNongSan = maNongSan;
        this.tenNongSan = tenNongSan;
        this.donViTinh = donViTinh;
        this.giaTien = giaTien;        
    }

    public NongSan() {
    }  

    public int getMaNongSan() {
        return maNongSan;
    }        

    public String getTenNongSan() {
        return tenNongSan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public double getGiaTien() {
        return giaTien;
    }
    
    public  String getGiaTienStr() {
        String giaTienStr = String.valueOf(getGiaTien());
        return giaTienStr.substring(0, giaTienStr.length() - 2);
    }
}
