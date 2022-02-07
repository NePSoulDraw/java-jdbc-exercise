package data;

import static data.ConnectionDB.*;
import domain.User;
import java.sql.*;
import java.util.*;

public class UserDAO {

    private static final String SQL_SELECT = "SELECT idUser, username, password FROM test.user";
    private static final String SQL_INSERT = "INSERT INTO test.user(username, password) VALUES( ?, ? )";
    private static final String SQL_UPDATE = "UPDATE test.user SET username = ?, password = ? WHERE idUser = ?";
    private static final String SQL_DELETE = "DELETE FROM test.user WHERE idUser = ?";

    public List<User> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String username = rs.getString("username");
                String password = rs.getString("password");

                user = new User(username, password);

                users.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(rs);
                ConnectionDB.close(stmt);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return users;

    }

    public int insert(User user) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            records = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(stmt);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return records;

    }
    
    public int update(User user){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getIdUser());

            records = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(stmt);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return records;
        
        
    }
    
    public int delete(User user){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getIdUser());

            records = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(stmt);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return records;
        
    }

}
