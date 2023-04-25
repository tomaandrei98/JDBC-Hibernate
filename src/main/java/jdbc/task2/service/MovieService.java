package jdbc.task2.service;

import jdbc.task2.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

/* Business logic contract for app functionalities */

public interface MovieService {
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
