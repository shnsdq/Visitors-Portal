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

public class AddStaff extends HttpServlet {

    Connection conn = null;
    PreparedStatement pt = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nm,em,ps,gn,db,mo,ad,dp,po;
        nm=request.getParameter("nmTxt");
        em=request.getParameter("emTxt");
        ps=request.getParameter("psTxt");
        gn=request.getParameter("gnTxt");
        db=request.getParameter("dbTxt");
        mo=request.getParameter("moTxt");
        ad=request.getParameter("adTxt");
        dp=request.getParameter("dpTxt");
        po=request.getParameter("poTxt");
        try{
            conn = DbConn.connectDb();
            String q ="insert into staffs "
                    + "(name,email,password,gender,dob,mobile,address,department,post) "
                    + "value "
                    + "(?,?,?,?,?,?,?,?,?)";
            pt=conn.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);
            pt.setString(1,nm);
            pt.setString(2,em);
            pt.setString(3,ps);
            pt.setString(4,gn);
            pt.setString(5,db);
            pt.setString(6,mo);
            pt.setString(7,ad);
            pt.setString(8,dp);
            pt.setString(9,po);
            int i = pt.executeUpdate();
            System.out.println("Add New");
            ResultSet rs = pt.getGeneratedKeys();
            if(rs.next()){
                request.setAttribute("msg", "Add Staff ");
                RequestDispatcher rd =request.getRequestDispatcher("AddStaff.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg", "Not Add Staff ");
                RequestDispatcher rd =request.getRequestDispatcher("AddStaff.jsp");
                rd.forward(request, response);
            }
            
        }
        catch(SQLException | ServletException | IOException e)
        {
            request.setAttribute("msg", "Enter Valid Data!!!! ");
            RequestDispatcher rd =request.getRequestDispatcher("AddStaff.jsp");
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
