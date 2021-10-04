import java.sql.*;
public class Example {
    static final String DB_URL = "jdbc:mysql://localhost/my_database";
    static final String USER = "tom";
    static final String PASS = "its a **** secret";
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, first, last, age FROM Employees");
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
            stmt.close(); }}}
