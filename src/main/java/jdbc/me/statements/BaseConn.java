package jdbc.me.statements;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseConn {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);
    private static Connection CONNECTION;

    private static void establishConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        if (CONNECTION == null) {
            CONNECTION = mysqlDataSource.getConnection();
        }
    }

    public static Statement writeStatement() throws SQLException {
        try {
            establishConnection();
            return CONNECTION.createStatement();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void closeConnection() {
        try {
            CONNECTION.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
