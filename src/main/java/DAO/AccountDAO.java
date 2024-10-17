package DAO;

import SQLHelper.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 * DAO class for handling Account data.
 *
 * Author: Luu Chi Khanh-CE181175
 */
public class AccountDAO {
    // Insert Account information

    public void insert(Account account) throws SQLException {
        String sql = "INSERT INTO account (id, username, password, email) VALUES (?, ?, ?, ?)";
        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            int newId = getMaxId() + 1;
            stmt.setInt(1, newId);
            stmt.setString(2, account.getUsername());
            stmt.setString(3, account.getPassword());  // password nên ở vị trí thứ 3
            stmt.setString(4, account.getEmail());  // email nên ở vị trí thứ 4

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error inserting account", e);
        }
    }

    public int getMaxId() throws SQLException {
        String sql = "SELECT MAX(Id) AS max_id FROM account";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_id");
            } else {
                return 0; // If there are no records, start with ID 1
            }
        }
    }

    // Get all account information
    public List<Account> getAllInfor() throws SQLException {
        String sql = "SELECT * FROM account";
        List<Account> listInfor = new ArrayList<>();
        try ( Connection conn = Util.getConnection();  PreparedStatement st = conn.prepareStatement(sql);  ResultSet resultSet = st.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                listInfor.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log exception for debugging
        }
        return listInfor;
    }

    // Cập nhật thông tin Account vào database (dùng cho edit-profile)
    public boolean updateAccount(Account account) {
        String sql = "UPDATE account SET email=?, username=?, password=? WHERE id=?";

        try ( Connection conn = Util.getConnection();  PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, account.getEmail());
            statement.setString(2, account.getUsername());
            statement.setString(3, account.getPassword());
            statement.setInt(4, account.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Get account by username
    public Account getAccountByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM account WHERE username = ?";
        try ( Connection conn = Util.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setUsername(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setEmail(rs.getString("email"));
                    return account;
                } else {
                    return null; // No account found with the given username
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching account by username", e);
        }
    }
}
