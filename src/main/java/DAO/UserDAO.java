package DAO;

import SQLHelper.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.User;

/**
 *
 * @author Luu Chi Khanh-CE181175
 */
public class UserDAO {

    public void insert(User user) throws SQLException {
        String sql = "SET IDENTITY_INSERT [user] ON; "
                + "INSERT INTO [user] ([id], [fullname], [gender], [dob]) VALUES (?, ?, ?, ?); "
                + "SET IDENTITY_INSERT [user] OFF;";
        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getFullname());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getDob());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error inserting user", e);
        }
    }

    // Cập nhật thông tin User và liên kết với Account vào database (dùng cho edit-profile)
    public boolean updateUser(User user) {
        String sql = "UPDATE [user] SET fullname=?, gender=?, dob=? WHERE id=?";

        try ( Connection conn = Util.getConnection();  PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getGender());
            statement.setString(3, user.getDob());
            statement.setInt(4, user.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static User getUserByUsername(String username) {
        User user = null;
        try {
            Connection conn = Util.getConnection();
            String query = "SELECT u.*, a.username, a.email, m.price, m.period, r.type AS rankType "
                    + "FROM [user] u "
                    + "JOIN account a ON u.id = a.id "
                    + "JOIN rank r ON u.id = r.id "
                    + "JOIN membership m ON r.type = m.type "
                    + "WHERE a.username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setEmail(rs.getString("email"));

                user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setGender(rs.getString("gender"));
                user.setDob(rs.getString("dob"));
                user.setAccount(account);
                user.setPrice(rs.getDouble("price"));
                user.setPeriod(rs.getString("period"));
                user.setRanktype(rs.getString("rankType"));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean deleteUserById(int userId) throws SQLException {
        String deleteRankSQL = "DELETE FROM [rank] WHERE id = ?";
        String deleteUserSQL = "DELETE FROM [user] WHERE id = ?";
        String deleteAccountSQL = "DELETE FROM [account] WHERE id = ?";

        try ( Connection conn = Util.getConnection()) {
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            try ( PreparedStatement deleteRankStmt = conn.prepareStatement(deleteRankSQL);  PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSQL);  PreparedStatement deleteAccountStmt = conn.prepareStatement(deleteAccountSQL)) {

                // Xóa từ bảng rank
                deleteRankStmt.setInt(1, userId);
                deleteRankStmt.executeUpdate();

                // Xóa từ bảng user
                deleteUserStmt.setInt(1, userId);
                deleteUserStmt.executeUpdate();

                // Xóa từ bảng account
                deleteAccountStmt.setInt(1, userId);
                deleteAccountStmt.executeUpdate();

                conn.commit(); // Xác nhận giao dịch
                return true;
            } catch (SQLException e) {
                conn.rollback(); // Hoàn tác nếu có lỗi
                throw new SQLException("Error deleting user with ID: " + userId, e);
            }
        }
    }

    public boolean downgradeMembership(int userId) throws SQLException {
        String sql = "UPDATE [rank] SET type = 'Member' WHERE id = ?";

        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new SQLException("Error downgrading membership for user with ID: " + userId, e);
        }
    }

    public boolean upgradeMembership(int userId) throws SQLException {
        String sql = "UPDATE [rank] SET type = 'Vip' WHERE id = ?";

        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new SQLException("Error downgrading membership for user with ID: " + userId, e);
        }
    }

}
