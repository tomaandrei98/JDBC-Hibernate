package hibernate.migration.service.impl;

import hibernate.migration.dao.ProductCategoryDAO;
import hibernate.migration.dao.impl.ProductCategoryDAOImpl;
import hibernate.migration.entity.ProductCategory;
import hibernate.migration.service.ProductCategoryService;
import hibernate.migration.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class ProductCategoryServiceImpl extends BaseService implements ProductCategoryService {

    private final ProductCategoryDAO productCategoryDAO;

    public ProductCategoryServiceImpl() {
        productCategoryDAO = new ProductCategoryDAOImpl(getSessionFactory());
    }

    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryDAO.save(productCategory);
    }

    @Override
    public Optional<ProductCategory> getProductCategory(int id) {
        return productCategoryDAO.findBy(id);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return productCategoryDAO.findAll();
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) {
        productCategoryDAO.delete(productCategory);
    }

    @Override
    public void updateProductCategory(int id, String name) {
        ProductCategory productCategory = productCategoryDAO.findBy(id).orElseThrow(() ->
                new NullPointerException(String.format("product category by id = %s could not be found", id))
        );

        productCategory.setCategoryName(name);
        productCategoryDAO.save(productCategory);
    }
}
