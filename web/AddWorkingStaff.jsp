

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Css/add.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
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
                <div>
                    <form action="AddUser" method="post">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h3>Add Working Staff </h3>
                            </td>
                        </tr>
                        <tr>
                            <td>Name : </td>
                            <td><input type="text" name="name" /></td>
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
                            <td>Date of Birth : </td>
                            <td><input type="date" name="dob" /></td>
                        </tr>
                        <tr>
                            <td>Gender : </td>
                            <td>
                                <select name="gender">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Mobile : </td>
                            <td><input type="text" name="mobile" /></td>
                        </tr>
                        <tr>
                            <td>Address : </td>
                            <td><input type="text" name="address" /></td>
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
                        <tr>
                            <td><Input type="submit" name="Add WorkingStaff" value="Add WorkingStaff" /></td>
                            <td><Input type="reset" name="Reset" value="Reset" /> </td>
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