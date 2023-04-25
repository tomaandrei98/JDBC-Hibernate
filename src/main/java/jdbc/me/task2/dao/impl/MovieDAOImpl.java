package jdbc.me.task2.dao.impl;

import jdbc.task2.entity.MovieEntity;
import jdbc.me.task2.dao.MovieDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl implements MovieDAO {
    public final String TABLE_NAME;
    public final Connection conn;

    public MovieDAOImpl(String tableName, Connection conn) {
        this.TABLE_NAME = tableName;
        this.conn = conn;
    }

    @Override
    public void dropTableIfExists() {
        String dropTableQuery = String.format("""
                DROP TABLE IF EXISTS %s
                """, TABLE_NAME);

        try (PreparedStatement dropTableStmt = conn.prepareStatement(dropTableQuery)) {
            dropTableStmt.executeUpdate();
            System.out.println("Table was dropped successfully");
        } catch (SQLException e) {
            System.out.println("Table was not dropped successfully due to: " + e.getMessage());
        }
    }

    @Override
    public void createTable() {
        String createTableQuery = String.format("""
                CREATE TABLE %s
                (id INT AUTO_INCREMENT,
                title VARCHAR(255),
                genre VARCHAR(255),
                year_of_release INT,
                PRIMARY KEY(id)
                )
                """, TABLE_NAME);

        try (PreparedStatement createTableStmt = conn.prepareStatement(createTableQuery)) {
            createTableStmt.executeUpdate();
            System.out.println("Table was created successfully");
        } catch (SQLException e) {
            System.out.println("Table was not created successfully due to: " + e.getMessage());
        }
    }

    @Override
    public void insert(MovieEntity movieEntity) {
        String insertQuery = String.format("""
                        INSERT INTO %s
                        (title, genre, year_of_release)
                        VALUES
                        ('%s', '%s', %s)
                        """, TABLE_NAME,
                movieEntity.getTitle(),
                movieEntity.getGenre(),
                movieEntity.getYearOfRelease());

        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.executeUpdate();
            System.out.println("Value was inserted successfully");
        } catch (SQLException e) {
            System.out.println("Value was not inserted successfully due to: " + e.getMessage());
        }
    }

    @Override
    public void updateTitleById(int id, String title) {
        String updateQuery = String.format("""
                UPDATE %s
                SET title = ?
                WHERE id = ?
                """, TABLE_NAME);
        try (PreparedStatement updateTitleByIdStmt = conn.prepareStatement(updateQuery)) {
            updateTitleByIdStmt.setString(1, title);
            updateTitleByIdStmt.setInt(2, id);
            updateTitleByIdStmt.executeUpdate();
            System.out.println("Value was updated successfully");
        } catch (SQLException e) {
            System.out.println("Value was not updated successfully due to: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        String deleteByIdQuery = String.format("""
                DELETE FROM %s
                WHERE id = ?
                """, TABLE_NAME);

        try (PreparedStatement deleteByIdStmt = conn.prepareStatement(deleteByIdQuery)) {
            deleteByIdStmt.setInt(1, id);
            deleteByIdStmt.executeUpdate();
            System.out.println("Value was deleted successfully");
        } catch (SQLException e) {
            System.out.println("Value was not deleted successfully due to: " + e.getMessage());
        }
    }

    @Override
    public Optional<MovieEntity> findById(int id) {
        String findByIdQuery = String.format("""
                SELECT *
                FROM %s
                WHERE id = ?
                """, TABLE_NAME);

        MovieEntity tempMovieEntity = new MovieEntity();
        try (PreparedStatement findByIdStmt = conn.prepareStatement(findByIdQuery)) {
            findByIdStmt.setInt(1, id);

            ResultSet resultSet = findByIdStmt.executeQuery();

            if (resultSet.next()) {
                tempMovieEntity = mapToMovieEntityFrom(resultSet);
            }

            System.out.println("Value was downloaded successfully");
        } catch (SQLException e) {
            System.out.println("Value was not downloaded successfully due to: " + e.getMessage());
        }

        return getAppropriateOptionalFor(tempMovieEntity);
    }

    private MovieEntity mapToMovieEntityFrom(ResultSet resultSet) throws SQLException {
        MovieEntity tempMovieEntity = new MovieEntity();

        tempMovieEntity.setId(resultSet.getInt("id"));
        tempMovieEntity.setTitle(resultSet.getString("title"));
        tempMovieEntity.setGenre(resultSet.getString("genre"));
        tempMovieEntity.setYearOfRelease(resultSet.getInt("year_of_release"));

        return tempMovieEntity;
    }

    private Optional<MovieEntity> getAppropriateOptionalFor(MovieEntity tempMovieEntity) {
        return tempMovieEntity.getId() != -1 ? Optional.of(tempMovieEntity) : Optional.empty();
    }

    @Override
    public List<MovieEntity> findAll() {
        String findAllQuery = String.format("""
                SELECT *
                FROM %s
                """, TABLE_NAME);

        List<MovieEntity> result = new ArrayList<>();
        MovieEntity tempMovieEntity;

        try (Statement findAllStmt = conn.createStatement()) {
            ResultSet resultSet = findAllStmt.executeQuery(findAllQuery);
            while (resultSet.next()) {
                tempMovieEntity = mapToMovieEntityFrom(resultSet);
                result.add(tempMovieEntity);
            }
            System.out.println("Movies was downloaded successfully");
        } catch (SQLException e) {
            System.out.println("Movies was not downloaded successfully due to: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<MovieEntity> findMoviesReleasedAfterYearOf(int year) {
        String findMoviesReleasedAfterYearQuery = String.format("""
                SELECT *
                FROM %s
                WHERE year_of_release >= ?;
                """, TABLE_NAME);

        List<MovieEntity> result = new ArrayList<>();
        MovieEntity tempMovieEntity;

        try (PreparedStatement findMoviesReleasedAfterYearStmt
                     = conn.prepareStatement(findMoviesReleasedAfterYearQuery)) {
            findMoviesReleasedAfterYearStmt.setInt(1, year);

            ResultSet resultSet = findMoviesReleasedAfterYearStmt.executeQuery();
            while (resultSet.next()) {
                tempMovieEntity = mapToMovieEntityFrom(resultSet);
                result.add(tempMovieEntity);
            }
            System.out.println("Movies was downloaded successfully");
        } catch (SQLException e) {
            System.out.println("Movies was not downloaded successfully due to: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<MovieEntity> findMoviesWhereGenreIs(String genre) {
        String findMoviesWithGenreOfQuery = String.format("""
                SELECT *
                FROM %s
                WHERE genre = ?
                """, TABLE_NAME);

        List<MovieEntity> result = new ArrayList<>();

        try (PreparedStatement findMoviesWithGenreOfStmt =
                     conn.prepareStatement(findMoviesWithGenreOfQuery)) {
            findMoviesWithGenreOfStmt.setString(1, genre);
            ResultSet resultSet = findMoviesWithGenreOfStmt.executeQuery();

            while (resultSet.next()) {
                result.add(mapToMovieEntityFrom(resultSet));
            }

            System.out.println("Movies was downloaded successfully");
        } catch (SQLException e) {
            System.out.println("Movies was not downloaded successfully due to: " + e.getMessage());
        }

        return result;
    }
}
