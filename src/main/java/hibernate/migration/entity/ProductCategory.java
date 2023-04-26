package hibernate.migration.entity;

import hibernate.migration.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "product_category")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ProductCategory extends BaseEntity {
    @Column(name = "category_name")
    @NonNull
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> allProductsPerCategory;
}
