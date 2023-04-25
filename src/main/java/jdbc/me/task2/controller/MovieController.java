package jdbc.me.task2.controller;

import jdbc.task2.entity.MovieEntity;
import jdbc.task2.service.MovieService;
import jdbc.task2.service.impl.MovieServiceImpl;

import java.sql.SQLException;

public class MovieController {
    private static MovieService movieService;

    public static void main(String[] args) throws SQLException {
        try {
            movieService = new MovieServiceImpl("MOVIES");

            // dropping movie tables if exists
            movieService.dropTableIfExists();

            // creating movie's table
            movieService.createTable();

            // insert movies into table
            movieService.insert(new MovieEntity("Star Wars", "Adventure", 2015));
            movieService.insert(new MovieEntity("Harry Potter", "Fantasy", 2001));
            movieService.insert(new MovieEntity("Rocky", "Sports", 1979));
            movieService.insert(new MovieEntity("Out California Way", "Western", 1994));
            movieService.insert(new MovieEntity("Ramona and Beezus", "Comedy", 2002));
            movieService.insert(new MovieEntity("Emmanuelle", "Drama", 2006));
            movieService.insert(new MovieEntity("Star Trek: Generations", "Adventure", 2004));
            movieService.insert(new MovieEntity("Ana and the Others", "Drama", 1997));
            movieService.insert(new MovieEntity("How Much Wood Would a Woodchuck Chuck", "Documentary", 1988));
            movieService.insert(new MovieEntity("Punks", "Comedy", 2009));
            movieService.insert(new MovieEntity("Signs & Wonders", "Drama", 2000));
            movieService.insert(new MovieEntity("Flesh Gordon", "Adventure", 1989));
            movieService.insert(new MovieEntity("Black Friday", "Drama", 1991));
            movieService.insert(new MovieEntity("Crazy Horse", "Documentary", 2008));

            // update title by id
            movieService.updateTitleById(2, "Titanic");

            // delete movie by id
            movieService.deleteById(3);

            // find movie by id
            System.out.println(movieService.findById(1));
            System.out.println(movieService.findById(2));
            System.out.println(movieService.findById(3));

            // find all movies
            System.out.println(movieService.findAll());

            // find all movies released after specified year
            System.out.println(movieService.findMoviesReleasedAfterYearOf(2000));

            // find all movies with genre of
            System.out.println(movieService.findMoviesWhereGenreIs("drama"));
            System.out.println(movieService.findMoviesWhereGenreIs("adventure"));
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
