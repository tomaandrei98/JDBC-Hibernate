package jdbc.connections;

import java.sql.*;

public class DriverManagerConnection {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         * load the MySQL JDBC driver
         * before establishing a connection to the MySQL Local Database Server
         * */
        Class.forName("com.mysql.cj.jdbc.Driver");

        // establish connection to database by using credentials
        String url = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);
        Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);

        // statement creation, query execution
        Statement stmt = conn.createStatement();

        // deserialization -> an entity is mapped to another entity
        // mapping -> matching the resources between the attributes of the same data type
        ResultSet rs = stmt.executeQuery("""
                SELECT *
                FROM product
                """);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.printf("id = %s, name = %s%n", id, name);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}