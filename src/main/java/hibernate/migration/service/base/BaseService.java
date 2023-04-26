package hibernate.migration.service.base;

import hibernate.migration.entity.Country;
import hibernate.migration.entity.Product;
import hibernate.migration.entity.ProductCategory;
import hibernate.migration.entity.State;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class BaseService {
    private SessionFactory sessionFactory;

    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                configuration.addAnnotatedClass(ProductCategory.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(State.class);
                configuration.addAnnotatedClass(Country.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
