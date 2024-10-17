/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EasternHoroscope;

/**
 *
 * @author locsu
 */
public class EasternHoroscopeDAO {

    public EasternHoroscope getInforByYear(int birthYear) throws SQLException {
        Connection conn = null;
        EasternHoroscope easternInfo = new EasternHoroscope();
        try {
            conn = SQLHelper.Util.getConnection();
            ResultSet rs = SQLHelper.Util.executeQuery("SELECT * FROM [easternHoroscope] WHERE year = ?", birthYear);
            if (rs.next()) {
                easternInfo.setYear(rs.getInt("year"));
                easternInfo.setOverview(rs.getString("overview"));
                easternInfo.setCareer(rs.getString("career"));
                easternInfo.setLove(rs.getString("love"));
                easternInfo.setHealth(rs.getString("health"));
                easternInfo.setFortune(rs.getString("fortune"));
                easternInfo.setFamily(rs.getString("family"));
                easternInfo.setImportantYears(rs.getString("importantYears"));
                easternInfo.setAdvice(rs.getString("advice"));
                easternInfo.setType_id(rs.getInt("type_id"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (conn != null) {
                SQLHelper.Util.closeConnection(conn);
            }
        }
        return easternInfo;
    }
}
