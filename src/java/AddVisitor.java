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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddVisitor extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nm,gn,mo,ad,dt,pu;
        int sid=0;
        sid=Integer.parseInt(request.getParameter("sidTxt"));
        nm=request.getParameter("nmTxt");
        gn=request.getParameter("gnTxt");
        mo=request.getParameter("moTxt");
        ad=request.getParameter("adTxt");
        pu=request.getParameter("puTxt");
        dt=request.getParameter(AdminData.sysDateTime());
        try{
            conn = DbConn.connectDb();
            System.out.println("T211");
            String qt ="insert into visitors "
                    + "(name,gender,mobile,address,staff_id,enter_time,purpose) "
                    + "value "
                    + "(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(qt,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,nm);
            ps.setString(2,gn);
            ps.setString(3,mo);
            ps.setString(4,ad);
            ps.setInt(5,sid);
            ps.setString(6,dt);
            ps.setString(7,pu);
            int i = ps.executeUpdate();
            System.out.println("Add visitor");
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                request.setAttribute("msg", "Add New Visitor ");
                RequestDispatcher rd =request.getRequestDispatcher("AddNewVisitor.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg", "Visitor Not Add ");
                RequestDispatcher rd =request.getRequestDispatcher("AddNewVisitor.jsp");
                rd.forward(request, response);
            }
            
        }
        catch(SQLException | ServletException | IOException e)
        {
            request.setAttribute("msg", "Enter Valid Data!!!! ");
            RequestDispatcher rd =request.getRequestDispatcher("AddNewVisitor.jsp");
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
