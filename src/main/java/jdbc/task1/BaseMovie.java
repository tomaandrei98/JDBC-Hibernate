package jdbc.task1;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseMovie {
    private static final String DATABASE = "sda-ecommerce";
    private static final String USERNAME = "sdauserapp";
    private static final String PASSWORD = "sdauserapp";
    private static Connection conn;

    private static Connection establishConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", DATABASE));
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);

        return mysqlDataSource.getConnection();
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTableIfExists(String tableName) {
        String dropTableQuery = String.format("DROP TABLE IF EXISTS %s", tableName);

        try (Connection conn = establishConnection();
             PreparedStatement dropTableStmt = conn.prepareStatement(dropTableQuery)) {

            dropTableStmt.executeUpdate();
            System.out.println("Table was dropped successfully");
        } catch (SQLException e) {
            System.out.println("Table was not dropped successfully due to: " + e.getMessage());
        }
    }

    public static void createTable(String tableName) {
        String createTableQuery = String.format(
                "CREATE TABLE %s (" +
                "id INTEGER AUTO_INCREMENT, " +
                "title VARCHAR(255), " +
                "genre VARCHAR(255), " +
                "year_of_release INTEGER, " +
                "PRIMARY KEY(id)" +
                ")", tableName);

        try (Connection conn = establishConnection();
             PreparedStatement createTableStmt = conn.prepareStatement(createTableQuery)) {

            createTableStmt.executeUpdate();
            System.out.println("Table was created successfully");
        } catch (SQLException e) {
            System.out.println("Table was not created successfully due to: " + e.getMessage());
        }
    }

    public static void insert(String tableName, String title, String genre, int yearOfRelease) {
        String insertQuery = String.format(
                """
                INSERT INTO %s
                (title, genre, year_of_release)
                VALUES
                ('%s', '%s', %s)
                """, tableName, title, genre, yearOfRelease);

        try (Connection conn = establishConnection();
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {

            insertStmt.executeUpdate();
            System.out.println("Value was inserted successfully");
        } catch (SQLException e) {
            System.out.println("Value was not inserted successfully due to: " + e.getMessage());
        }
    }

    public static void updateTitleById(String tableName, String updatedValue, int id) {
        String updateTitleByIdQuery = String.format("UPDATE %s SET title = ? WHERE id = ?", tableName);

        try (Connection conn = establishConnection();
             PreparedStatement updateTitleByIdStmt = conn.prepareStatement(updateTitleByIdQuery)) {

            updateTitleByIdStmt.setString(1, updatedValue);
            updateTitleByIdStmt.setInt(2, id);
            updateTitleByIdStmt.executeUpdate();
            System.out.println("Value was updated successfully");
        } catch (SQLException e) {
            System.out.println("Value was not updated successfully due to: " + e.getMessage());
        }
    }

    public static void deleteById(String tableName, int id) {
        String deleteByIdQuery = String.format("DELETE FROM %s WHERE id = ?", tableName);

        try (Connection conn = establishConnection();
             PreparedStatement deleteByIdStmt = conn.prepareStatement(deleteByIdQuery)) {

            deleteByIdStmt.setInt(1, id);
            deleteByIdStmt.executeUpdate();
            System.out.println("Value was deleted successfully");
        } catch (SQLException e) {
            System.out.println("Value was not deleted successfully due to: " + e.getMessage());
        }
    }

    public static void findAll(String tableName) {
        String findAllQuery = String.format("SELECT * FROM %s", tableName);

        try (Connection conn = establishConnection();
             PreparedStatement findAllStmt = conn.prepareStatement(findAllQuery)) {

            ResultSet rs = findAllStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int yearOfRelease = rs.getInt("year_of_release");

                System.out.printf("Value #%s has title = %s of genre = %s and it was released in %s%n",
                        id, title, genre, yearOfRelease);
            }
        } catch (SQLException e) {
            System.out.println("Values was not selected successfully due to: " + e.getMessage());
        }
    }


}
