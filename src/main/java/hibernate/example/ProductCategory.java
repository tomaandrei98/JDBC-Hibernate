package hibernate.example;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> allProductsPerCategory;

    public ProductCategory() { }

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getAllProductsPerCategory() {
        return allProductsPerCategory;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return getId() == that.getId()
                && Objects.equals(getCategoryName(), that.getCategoryName())
                && Objects.equals(getAllProductsPerCategory(), that.getAllProductsPerCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryName(), getAllProductsPerCategory());
    }
}
