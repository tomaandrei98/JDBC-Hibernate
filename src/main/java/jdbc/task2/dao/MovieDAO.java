package jdbc.task2.dao;

import jdbc.task2.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

/* Represents the contract of DAOImpl -> we're defining all queries that we can make on database */

public interface MovieDAO {
    void dropTableIfExists();

    void createTable();

    void insert(MovieEntity movieEntity);

    void updateTitleById(int id, String title);

    void deleteById(int id);

    Optional<MovieEntity> findById(int id);

    List<MovieEntity> findAll();

    List<MovieEntity> findMoviesReleasedAfterYearOf(int year);

    List<MovieEntity> findMoviesWhereGenreIs(String genre);
}
