<%-- 
    
--%>
<%@page import="java.sql.SQLException"%>
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
                <form action="AddStaff" method="post">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h2>Add New Staff </h2>
                            </td>
                        </tr>
                        <tr>
                            <td>Name : </td>
                            <td><input type="text" name="nmTxt" /></td>
                        </tr>
                        <tr>
                            <td>Email : </td>
                            <td><input type="email" name="emTxt" /></td>
                        </tr>
                        <tr>
                            <td>Password : </td>
                            <td><input type="password" name="psTxt" /></td>
                        </tr>
                        <tr>
                            <td>Gender : </td>
                            <td>
                                Male <input type="radio" name="gnTxt" value="Male"/>
                                Female<input type="radio" name="gnTxt" value="Female" />
                            </td>
                        </tr>
                        <tr>
                            <td>Date of Birth : </td>
                            <td><input type="date" name="dbTxt" /></td>
                        </tr>
                        <tr>
                            <td>mobile : </td>
                            <td><input type="text" name="moTxt" /></td>
                        </tr>
                        <tr>
                            <td>Address : </td>
                            <td><input type="text" name="adTxt" /></td>
                        </tr>
                        <tr>
                            <td>Department : </td>
                            <td><input type="text" name="dpTxt" /></td>
                        </tr>
                        <tr>
                            <td>Post : </td>
                            <td><input type="text" name="poTxt" /></td>
                        </tr>
                        <tr>
                            <td><Input type="submit" name="Add Staff" value="Add Staff" /></td>
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