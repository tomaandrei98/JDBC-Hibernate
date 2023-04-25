package jdbc.me.connections;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDataSourceConnection {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);

    public static void main(String[] args) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        try (Connection connection = mysqlDataSource.getConnection()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
