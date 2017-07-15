/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanhphuong
 */
@WebServlet(name = "export", urlPatterns = {"/export"})
public class export extends HttpServlet {

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
            out.print("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta charset=\"utf-8\">\n"
                    + "<style>\n"
                    + "table {\n"
                    + "    font-family: arial, sans-serif;\n"
                    + "    border-collapse: collapse;\n"
                    + "    width: 100%;\n"
                    + "}\n"
                    + "\n"
                    + "td, th {\n"
                    + "    border: 1px solid #dddddd;\n"
                    + "    text-align: left;\n"
                    + "    padding: 8px;\n"
                    + "}\n"
                    + "\n"
                    + "tr:nth-child(even) {\n"
                    + "    background-color: #dddddd;\n"
                    + "}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Quản lý đặt phòng online - khách sạn FairyBay</h1>\n"
                    + "<h2>Thông kê doanh thu theo tuần</h2>\n"
                    + "<table>\n"
                    + "  <tr>\n"
                    + "    <th>Tên phòng</th>\n"
                    + "    <th>Loại phòng</th>\n"
                    + "    <th>Tổng doanh thu</th>\n"
                    + "  </tr>");
            List<entities.ThongKe> list = new model.ThongKe().getThongKe();
            for (entities.ThongKe t : list) {
                out.print("  <tr>\n"
                        + "    <td>" + t.getRoom().getNameP() + "</td>\n"
                        + "    <td>" + t.getRoom().getType() + "</td>\n"
                        + "    <td>" + t.getTongtien() + " vnđ</td>\n"
                        + "  </tr>");
            }

            out.print("</table>\n"
                    + "</body>\n"
                    + "</html>");
            String exportToExcel = request.getParameter("exportToExcel");
            if (exportToExcel != null
                    && exportToExcel.toString().equalsIgnoreCase("YES")) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename="
                        + "excel.xls");

            }
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
