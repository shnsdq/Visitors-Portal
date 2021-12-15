package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class TodayStaffVisitor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Today Staff Visitor</title>\n");
      out.write("        <link href=\"Css/add.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"headerId\">\n");
      out.write("            <img src=\"Images/header.png\" id=\"headImg\"/>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"mainId\">\n");
      out.write("            <div id=\"menuId\">\n");
      out.write("                <a href=\"StaffHome.jsp\" class=\"menuCl\">Home</a>\n");
      out.write("                <a href=\"TodayStaffVisitor.jsp\" class=\"menuCl\">Today Visitor Detail</a>\n");
      out.write("                <a href=\"StaffVisitorOut.jsp\" class=\"menuCl\">Visitor Out</a> \n");
      out.write("                <a href=\"StaffAllVisitor.jsp\" class=\"menuCl\">All Visitor</a>\n");
      out.write("                <a href=\"LogOut.jsp\" class=\"menuCl\">LogOut</a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"MainCnt\">\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <H1>Show Today Visitor Details</H1>\n");
      out.write("                <table style=\"border-collapse: collapse;width: 100%;\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:5%;\">ID</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;\">Name</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:15%;\">Gender</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Mobile</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Address</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Enter Date Time</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Purpose</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Staff Out</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Staff Out Time</th>\n");
      out.write("                        <th style=\"text-align: left;padding: 8px;background-color: #4CAF50;color: white; width:12%;\">Click Staff Out</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        try{
                            
                            Calendar cal = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String dts1= sdf.format(cal.getTime());
                            pt = conn.prepareStatement("select * from visitors where staff_id = ? and out_staff=0");
                            pt.setInt(1, sid);
                            ResultSet rs = pt.executeQuery();
                            while(rs.next()) {
                                String ots=null;
                                int ot=rs.getInt(8);
                                if(ot==0)
                                    ots="Not Out";
                                else
                                    ots="Out";
                    
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
      out.print( rs.getString(4));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(5));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(7));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( rs.getString(12));
      out.write("</td>\n");
      out.write("                        <td style=\"text-align: left;padding: 8px;width:12%;\">");
      out.print( ots);
      out.write("</td>\n");
      out.write("                        <form action=\"StaffVisitorOut\">\n");
      out.write("                            <input type=\"hidden\" name=\"vIdTxt\" value=\"");
      out.print( rs.getString(1));
      out.write("\" />\n");
      out.write("                            <td style=\"text-align: left;padding: 8px;width:12%;\">\n");
      out.write("                                <input type=\"submit\" name=\"Visitor Out\" name=\"Value Out\" />\n");
      out.write("                            </td>\n");
      out.write("                        </form>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    
      out.write("\n");
      out.write("                </table> \n");
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
