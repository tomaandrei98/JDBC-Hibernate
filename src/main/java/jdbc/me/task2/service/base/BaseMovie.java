package jdbc.me.task2.service.base;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseMovie {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);

    protected static Connection establishConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        return mysqlDataSource.getConnection();
    }
}
