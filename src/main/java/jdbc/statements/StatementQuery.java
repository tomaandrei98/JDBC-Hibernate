package jdbc.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementQuery extends BaseConn {
    public static void main(String[] args) throws SQLException {
        Statement stmt = writeStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM product LIMIT 5");
        ResultSet rs = stmt.executeQuery("""
                SELECT *
                FROM product
                LIMIT 5
                """);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.printf("id = %s, name = %s%n", id, name);
        }

        closeConnection();
    }
}
