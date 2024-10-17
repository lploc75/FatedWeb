/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.WesternFeature2DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.Zodiac;

/**
 *
 * @author locsu
 */
public class WesternFeature2Servlet extends HttpServlet {

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
            out.println("<title>Servlet WesternFeature2Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WesternFeature2Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public int getZodiacIdByDate(int day, int month) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            return 11; // Aquarius
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            return 12; // Pisces
        } else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return 1; // Aries
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            return 2; // Taurus
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            return 3; // Gemini
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            return 4; // Cancer
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            return 5; // Leo
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            return 6; // Virgo
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            return 7; // Libra
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            return 8; // Scorpio
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            return 9; // Sagittarius
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            return 10; // Capricorn
        }
        return -1; // Invalid date
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
        String contentForWesternFeature2 = "<div id=\"horoscope-overview\">\n"
                + "    <h1>An Overview of Astrology: A Comprehensive Guide</h1>\n"
                + "    <h2>What is Astrology?</h2>\n"
                + "    <p>Astrology is a sophisticated system of predicting human destiny based on the philosophy of Eastern traditions, originating from ancient China. By using the exact date, month, year, and hour of birth, astrology creates a detailed chart of an individual's life, thereby decoding various factors that influence their fate.</p>\n"
                + "    <h2>History and Development</h2>\n"
                + "    <p>Astrology boasts a history that spans thousands of years, making it one of the most reputable and precise methods of forecasting the future in Eastern culture. Over the centuries, astrology has been studied, developed, and refined by many famous geomancers and astrologers. Its roots can be traced back to the Han Dynasty (206 BC - 220 AD) when it began to take a more structured form. By the Tang Dynasty (618 - 907 AD), astrology had evolved into a more sophisticated and organized system, incorporating various elements such as stars, planets, and other celestial bodies.</p>\n"
                + "    <h2>Structure of an Astrological Chart</h2>\n"
                + "    <p>An astrological chart, also known as a birth chart or natal chart, is a diagram consisting of 12 houses, each corresponding to different areas of an individual's life. These houses include:</p>\n"
                + "    <ul>\n"
                + "        <li><strong>Self (Mệnh)</strong>: Personal identity, character, destiny.</li>\n"
                + "        <li><strong>Parents (Phụ Mẫu)</strong>: Relationship with parents, familial support.</li>\n"
                + "        <li><strong>Luck and Virtue (Phúc Đức)</strong>: Luck, blessings, and spiritual fortune.</li>\n"
                + "        <li><strong>Property (Điền Trạch)</strong>: Assets, property, real estate.</li>\n"
                + "        <li><strong>Career (Quan Lộc)</strong>: Career, achievements, professional life.</li>\n"
                + "        <li><strong>Friends and Servants (Nô Bộc)</strong>: Friends, social relationships, employees.</li>\n"
                + "        <li><strong>Travel (Thiên Di)</strong>: Travel, relocation, changes in residence.</li>\n"
                + "        <li><strong>Health (Tật Ách)</strong>: Health, illnesses, physical well-being.</li>\n"
                + "        <li><strong>Wealth (Tài Bạch)</strong>: Financial status, income, wealth.</li>\n"
                + "        <li><strong>Children (Tử Tức)</strong>: Children, descendants, progeny.</li>\n"
                + "        <li><strong>Spouse (Phu Thê)</strong>: Marriage, romantic relationships.</li>\n"
                + "        <li><strong>Siblings (Huynh Đệ)</strong>: Siblings, familial relationships.</li>\n"
                + "    </ul>\n"
                + "    <h2>Influential Factors</h2>\n"
                + "    <p>Astrology relies on the interaction between stars (astronomical factors), the five elements (wood, fire, earth, metal, and water), and yin and yang (the dualistic nature of life). These elements influence each other, creating various scenarios in an individual's life.</p>\n"
                + "    <ul>\n"
                + "        <li><strong>Stars (Sao)</strong>: Each star represents a different aspect of life, with some being auspicious and others inauspicious. Notable stars include:\n"
                + "            <ul>\n"
                + "                <li>Tử Vi: The Emperor Star, symbolizing authority and leadership.</li>\n"
                + "                <li>Thái Dương: The Sun, representing clarity and vitality.</li>\n"
                + "                <li>Thái Âm: The Moon, denoting intuition and emotions.</li>\n"
                + "            </ul>\n"
                + "        </li>\n"
                + "        <li><strong>The Five Elements (Ngũ Hành)</strong>: The interaction between the five elements (wood, fire, earth, metal, and water) can either enhance or inhibit one's destiny. These elements play a crucial role in determining compatibility and balance in various life aspects.</li>\n"
                + "        <li><strong>Yin and Yang (Âm Dương)</strong>: The balance between yin (negative, receptive) and yang (positive, active) is fundamental in determining an individual's nature and actions.</li>\n"
                + "    </ul>\n"
                + "    <h2>Applications of Astrology</h2>\n"
                + "    <p>Astrology not only helps us understand ourselves better but also serves as a valuable tool for predicting and preparing for the future. Specific applications include:</p>\n"
                + "    <ul>\n"
                + "        <li>Career Guidance: Aligning career choices with an individual's personality and destiny for optimal success.</li>\n"
                + "        <li>Marriage Counseling: Assessing compatibility between partners to predict marital happiness and stability.</li>\n"
                + "        <li>Investment Decisions: Forecasting financial fortune and identifying favorable times for investments.</li>\n"
                + "        <li>Health Monitoring: Anticipating potential health issues and advising on preventive measures.</li>\n"
                + "        <li>Life Events: Timing significant life events, such as starting a business, relocating, or embarking on new ventures.</li>\n"
                + "    </ul>\n"
                + "    <h2>The Role of the Astrologer</h2>\n"
                + "    <p>As an astrologer with over 20 years of experience, my role is to interpret the complex interplay of these elements within a client's chart. By understanding the unique influences of the stars, elements, and yin-yang balance, I can provide insights and guidance tailored to each individual's life path. This holistic approach enables clients to navigate their lives with greater awareness and make informed decisions that align with their inherent strengths and potential challenges.</p>\n"
                + "    <h2>Conclusion</h2>\n"
                + "    <p>Astrology is a complex and profound system that offers a comprehensive view of human life. Through the precise interpretation of birth charts and the nuanced understanding of celestial influences, astrology helps individuals achieve harmony with the universe and themselves. With two decades of experience in this field, I have witnessed firsthand the transformative power of astrology in guiding people towards a more fulfilling and balanced life. Whether for personal growth, professional development, or relational harmony, astrology remains a timeless and invaluable tool for those seeking deeper insights into their destiny.</p>\n"
                + "</div>\n";
        request.setAttribute("contentForWesternFeature2", contentForWesternFeature2);
        request.getRequestDispatcher("westernFeature2.jsp").forward(request, response);
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
        String day_raw = request.getParameter("day");
        String month_raw = request.getParameter("month");

        int day = Integer.parseInt(day_raw);
        int month = Integer.parseInt(month_raw);

        int zodiac_id = getZodiacIdByDate(day, month);
        WesternFeature2DAO westernDAO = new WesternFeature2DAO();

        if (zodiac_id != -1) {
            try {

                String contentForWesternFeature2 = "";
                Zodiac zodiac = westernDAO.getInforByZodiacId(zodiac_id);
                String elementModeSeason = zodiac.getElement_Mode_Season().replace("\n", "<br>");
                String characteristics = zodiac.getCharacteristics().replace("\n", "<br>");
                String purposeCareer = zodiac.getPurpose_Career().replace("\n", "<br>");
                String health = zodiac.getHealth().replace("\n", "<br>");
                contentForWesternFeature2 = "<div class=\"section\">\n"
                        + "<h2>Compatible Sign</h2>\n"
                        + "<p id=\"tong-quan\">" + zodiac.getCompatible_signs() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Incompatible Sign</h2>\n"
                        + "<p id=\"su-nghiep\">" + zodiac.getIncompatible_signs() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Element, Mode, and Season</h2>\n"
                        + "<p id=\"element-mode-season\">" + elementModeSeason + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Characteristics</h2>\n"
                        + "<p id=\"characteristics\">" + characteristics + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Purpose and Career</h2>\n"
                        + "<p id=\"purpose-career\">" + purposeCareer + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Health</h2>\n"
                        + "<p id=\"health\">" + health + "</p>\n"
                        + "</div>";

                request.setAttribute("contentForWesternFeature2", contentForWesternFeature2);
                request.getRequestDispatcher("westernFeature2.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String contentForWesternFeature2 = "<h2>Invalid day and month</h2>"
                    + "<h2>\n Please try again.</h2>";
            request.setAttribute("contentForWesternFeature2", contentForWesternFeature2);
            request.getRequestDispatcher("westernFeature2.jsp").forward(request, response);
        }
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
