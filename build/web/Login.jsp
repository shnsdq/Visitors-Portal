

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/indexCss.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div id="headerId">
            <img src="Images/header.png" id="headImg"/>
        </div>
        
        <div id="mainId">
            <div id="menuId">
                <a href="index.html" class="menuCl">HOME</a>
                <a href="Login.jsp" class="menuCl">Login</a>
            </div>
            
            <div id="MainCnt">
                <div>
                    <form action="LoginServlet" method="post">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h3>User Login</h3>
                            </td>
                        </tr>
                        <tr>
                            <td>User Type : </td>
                            <td>
                                <select name="ut">
                                    <option value="1">Admin</option>
                                    <option value="2">Staff</option>
                                    <option value="3">Working Staff</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Email : </td>
                            <td><input type="text" name="email" /></td>
                        </tr>
                        <tr>
                            <td>Password :</td>
                            <td><input type="password" name="password" /> </td>
                        </tr>
                        <tr>
                            <td><Input type="submit" name="Login" value="Login" /></td>
                            <td><a href="Registration.jsp">Sign Up</a> </td>
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
