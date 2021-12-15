 

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Staff</title>
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
                <form action="#" method="post">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h2>Show Staff </h2>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="Radio" name="allDTxt" value="AllTxt" />
                                Department Name : 
                            </td>
                            <td>
                                <select name="dnTxt">
                                    <%
                                        String dn;
                                        try{
                                            pt = conn.prepareStatement("select distinct department from staffs order by department");
                                            ResultSet rs = pt.executeQuery();
                                            while(rs.next()) {
                                                dn=rs.getString(1);
                                               
                                    %>
                                    <option value="<%= dn %>"><%= dn %></option>
                                    <%
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="Radio" name="allDTxt" value="AllDTxt" checked="true" /> All Department</td>
                        </tr>
                        <tr>
                            <td><Input type="submit" name="Show Staff" value="Show Staff" /></td>
                            <td><Input type="reset" name="Reset" value="Reset" /> </td>
                        </tr>
                    </table>
                </form>
                <br> 
                <H1>Show Staff</H1>
                <table style="border-collapse: collapse;width: 100%;">
                    <tr>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:5%;">ID</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;">Name</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;">Email</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Gender</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Dob</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Mobile</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Department</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Post</th>
                    </tr>
                    <%
                        try{
                            String qu,tx="";
                            try{
                                tx=request.getParameter("allDTxt");
                            }catch(Exception e){
                                pt = conn.prepareStatement("select * from staffs");
                            }
                            
                            if(tx.equalsIgnoreCase("AllTxt")){
                               pt = conn.prepareStatement("select * from staffs where department = ?");
                                pt.setString(1, request.getParameter("dnTxt"));
                            }else{
                                pt = conn.prepareStatement("select * from staffs");
                            }
                            
                            ResultSet rs = pt.executeQuery();
                            while(rs.next()) {
               
                    %>
                    <tr>
                        <td style="text-align: left;padding: 8px;width:5%;"><%= rs.getString(1)%></td>
                        <td style="text-align: left;padding: 8px;width:15%;"><%= rs.getString(2)%></td>
                        <td style="text-align: left;padding: 8px;width:15%;"><%= rs.getString(3)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(5)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(6)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(7)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(9)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(10)%></td>
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
