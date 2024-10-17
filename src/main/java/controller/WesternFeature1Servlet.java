package controller;

import DAO.WesternFeature1DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TarotReader;

public class WesternFeature1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xóa các thuộc tính khỏi phiên sau khi xử lý
        request.setAttribute("card-description", null);
        request.setAttribute("card-url", null);
        request.getRequestDispatcher("westernFeature1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardDescription = "";
        String cardURL = "";
        String question = request.getParameter("question");

        if (question != null) {
            Random random = new Random();
            int min = 1;
            int max = 22;
            int randomNumber = random.nextInt((max - min) + 1) + min;

            TarotReader card = new TarotReader();
            WesternFeature1DAO westernDao = new WesternFeature1DAO();
            card.setCard_id(randomNumber);
            try {
                switch (question) {
                    case "wish":
                        card = westernDao.getWishDesByCardId(card);
                        cardDescription = card.getWish_des();
                        cardURL = card.getCard_url();
                        break;
                    case "love":
                        card = westernDao.getLoveDesByCardId(card);
                        cardDescription = card.getLove_des();
                        cardURL = card.getCard_url();
                        break;
                    case "career":
                        card = westernDao.getCareerDesByCardId(card);
                        cardDescription = card.getCareer_des();
                        cardURL = card.getCard_url();
                        break;
                    case "study":
                        card = westernDao.getStudyDesByCardId(card);
                        cardDescription = card.getStudy_des();
                        cardURL = card.getCard_url();
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(WesternFeature1Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getSession().setAttribute("card-description", cardDescription);
            request.getSession().setAttribute("card-url", cardURL);
        }

        // Chuyển hướng đến phương thức GET
        response.sendRedirect("westernfeature1");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
