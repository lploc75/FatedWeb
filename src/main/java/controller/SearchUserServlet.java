package controller;

import DAO.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.User;

public class SearchUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        // Fetch user details from the database
        User user = UserDAO.getUserByUsername(username);

        // Check if user exists
        if (user != null) {
            // Set user details as request attributes
            request.setAttribute("user", user);
        } else {
            // Set an error message if user not found
            request.setAttribute("error", "User not found");
        }

        // Forward to the JSP page for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "SearchUserServlet";
    }
}