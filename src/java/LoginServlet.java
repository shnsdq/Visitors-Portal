/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    Connection conn = null;
    PreparedStatement pt = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String email,password;
        int userId=0,ut;

        //HttpSession hs = request.getSession();
        email=request.getParameter("email");
        password=request.getParameter("password");
        ut=Integer.parseInt(request.getParameter("ut"));
        System.out.println(email+"    "+password);
        try{
            
            conn=DbConn.connectDb();
            if(ut==1)
            {
                pt=conn.prepareStatement("select * from admins where email = ? and password = ?");
                pt.setString(1,email);
                pt.setString(2,password);
                ResultSet rs = pt.executeQuery();
                System.out.println("test2");
                if(rs.next())
                {
                    HttpSession session = request.getSession();

                    userId =rs.getInt(1);
                    session.setAttribute("userId", userId);
                    session.setAttribute("userName", rs.getString(2));
                    //hs.setAttribute("userId", userId);
                    System.out.println("test3");
                    RequestDispatcher rd =request.getRequestDispatcher("AdminHome.jsp");
                    rd.forward(request, response);
                }
                else{
                    request.setAttribute("msg", "Enter valid email & password ");
                    RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
            }else if(ut==2){
                pt=conn.prepareStatement("select * from staffs where email = ? and password = ?");
                pt.setString(1,email);
                pt.setString(2,password);
                ResultSet rs = pt.executeQuery();
                System.out.println("test2");
                if(rs.next())
                {
                    HttpSession session = request.getSession();

                    userId =rs.getInt(1);
                    session.setAttribute("userId", userId);
                    session.setAttribute("userName", rs.getString(2));
                    //hs.setAttribute("userId", userId);
                    System.out.println("test3");
                    RequestDispatcher rd =request.getRequestDispatcher("StaffHome.jsp");
                    rd.forward(request, response);
                }
                else{
                    request.setAttribute("msg", "Enter valid email & password ");
                    RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
            }else{
                pt=conn.prepareStatement("select * from working_staffs where email = ? and password = ?");
                pt.setString(1,email);
                pt.setString(2,password);
                ResultSet rs = pt.executeQuery();
                System.out.println("test2");
                if(rs.next())
                {
                    HttpSession session = request.getSession();

                    userId =rs.getInt(1);
                    session.setAttribute("userId", userId);
                    session.setAttribute("userName", rs.getString(2));
                    //hs.setAttribute("userId", userId);
                    System.out.println("test3");
                    RequestDispatcher rd =request.getRequestDispatcher("WorkingStaffHome.jsp");
                    rd.forward(request, response);
                }
                else{
                    request.setAttribute("msg", "Enter valid email & password ");
                    RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
            }
        }
        catch(SQLException | ServletException | IOException e){
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
