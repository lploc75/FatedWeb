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
import model.Rank;

/**
 *
 * @author locsu
 */
public class RankDAO {

    public void insert(Rank u_rank) throws SQLException {
        String sql = "INSERT INTO rank (id, type) VALUES (?, ?)";
        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, u_rank.getId());
            stmt.setString(2, u_rank.getType());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error inserting account", e);
        }
    }

    // Cập nhật thông tin Rank vào database 
    public boolean updateRank(Rank u_rank) throws SQLException {
        String sql = "UPDATE rank SET type=? WHERE id=?";

        try ( Connection conn = Util.getConnection();  PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, u_rank.getType());
            statement.setInt(2, u_rank.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Get all account information
    public Rank getUserRankType(Rank rank) throws SQLException {
        String sql = "SELECT * FROM rank where id =?";
                try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rank.getId());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Rank r = new Rank();
                    r.setId(rs.getInt("id"));
                    r.setType(rs.getString("type"));
                    return r;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching rank by id", e);
        }
    }
}
