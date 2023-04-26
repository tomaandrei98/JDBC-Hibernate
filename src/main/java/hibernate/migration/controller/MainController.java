package hibernate.migration.controller;

import hibernate.migration.service.impl.ProductCategoryServiceImpl;

public class MainController {
    public static void main(String[] args) {
        ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl();

        productCategoryService.getProductCategories().forEach(System.out::println);
    }
}
