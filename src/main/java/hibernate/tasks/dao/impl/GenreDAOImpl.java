package hibernate.tasks.dao.impl;

import hibernate.tasks.dao.GenreDAO;
import hibernate.tasks.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GenreDAOImpl implements GenreDAO {
    private final EntityManager entityManager;

    public GenreDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Genre save(Genre genre) {
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(genre);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return genre;
    }

    @Override
    public Genre delete(Genre genre) {
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(genre);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return genre;
    }

    @Override
    public List<Genre> findAllByName(String name) {
        return entityManager.createQuery("from Genre where name = :name", Genre.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Optional<Genre> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    @Override
    public List<Genre> findAll() {
        return entityManager.createQuery("from Genre", Genre.class).getResultList();
    }
}
