package hibernate.migration.dao;

import hibernate.migration.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryDAO {
    void save(ProductCategory productCategory);

    Optional<ProductCategory> findBy(int id);

    List<ProductCategory> findAll();

    void delete(ProductCategory productCategory);
}
