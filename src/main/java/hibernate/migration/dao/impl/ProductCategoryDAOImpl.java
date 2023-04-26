package hibernate.migration.dao.impl;

import hibernate.migration.dao.ProductCategoryDAO;
import hibernate.migration.dao.base.BaseDAO;
import hibernate.migration.entity.ProductCategory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ProductCategoryDAOImpl extends BaseDAO implements ProductCategoryDAO {

    public ProductCategoryDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void save(ProductCategory productCategory) {
        Transaction transaction = null;
        try {
            transaction = currentSession.beginTransaction();
            currentSession.persist(productCategory);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<ProductCategory> findBy(int id) {
        return Optional.ofNullable(currentSession.get(ProductCategory.class, id));
    }

    @Override
    public List<ProductCategory> findAll() {
        return currentSession.createQuery("from ProductCategory", ProductCategory.class).list();
    }

    @Override
    public void delete(ProductCategory productCategory) {
        Transaction transaction = null;
        try {
            transaction = currentSession.beginTransaction();
            currentSession.remove(productCategory);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
