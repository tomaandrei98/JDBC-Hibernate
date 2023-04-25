package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create configuration
        Configuration configuration = new Configuration();
        configuration.configure();

        // add entity classes to hibernate context
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductCategory.class);

        // create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // initialize session object
        Session session = sessionFactory.openSession();

        // query all products
        List<Product> allProducts = session.createQuery("FROM Product", Product.class).getResultList();

        for (Product p : allProducts) {
            System.out.println(p);
        }

    }
}
