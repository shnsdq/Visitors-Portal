/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StaffVisitorOut extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int vid=0;
        vid=Integer.parseInt(request.getParameter("vIdTxt"));
        try{
            conn = DbConn.connectDb();
            System.out.println("T211");
            String qt ="update visitors set "
                    + "out_staff=1, out_staff_time =? "
                    + "where visitor_id =? ";
            ps=conn.prepareStatement(qt);
            ps.setString(1,AdminData.sysDateTime());
            ps.setInt(2,vid);
            int i = ps.executeUpdate();
            if(i>0){
                request.setAttribute("msg", "Visitor out ");
                RequestDispatcher rd =request.getRequestDispatcher("TodayStaffVisitor.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg", "Visitor Not out ");
                RequestDispatcher rd =request.getRequestDispatcher("TodayStaffVisitor.jsp");
                rd.forward(request, response);
            }
            
        }
        catch(SQLException | ServletException | IOException e)
        {
            request.setAttribute("msg", "Enter Valid Data!!!! ");
            RequestDispatcher rd =request.getRequestDispatcher("TodayStaffVisitor.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
