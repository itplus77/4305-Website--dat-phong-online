/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanhphuong
 */
@WebServlet(name = "url", urlPatterns = {"/url"})
public class url extends HttpServlet {

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
            String action = request.getParameter("href");

            if (request.getSession().getAttribute("isLogin") == null
                    || ((boolean) request.getSession().getAttribute("isLogin")) == false) {
                page = "admin/index.jsp";
            } else if (action.equalsIgnoreCase("login")) {
                page = "admin/index.jsp";
            } else if (action.equalsIgnoreCase("admin")) {
                List<entities.Room> roomList = new model.Room().getRoom();             
                
                request.setAttribute("roomList", roomList);
                page = "admin/quanlyphong.jsp";
            } else if (action.equalsIgnoreCase("admin_khach")) {
                List<entities.PhieuDat> phieuDatList = new model.PhieuDat().getPhieuDatByActive();             
                
                request.setAttribute("phieuDatList", phieuDatList);
                page = "admin/quanlykhachhang.jsp";
            } else if (action.equalsIgnoreCase("admin_khach")) {
                List<entities.PhieuDat> phieuDatList = new model.PhieuDat().getPhieuDatByActive();             
                
                request.setAttribute("phieuDatList", phieuDatList);
                page = "admin/quanlykhachhang.jsp";
            }  else if (action.equalsIgnoreCase("admin_thongke")) {
                request.setAttribute("thongKeList", new model.ThongKe().getThongKe());
                page = "admin/quanlydoanhthu.jsp";
            } else if (action.equalsIgnoreCase("edit_phieudat")) {
                entities.PhieuDat phieuDat = new model.PhieuDat().getPhieuDatByID(request.getParameter("id"));             
                
                request.setAttribute("phieuDat", phieuDat);
                page = "admin/suakhachhang.jsp";
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
