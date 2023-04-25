package jdbc.me.connections;

import java.sql.*;

public class DriverManagerConnection {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                    SELECT *
                    FROM country
                    """);

            int id;
            String code = "";
            String name = "";

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                code = resultSet.getString("code");
                name = resultSet.getString("name");
                System.out.printf("id: %s, code: %s, name: %s%n", id, code, name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
