package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class koneksi {
    public Connection connection = null;
    public Statement statement;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public final Connection openConnection() {
        try {
            String url = "jdbc:mysql://localhost/xxy_bioskop?user=root&password=";
            this.connection = DriverManager.getConnection(url);
            System.out.println("Database successfully connected");
            return connection; 
        } catch (SQLException ex) {
            displayErrors(ex);
            return null; 
        }
    }
    
    public final void closeConnection(){
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            displayErrors(ex);
        }
    }
    public static void displayErrors(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    
    public void update(String qq) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(qq);
}
}