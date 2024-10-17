package controller;

import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import model.User;

public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);

        boolean isDeleted = false;
        String message = "Failed to delete user.";
        
        if (user != null) {
            try {
                isDeleted = userDAO.deleteUserById(user.getId());
                if (isDeleted) {
                    message = "User deleted successfully.";
                }
            } catch (SQLException e) {
                message = "Error deleting user: " + e.getMessage();
            }
        } else {
            message = "User not found.";
        }

        request.setAttribute("msg", message);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
