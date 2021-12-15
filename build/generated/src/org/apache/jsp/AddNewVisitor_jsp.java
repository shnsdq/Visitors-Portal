package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class AddNewVisitor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"Css/add.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"headerId\">\n");
      out.write("            <img src=\"Images/header.png\" id=\"headImg\"/>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"mainId\">\n");
      out.write("            <div id=\"menuId\">\n");
      out.write("                <a href=\"WorkingStaffHome.jsp\" class=\"menuCl\">Home</a>\n");
      out.write("                <a href=\"AddNewVisitor.jsp\" class=\"menuCl\">Add New Visitor</a>\n");
      out.write("                <a href=\"ShowVisitor.jsp\" class=\"menuCl\">Show Visitor</a> \n");
      out.write("                <a href=\"VisitorOut.jsp\" class=\"menuCl\">Add Visitor Out</a>\n");
      out.write("                <a href=\"ShowVisitorOut.jsp\" class=\"menuCl\">Show Visitor Out</a>\n");
      out.write("                <a href=\"LogOut.jsp\" class=\"menuCl\">LogOut</a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"MainCnt\">\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <form action=\"#\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Staff Name :</td>\n");
      out.write("                            <td><input type=\"text\" name=\"snTxt\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><input type=\"submit\" name=\"Show Staff Detail\" value=\"Show Staff Detail\" /></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write(" \n");
      out.write("                <H2>Show Staff Detail</H2>\n");
      out.write("                <table style=\"border-collapse: collapse;width: 100%;\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:5%;\">ID</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;\">Name</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;\">Email</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Gender</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Dob</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Mobile</th>\n");
      out.write("                         <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Department</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Post</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

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
               
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:5%;\">");
      out.print( rs.getString(1));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:15%;\">");
      out.print( rs.getString(2));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:15%;\">");
      out.print( rs.getString(3));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(5));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(6));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(7));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(9));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(10));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    
      out.write("\n");
      out.write("                </table> \n");
      out.write("                \n");
      out.write("                <form action=\"AddVisitor\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\">\n");
      out.write("                                <h2>Add New Visitor </h2>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                        <tr>\n");
      out.write("                            <td>Staff Id : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"sidTxt\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Visitor Name : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"nmTxt\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Gender : </td>\n");
      out.write("                            <td>\n");
      out.write("                                Male <input type=\"radio\" name=\"gnTxt\" value=\"Male\" />\n");
      out.write("                                Female <input type=\"radio\" name=\"gnTxt\" value=\"Female\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Mobile : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"moTxt\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Address : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"adTxt\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Purpose : </td>\n");
      out.write("                            <td><textarea name=\"puTxt\" row=\"4\" cols=\"20\"></textarea></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><Input type=\"submit\" name=\"Add Visitor\" value=\"Add Visitor\" /></td>\n");
      out.write("                            <td><Input type=\"reset\" name=\"Reset\" value=\"Reset\" /> </td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\">\n");
      out.write("                                ");

                                    if(request.getAttribute("msg")!=null){
                                
      out.write("\n");
      out.write("                                <h2><font color=\"red\">");
      out.print(request.getAttribute("msg").toString());
      out.write("</font></h2>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table> \n");
      out.write("                </form>\n");
      out.write("            \n");
      out.write("            </div>   \n");
      out.write("        </div>\n");
      out.write("        <div id=\"foot\">\n");
      out.write("            <marquee>\n");
      out.write("                <img src=\"Images/n1.jpg\" class=\"footImg\" />\n");
      out.write("                <img src=\"Images/n4.jpg\" class=\"footImg\" />\n");
      out.write("                <img src=\"Images/n3.jpg\" class=\"footImg\" />\n");
      out.write("                <img src=\"Images/n2.jpg\" class=\"footImg\" />\n");
      out.write("            </marquee>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
