/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.LunarCalendarConverter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import model.User;

/**
 *
 * @author locsu
 */
public class EasternFeature1Servlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EasternFeature1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EasternFeature1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.sendRedirect("easternFeature1.jsp");
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
        LunarCalendarConverter converter = new LunarCalendarConverter();
        String userChoice = request.getParameter("userChoice");
        String result = "";
        // Xử lý khi người dùng chọn "For Yourself"
        if ("self".equals(userChoice)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user"); // lay ngay sinh user
            String dob = user.getDob();
            // chia ngày tháng năm
            LocalDate birthdate = LocalDate.parse(dob);
            int day = birthdate.getDayOfMonth();
            int month = birthdate.getMonthValue();
            int year = birthdate.getYear();
            result = converter.LunarCalendarConverter(day, month, year);

            // Xử lý khi người dùng chọn "For Someone Else"
        } else if ("someoneElse".equals(userChoice)) {
            String birthdateStr = request.getParameter("dob");
            String fullName = request.getParameter("fullName");
            String gender = request.getParameter("gender");
            // chia ngày tháng năm
            LocalDate birthdate = LocalDate.parse(birthdateStr);
            int day = birthdate.getDayOfMonth();
            int month = birthdate.getMonthValue();
            int year = birthdate.getYear();
            result = converter.LunarCalendarConverter(day, month, year);
        }

        // Đặt kết quả vào request attribute và chuyển tiếp đến trang JSP để hiển thị
        request.setAttribute("result", result);
        
        request.setAttribute("weakElement", converter.getWeakElement());
        
        request.getRequestDispatcher("easternFeature1.jsp").forward(request, response);
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
