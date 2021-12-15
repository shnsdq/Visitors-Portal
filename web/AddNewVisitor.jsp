

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
                <a href="WorkingStaffHome.jsp" class="menuCl">Home</a>
                <a href="AddNewVisitor.jsp" class="menuCl">Add New Visitor</a>
                <a href="ShowVisitor.jsp" class="menuCl">Show Visitor</a> 
                <a href="VisitorOut.jsp" class="menuCl">Add Visitor Out</a>
                <a href="ShowVisitorOut.jsp" class="menuCl">Show Visitor Out</a>
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
                            <td>Staff Name :</td>
                            <td><input type="text" name="snTxt" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Show Staff Detail" value="Show Staff Detail" /></td>
                            <td></td>
                        </tr>
                    </table>
                </form>
 
                <H2>Show Staff Detail</H2>
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
                                tx=request.getParameter("snTxt");
                            }catch(Exception e){
                                System.out.println(e);
                            }
                            pt = conn.prepareStatement("select * from staffs where name = ?");
                            pt.setString(1, request.getParameter("snTxt"));
                            
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
                
                <form action="AddVisitor" method="post">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h2>Add New Visitor </h2>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Staff Id : </td>
                            <td><input type="text" name="sidTxt" /></td>
                        </tr>
                        <tr>
                            <td>Visitor Name : </td>
                            <td><input type="text" name="nmTxt" /></td>
                        </tr>
                        <tr>
                            <td>Gender : </td>
                            <td>
                                Male <input type="radio" name="gnTxt" value="Male" />
                                Female <input type="radio" name="gnTxt" value="Female" />
                            </td>
                        </tr>
                        <tr>
                            <td>Mobile : </td>
                            <td><input type="text" name="moTxt" /></td>
                        </tr>
                        <tr>
                            <td>Address : </td>
                            <td><input type="text" name="adTxt" /></td>
                        </tr>
                        <tr>
                            <td>Purpose : </td>
                            <td><textarea name="puTxt" row="4" cols="20"></textarea></td>
                        </tr>
                        <tr>
                            <td><Input type="submit" name="Add Visitor" value="Add Visitor" /></td>
                            <td><Input type="reset" name="Reset" value="Reset" /> </td>
                        </tr> 
                        <tr>
                            <td colspan="2">
                                <%
                                    if(request.getAttribute("msg")!=null){
                                %>
                                <h2><font color="red"><%=request.getAttribute("msg").toString()%></font></h2>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                    </table> 
                </form>
            
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
