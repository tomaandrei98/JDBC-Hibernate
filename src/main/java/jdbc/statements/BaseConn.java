package jdbc.statements;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseConn {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static Connection conn;

    private static MysqlDataSource establishConnection() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", DATABASE));
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        return mysqlDataSource;
    }

    public static Statement writeStatement() throws SQLException {
        try {
            conn = establishConnection().getConnection();
            return conn.createStatement();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
