/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import SQLHelper.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TarotReader;

/**
 *
 * @author locsu
 */
public class WesternFeature1DAO {
      // Get account by username
    public TarotReader getWishDesByCardId(TarotReader card) throws SQLException {
        String sql = "SELECT card_url, wish_des FROM tarotReader WHERE card_id = ?";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, card.getCard_id());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TarotReader cardpicked = new TarotReader();
                    cardpicked.setWish_des(rs.getString("wish_des"));
                    cardpicked.setCard_url(rs.getString("card_url"));
                    return cardpicked;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching account by username", e);
        }
    }
      // Get account by username
    public TarotReader getLoveDesByCardId(TarotReader card) throws SQLException {
        String sql = "SELECT card_url, love_des FROM tarotReader WHERE card_id = ?";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, card.getCard_id());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TarotReader cardpicked = new TarotReader();
                    cardpicked.setLove_des(rs.getString("love_des"));
                    cardpicked.setCard_url(rs.getString("card_url"));
                    return cardpicked;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching account by username", e);
        }
    }
    
      // Get account by username
    public TarotReader getCareerDesByCardId(TarotReader card) throws SQLException {
        String sql = "SELECT card_url, career_des FROM tarotReader WHERE card_id = ?";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, card.getCard_id());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TarotReader cardpicked = new TarotReader();
                    cardpicked.setCareer_des(rs.getString("career_des"));
                    cardpicked.setCard_url(rs.getString("card_url"));
                    return cardpicked;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching account by username", e);
        }
    }
    
      // Get account by username
    public TarotReader getStudyDesByCardId(TarotReader card) throws SQLException {
        String sql = "SELECT card_url, study_des FROM tarotReader WHERE card_id = ?";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, card.getCard_id());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TarotReader cardpicked = new TarotReader();
                    cardpicked.setStudy_des(rs.getString("study_des"));
                    cardpicked.setCard_url(rs.getString("card_url"));
                    return cardpicked;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching account by username", e);
        }
    }
}
