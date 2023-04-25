package jdbc.me.task2.service.impl;

import jdbc.me.task2.dao.impl.MovieDAOImpl;
import jdbc.task2.entity.MovieEntity;
import jdbc.me.task2.dao.MovieDAO;
import jdbc.me.task2.service.MovieService;
import jdbc.me.task2.service.base.BaseMovie;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl extends BaseMovie implements MovieService {
    private MovieDAO movieDAO;

    public MovieServiceImpl(String tableName) throws SQLException {
        try {
            movieDAO = new MovieDAOImpl(tableName, establishConnection());
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void dropTableIfExists() {
        movieDAO.dropTableIfExists();
    }

    @Override
    public void createTable() {
        movieDAO.createTable();
    }

    @Override
    public void insert(MovieEntity movieEntity) {
        movieDAO.insert(movieEntity);
    }

    @Override
    public void updateTitleById(int id, String title) {
        movieDAO.updateTitleById(id, title);
    }

    @Override
    public void deleteById(int id) {
        movieDAO.deleteById(id);
    }

    @Override
    public Optional<MovieEntity> findById(int id) {
        return movieDAO.findById(id);
    }

    @Override
    public List<MovieEntity> findAll() {
        return movieDAO.findAll();
    }

    @Override
    public List<MovieEntity> findMoviesReleasedAfterYearOf(int year) {
        return movieDAO.findMoviesReleasedAfterYearOf(year);
    }

    @Override
    public List<MovieEntity> findMoviesWhereGenreIs(String genre) {
        return movieDAO.findMoviesWhereGenreIs(genre);
    }
}
