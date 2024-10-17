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
import model.Account;
import model.User;

/**
 *
 * @author Luu Chi Khanh-CE181175
 */
public class Login {

    public static Account Validate(String username, String password){
        Account account = new Account();
        Connection conn = null;
        try {
            conn = SQLHelper.Util.getConnection();
            ResultSet rs = SQLHelper.Util.executeQuery("Select * from account where username=? and password=?", username, password);
            if (rs.next()) {
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
            } else {
                account = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            SQLHelper.Util.closeConnection(conn);
        }
        return account;
    }

    public static User getUserById(int id) throws SQLException {
        Connection conn = null;
        User user = new User();
        try {
            conn = SQLHelper.Util.getConnection();
            ResultSet rs = SQLHelper.Util.executeQuery("SELECT * FROM [user] WHERE id = ?", id);
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setGender(rs.getString("gender"));
                user.setDob(rs.getString("dob"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (conn != null) {
                SQLHelper.Util.closeConnection(conn);
            }
        }
        return user;
    }
}
