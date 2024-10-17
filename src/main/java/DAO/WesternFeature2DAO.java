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
import model.Zodiac;

/**
 *
 * @author locsu
 */
public class WesternFeature2DAO {

    public Zodiac getInforByZodiacId(int zodiac_id) throws SQLException {
        Connection conn = null;
        Zodiac westernInfo = new Zodiac();
        try {
            conn = SQLHelper.Util.getConnection();
            ResultSet rs = SQLHelper.Util.executeQuery("SELECT * FROM [zodiac] WHERE zodiac_id = ?", zodiac_id);
            if (rs.next()) {
                westernInfo.setType_id(rs.getInt("type_id"));
                westernInfo.setZodiac_id(rs.getInt("zodiac_id"));
                westernInfo.setCompatible_signs(rs.getString("compatible_signs"));
                westernInfo.setIncompatible_signs(rs.getString("incompatible_signs"));
                westernInfo.setElement_Mode_Season(rs.getString("Element, Mode, and Season"));
                westernInfo.setCharacteristics(rs.getString("Characteristics"));
                westernInfo.setPurpose_Career(rs.getString("Purpose and Career"));
                westernInfo.setHealth(rs.getString("Health"));          
            }
        } catch (SQLException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (conn != null) {
                SQLHelper.Util.closeConnection(conn);
            }
        }
        return westernInfo;
    }
}
