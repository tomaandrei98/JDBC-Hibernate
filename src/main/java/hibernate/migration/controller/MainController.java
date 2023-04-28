package hibernate.migration.controller;

import hibernate.migration.entity.ProductCategory;
import hibernate.migration.service.impl.ProductCategoryServiceImpl;

public class MainController {
    public static void main(String[] args) {
        ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl();

        productCategoryService.getProductCategories().forEach(System.out::println);
        System.out.println();
        System.out.println();

        productCategoryService.saveProductCategory(new ProductCategory("JavaRemoteRO52"));
        productCategoryService.getProductCategories().forEach(System.out::println);
        System.out.println();
        System.out.println();

        productCategoryService.updateProductCategory(5, "NewName");
        productCategoryService.getProductCategories().forEach(System.out::println);
        System.out.println();
        System.out.println();

        productCategoryService.getProductCategory(10)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("x")
                );

        productCategoryService
                .getProductCategory(10)
                .ifPresent(productCategoryService::deleteProductCategory);
    }
}
