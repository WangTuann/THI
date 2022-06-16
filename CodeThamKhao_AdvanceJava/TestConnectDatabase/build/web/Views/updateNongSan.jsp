<%-- 
    Document   : updateNongSan.jsp
    Created on : Jun 14, 2022, 9:57:19 PM
    Author     : NguyenKhoa
--%>

<%@page import="Models.NongSan"%>
<%@page import="Models.DBNongSan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../Style/main.css"/>
        <title>Cập nhật nông sản</title>        
    </head>
    <body>
        <%
            int maNongSan = Integer.parseInt(request.getParameter("id"));
            DBNongSan dBNongSan = new DBNongSan();
            NongSan ns = dBNongSan.getNongSanByID(maNongSan);
        %>
        <div class="formDiv">
            <h2>Cập nhật nông sản</h2>
            <form method="POST" action="../CNongSan">
                <input type="text" name="ma" readonly value="<%out.print(ns.getMaNongSan());%>" /><br>
                <input type="text" name="ten" required placeholder="Nhập tên nông sản" value="<%out.print(ns.getTenNongSan());%>" /><br>
                <input type="text" name="dvt" required placeholder="Nhập đơn vị tính" value="<%out.print(ns.getDonViTinh());%>" /><br>
                <input type="number" name="gia" required placeholder="Nhập giá tiền" min="0" value="<%out.print(ns.getGiaTienStr());%>" /><br>
                <input type="submit" name="update" value="Cập Nhật" />
            </form>  
        </div>        
    </body>
</html>
