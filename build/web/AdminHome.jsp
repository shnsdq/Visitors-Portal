
<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
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
                <h1>Admin Home</h1>
            
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
