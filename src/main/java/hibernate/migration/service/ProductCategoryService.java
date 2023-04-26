package hibernate.migration.service;

import hibernate.migration.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    void saveProductCategory(ProductCategory productCategory);

    Optional<ProductCategory> getProductCategory(int id);

    List<ProductCategory> getProductCategories();

    void deleteProductCategory(ProductCategory productCategory);

    void updateProductCategory(int id, String name);
}
