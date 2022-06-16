<%-- 
    Document   : listNongSan
    Created on : Jun 14, 2022, 8:52:24 PM
    Author     : NguyenKhoa
--%>

<%@page import="Models.DBNongSan"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Style/main.css"/>
        <title>Danh sách nông sản</title>
    </head>
    <body>

        <div class="formDiv">
            <h2>Thêm nông sản mới</h2>
            <form method="POST" action="../CNongSan">            
                <input type="text" required name="ten" placeholder="Nhập tên nông sản" /><br>
                <input type="text" required name="dvt" placeholder="Nhập đơn vị tính" /><br>
                <input type="number" required min="0" name="gia" placeholder="Nhập giá tiền" /><br>
                <input type="submit" name="them" value="Thêm" />
            </form>       
        </div>  

        <div>
            <h2>Danh sách các nông sản</h2>
            <table border="1">
                <tr>
                    <th>Mã nông sản</th>
                    <th>Tên nông sản</th>
                    <th>Đơn vị tính</th>
                    <th>Giá tiền</th>
                    <th colspan="2">Tùy chọn</th>
                </tr>            
                <%
                    DBNongSan dbNongSan = new DBNongSan();
                    ResultSet rs = dbNongSan.getAllNongSan();
                    if (rs != null) {
                        int count = rs.getMetaData().getColumnCount();
                        while (rs.next()) {
                            out.print("<tr>");
                            for (int i = 1; i <= count; i++) {
                                out.print("<td>" + rs.getString(i) + "</td>");
                            }
                            out.print("<td><a href=\"updateNongSan.jsp?id=" + rs.getString(1) + "\">Cập nhật</a></td>");
                            out.print("<td><a href=\"../CNongSan?id=" + rs.getString(1) + "\">Xóa</a></td>");
                            out.print("</tr>");
                        }
                    }
                %>        
            </table>   
        </div>               
    </body>
</html>
