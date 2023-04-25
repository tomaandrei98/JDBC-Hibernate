package jdbc.task2.service.base;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/* Config class for connection */

public abstract class BaseMovie {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static Connection conn;

    protected static Connection establishConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", DATABASE));
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        return mysqlDataSource.getConnection();
    }

    protected static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
