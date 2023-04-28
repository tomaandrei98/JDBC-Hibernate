package hibernate.tasks.dao;

import hibernate.tasks.entity.Genre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenreDAO {
    Genre save(Genre genre);

    Genre delete(Genre genre);

    List<Genre> findAllByName(String name);

    Optional<Genre> findById(UUID id);

    List<Genre> findAll();
}
