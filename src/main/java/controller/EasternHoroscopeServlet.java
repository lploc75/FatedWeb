/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.EasternHoroscopeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.EasternHoroscope;

/**
 *
 * @author locsu
 */
public class EasternHoroscopeServlet extends HttpServlet {

    // Hàm xác định con giáp của một năm
    private static final String[] ZODIACSSIGN = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};
    private static final int[] ZODIACSNUMBER = {1924, 1925, 1926, 1927, 1928, 1929, 1930, 1931, 1920, 1921, 1922, 1923};

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
            out.println("<title>Servlet HoroscopeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HoroscopeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static int getZodiac(int year) {
        int baseYear = 1924; // Năm Tý
        // Lấy năm muốn tìm trừ năm tý đã đặt là 1924
        // để tìm con giáp của năm muốn tìm so với năm 1924
        //mod 12 là lặp lại trong 12 năm
        int index = (year - baseYear) % 12;
        if (index < 0) {
            index += 12; // Đảm bảo index không âm
        }
        return ZODIACSNUMBER[index];
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
        String astrologyContent = "<div id=\"horoscope-overview\">\n"
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
        request.setAttribute("astrologyContent", astrologyContent);
        request.getRequestDispatcher("easternHoroscope.jsp").forward(request, response);
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
        String birthYear_raw = request.getParameter("birth-year");
        int birthYear = Integer.parseInt(birthYear_raw);

        int zodiacNumber = getZodiac(birthYear);

        EasternHoroscopeDAO easternDAO = new EasternHoroscopeDAO();
        EasternHoroscope easternInfo = new EasternHoroscope();
        if (birthYear >= 1800 && birthYear <= 2200) {
            try {
                String astrologyContent = "";
                easternInfo = easternDAO.getInforByYear(zodiacNumber);

                astrologyContent
                        = "<div class=\"section\">\n"
                        + "<h2>Overview</h2>\n"
                        + "<p id=\"tong-quan\">" + easternInfo.getOverview() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Career</h2>\n"
                        + "<p id=\"su-nghiep\">" + easternInfo.getCareer() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Love</h2>\n"
                        + "<p id=\"tinh-duyen\">" + easternInfo.getLove() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Health</h2>\n"
                        + "<p id=\"suc-khoe\">" + easternInfo.getHealth() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Fortune</h2>\n"
                        + "<p id=\"tai-loc\">" + easternInfo.getFortune() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Family</h2>\n"
                        + "<p id=\"gia-dao\">" + easternInfo.getFamily() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Important Years</h2>\n"
                        + "<p id=\"nam-thang-quan-trong\">" + easternInfo.getImportantYears() + "</p>\n"
                        + "</div>\n"
                        + "<div class=\"section\">\n"
                        + "<h2>Advice</h2>\n"
                        + "<p id=\"loi-khuyen\">" + easternInfo.getAdvice() + "</p>\n"
                        + "</div>";

                request.setAttribute("astrologyContent", astrologyContent);
                request.getRequestDispatcher("easternHoroscope.jsp").forward(request, response);
            } catch (SQLException ex) {

            }
        } else {
            String astrologyContent = "<h2>Sorry your birthday year are not support!</h2>"
                    + "<h2>\n We will update soon.</h2>";
            request.setAttribute("astrologyContent", astrologyContent);
            request.getRequestDispatcher("easternHoroscope.jsp").forward(request, response);
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
