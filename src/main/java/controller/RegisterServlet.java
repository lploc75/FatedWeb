/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AccountDAO;
import DAO.RankDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Rank;
import model.User;

/**
 *
 * @author Luu Chi Khanh-CE181175
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");

        // Create Account object
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);

        // Insert account into database
        AccountDAO accountDAO = new AccountDAO();
        UserDAO userDAO = new UserDAO();
        RankDAO rankDAO = new RankDAO();
        try {
            // Insert account into database and get the inserted ID
            accountDAO.insert(account);

            int accountId = accountDAO.getMaxId(); // Assuming getMaxId() returns the latest ID
            // Create User object
            User user = new User();
            user.setId(accountId); // Set the user ID to match the account ID
            user.setFullname(username);
            user.setGender("Other"); // Set a valid gender value
            user.setDob(dob);

            // Insert user into database
            userDAO.insert(user);

            // sau khi tạo user và account thì tạo tiếp rank của user/account
            Rank u_rank = new Rank();
            u_rank.setId(accountId);
            u_rank.setType("Member");
            rankDAO.insert(u_rank);

            request.setAttribute("msg", "Registered suscessfully");
            request.getRequestDispatcher("login.jsp").forward(request, response); // Redirect to login page after successful registration
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("msg", "register error");
            request.getRequestDispatcher("register.jsp").forward(request, response); // Redirect back to register page on failure
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
