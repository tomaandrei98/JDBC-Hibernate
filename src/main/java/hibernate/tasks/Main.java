package hibernate.tasks;

import hibernate.tasks.dao.GenreDAO;
import hibernate.tasks.dao.impl.GenreDAOImpl;
import hibernate.tasks.entity.Actor;
import hibernate.tasks.entity.Genre;
import hibernate.tasks.entity.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();

        GenreDAO genreDAO = new GenreDAOImpl(sessionFactory.createEntityManager());

        Genre savedGenre = genreDAO.save(new Genre("Action2", null));
        Genre savedGenre2 = genreDAO.save(new Genre("Action3", null));

        System.out.println("---------------------------");
        System.out.println(genreDAO.findById(savedGenre.getId()));
        System.out.println("---------------------------");
        genreDAO.findAllByName("Action3").forEach(System.out::println);
        System.out.println("---------------------------");
        genreDAO.findAll().forEach(System.out::println);
        System.out.println("---------------------------");
        genreDAO.delete(savedGenre);
        genreDAO.findAll().forEach(System.out::println);

        sessionFactory.close();
    }
}
