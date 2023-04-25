package jdbc.connections;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDataSourceConnection {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         * load the MySQL JDBC driver
         * before establishing a connection to the MySQL Local Database Server
         * */
        // establish connection to database by using credentials
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", DATABASE));
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        Connection conn = mysqlDataSource.getConnection();

        // statement creation, query execution
        Statement stmt = conn.createStatement();

        // deserialization -> an entity is mapped to another entity
        // mapping -> matching the resources between the attributes of the same data type
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");

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
