/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanhphuong
 */
@WebServlet(name = "ThanhToan", urlPatterns = {"/ThanhToan"})
public class ThanhToan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String page = "";
            String action = request.getParameter("action");
            
            if (action.equalsIgnoreCase("ThanhToan")) {
                entities.PhieuDat phieuDat = new model.PhieuDat().getPhieuDatByID(request.getParameter("id"));
                float tienphong = Float.parseFloat(request.getParameter("tienphong"));
                
                    out.print(phieuDat.getDatein());
                try {
                    Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(phieuDat.getDatein());
                    Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(phieuDat.getDateout());
                    long diff = Math.abs(d1.getTime() - d2.getTime());
                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    
                    float thanhtien = tienphong * diffDays;
                    entities.ThanhToan thanhToan = new entities.ThanhToan(phieuDat, thanhtien);
                    new model.ThanhToan().saveOrUpdate(thanhToan);
                    new model.PhieuDat().updateActive(phieuDat, false);
                    
                    List<entities.ThanhToan> list = new model.ThanhToan().getThanhToan();
                    page = "exportThanhToan?exportToExcel=YES&id="+list.get(list.size() - 1).getIdthanhtoan();
                } catch (ParseException | SQLException ex) {
                    page = "url?href=admin_khach";
                    Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            request.getRequestDispatcher(page).forward(request, response);
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
