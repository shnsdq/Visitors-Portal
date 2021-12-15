 

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Today Staff Visitor</title>
        <link href="Css/add.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="headerId">
            <img src="Images/header.png" id="headImg"/>
        </div>
        
        <div id="mainId">
            <div id="menuId">
                <a href="StaffHome.jsp" class="menuCl">Home</a>
                <a href="TodayStaffVisitor.jsp" class="menuCl">Today Visitor Detail</a>
                <a href="StaffVisitorOut.jsp" class="menuCl">Visitor Out</a> 
                <a href="StaffAllVisitor.jsp" class="menuCl">All Visitor</a>
                <a href="LogOut.jsp" class="menuCl">LogOut</a>
            </div>
            
            <div id="MainCnt">
                <%
                    int sid;
                    if(session.isNew())
                    {
                        RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
                        rd.forward(request, response);
                    }
                    sid=Integer.parseInt(session.getAttribute("userId").toString());
                    Connection conn = null;
                    PreparedStatement pt = null;
                    try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/get_pass?user=root&password=ram");
                    }catch(Exception e){
                        System.out.println(e);
                    }        
                %>
                <H1>Show Today Visitor Details</H1>
                <table style="border-collapse: collapse;width: 100%;">
                    <tr>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:5%;">ID</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;">Name</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;">Gender</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Mobile</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Address</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Enter Date Time</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Purpose</th>
                        <th style="text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;">Staff Out</th>
                    </tr>
                    <%
                        try{
                            
                            Calendar cal = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String dts1= sdf.format(cal.getTime());
                            pt = conn.prepareStatement("select * from visitors where staff_id = ?");
                            pt.setInt(1, sid);
                            ResultSet rs = pt.executeQuery();
                            while(rs.next()) {
                                String ots=null;
                                int ot=rs.getInt(8);
                                if(ot==0)
                                    ots="Not Out";
                                else
                                    ots="Out";
                    %>
                    <tr>
                        <td style="text-align: left;padding: 8px;width:5%;"><%= rs.getString(1)%></td>
                        <td style="text-align: left;padding: 8px;width:15%;"><%= rs.getString(2)%></td>
                        <td style="text-align: left;padding: 8px;width:15%;"><%= rs.getString(3)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(4)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(5)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(7)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= rs.getString(12)%></td>
                        <td style="text-align: left;padding: 8px;width:12%;"><%= ots%></td>
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
