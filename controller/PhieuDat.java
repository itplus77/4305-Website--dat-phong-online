package controller;

import entities.Khach;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PhieuDat", urlPatterns = {"/PhieuDat"})
public class PhieuDat extends HttpServlet {

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

            if (action.equalsIgnoreCase("SuaPhong")) {
                entities.Khach khach = new entities.Khach();
                khach.setCmnd(request.getParameter("cmnd_number"));
                khach.setNameK(request.getParameter("full_name"));
                khach.setEmail(request.getParameter("email"));
                khach.setSdt(request.getParameter("phone_number"));
                try {
                    new model.Khach().saveOrUpdate(khach);
                    page = "url?href=admin_khach";
                } catch (SQLException ex) {
                    page = "url?href=admin_khach";
                    Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equalsIgnoreCase("DatPhong")) {
                entities.Khach khach = new entities.Khach();
                khach.setCmnd(request.getParameter("cmnd_number"));
                khach.setNameK(request.getParameter("full_name"));
                khach.setEmail(request.getParameter("email"));
                khach.setSdt(request.getParameter("phone_number"));
                entities.PhieuDat phieuDat = new entities.PhieuDat();
                phieuDat.setIdphieu(null);
                phieuDat.setRoom(new entities.Room(request.getParameter("type_room")));
                phieuDat.setDatein("2017-" + request.getParameter("From_Month") + "-" + request.getParameter("From_Day"));
                phieuDat.setDateout("2017-" + request.getParameter("To_Month") + "-" + request.getParameter("To_Day"));
                phieuDat.setKhach(khach);
                phieuDat.setKichhoat(false);
                try {
                    if (new model.PhieuDat().checkPhongByPhieuDat(phieuDat) == false) {
                        request.setAttribute("Message", "Phòng này đã có người đặt");
                    } else {
                        new model.Khach().saveOrUpdate(khach);
                        new model.PhieuDat().saveOrUpdate(phieuDat);
                        List<entities.PhieuDat> list = new model.PhieuDat().getPhieuDat();
                        new model.SendEmailUsingGMailSMTP("tranthanhphuong77al@gmail.com",
                                "Xin chào, có người mới đặt phòng tại website của bạn. Vui lòng click vào đường link này để kích hoạt: " + connection.JDBC_Connect.URL + "PhieuDat?action=kichhoat&id=" + list.get(list.size() - 1).getIdphieu());
                    }
                    page = "index.jsp";
                } catch (SQLException ex) {
                    page = "index.jsp";
                    request.setAttribute("Message", ex.getMessage());
                    Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equalsIgnoreCase("kichhoat")) {
                entities.PhieuDat phieuDat = new entities.PhieuDat();
                phieuDat = new model.PhieuDat().getPhieuDatByID(request.getParameter("id"));
                try {
                    new model.PhieuDat().updateActive(phieuDat, true);
                    new model.SendEmailUsingGMailSMTP("tranthanhphuong77al@gmail.com", "Phiếu đặt phòng đã được xác nhận thành công");
                    new model.SendEmailUsingGMailSMTP(phieuDat.getKhach().getEmail(), "Phiếu đặt phòng của bạn đã được xác nhận thành công");
                    page = "index.jsp";
                } catch (SQLException ex) {
                    page = "index.jsp";
                    new model.SendEmailUsingGMailSMTP("tranthanhphuong77al@gmail.com", "Phiếu đặt phòng xác nhận không thành công");
                    Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equalsIgnoreCase("delete")) {
                try {
                    new model.PhieuDat().delete(request.getParameter("id"));
                    page = "url?href=admin_khach";
                } catch (SQLException ex) {
                    page = "url?href=admin_khach";
                    Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
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
