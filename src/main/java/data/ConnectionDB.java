
package data;

import java.sql.*;

public class ConnectionDB {
    
    private static final String JDBC_STRING = "jdbc:mysql://localhost:3306/test?useSSL=false&userTimezone=true&serverTimezone=GMT&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_STRING, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close(); 
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
