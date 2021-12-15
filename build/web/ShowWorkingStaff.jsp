 

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/add.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="headerId">
            <img src="Images/header.png" id="headImg"/>
        </div>
        
        <div id="mainId">
            <div id="menuId">
                <a href="AdminHome.jsp" class="menuCl">Home</a>
                <a href="AddStaff.jsp" class="menuCl">Add New Staff</a>
                <a href="ShowStaff.jsp" class="menuCl">Show Staff</a> 
                <a href="AddWorkingStaff.jsp" class="menuCl">Add Woking Staff</a>
                <a href="ShowWorkingStaff.jsp" class="menuCl">Show Working Staff</a>
                <a href="ShowVisitor.jsp" class="menuCl">Show Visitor List</a>
                <a href="LogOut.jsp" class="menuCl">LogOut</a>
            </div>
            
            <div id="MainCnt">
                <%
                    if(session.isNew())
                    {
                        RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
                        rd.forward(request, response);
                    }
                    Connection conn = null;
                    PreparedStatement pt = null;
                    try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/get_pass?user=root&password=ram");
                    }catch(Exception e){
                        System.out.println(e);
                    }        
                %>
                <H1>Show Working Staff</H1>
                <table style="border-collapse: collapse;width: 100%;">
                    <tr>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:5%;">ID</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:17%;">Name</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:17%;">Email</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:14%;">Gender</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:14%;">Dob</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:14%;">Mobile</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:14%;">Address</th>
                    </tr>
                    <%
                        try{
                            pt = conn.prepareStatement("select * from working_staffs");
                            ResultSet rs = pt.executeQuery();
                            while(rs.next()) {
               
                    %>
                    <tr>
                        <td style="text-align: left;padding: 8px;width:5%;"><%= rs.getString(1)%></td>
                        <td style="text-align: left;padding: 8px;width:17%;"><%= rs.getString(2)%></td>
                        <td style="text-align: left;padding: 8px;width:17%;"><%= rs.getString(3)%></td>
                        <td style="text-align: left;padding: 8px;width:14%;"><%= rs.getString(5)%></td>
                        <td style="text-align: left;padding: 8px;width:14%;"><%= rs.getString(6)%></td>
                        <td style="text-align: left;padding: 8px;width:14%;"><%= rs.getString(7)%></td>
                        <td style="text-align: left;padding: 8px;width:14%;"><%= rs.getString(8)%></td>
                    </tr>
                    <%
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    %>
                </table> 
            
            </div>   
        </div>
        <div id="foot">
            <marquee>
                <img src="Images/n1.jpg" class="footImg" />
                <img src="Images/n4.jpg" class="footImg" />
                <img src="Images/n3.jpg" class="footImg" />
                <img src="Images/n2.jpg" class="footImg" />
            </marquee>
        </div>
    </body>
</html>
