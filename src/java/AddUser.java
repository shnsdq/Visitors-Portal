/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;


@WebServlet(urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {


    Connection conn = null;
    PreparedStatement ps = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String nmm,em,pss,gn,mb,ad,db,cs;
       int id1=0;
        nmm=request.getParameter("name");
        em=request.getParameter("email");
        pss=request.getParameter("password");
        mb=request.getParameter("mobile");
        ad=request.getParameter("address");
        db=request.getParameter("dob");
        gn=request.getParameter("gender");
        System.out.println(nmm+"  "+em+"  "+pss+"  "+gn+"  "+mb+"  "+ad+"  "+db);

        try{
            conn = DbConn.connectDb();
            String q ="insert into working_staffs "
                    + "(name,email,password,gender,dob,mobile,address) "
                    + "value "
                    + "(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,nmm);
            ps.setString(2,em);
            ps.setString(3,pss);
            ps.setString(4,db);
            ps.setString(5,mb);
            ps.setString(6,gn);
            ps.setString(7,ad);
            int i = ps.executeUpdate();
            System.out.println("Add New");
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                id1 = rs.getInt(1);
                request.setAttribute("msg", "Welcome Your Account is Created ");
                RequestDispatcher rd =request.getRequestDispatcher("AddWorkingStaff.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg", "Your Account is not Created ");
                RequestDispatcher rd =request.getRequestDispatcher("AddWorkingStaff.jsp");
                rd.forward(request, response);
            }
            
        }
        catch(SQLException | ServletException | IOException e)
        {
            request.setAttribute("msg", "Enter Valid Details!!!! ");
            RequestDispatcher rd =request.getRequestDispatcher("AddWorkingStaff.jsp");
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
