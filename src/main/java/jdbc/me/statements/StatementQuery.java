package jdbc.me.statements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static jdbc.me.statements.BaseConn.closeConnection;
import static jdbc.me.statements.BaseConn.writeStatement;

public class StatementQuery {
    public static void main(String[] args) {
        try (Statement statement = writeStatement()) {
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
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }
}
