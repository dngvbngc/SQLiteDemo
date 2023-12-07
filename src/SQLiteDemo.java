import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;  

public class SQLiteDemo {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Success!");

            String url = "jdbc:sqlite:/Users/ngocdang/Desktop/SQLiteDemo/hello.db";
            String name = "Ari";

            Connection connection = DriverManager.getConnection(url);
            String sql = "INSERT INTO MyTable (name) VALUES (?)";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Values inserted successfully.");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}