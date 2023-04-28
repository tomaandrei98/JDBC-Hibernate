package hibernate.migration.entity;

import hibernate.migration.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product_category")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends BaseEntity {
    @Column(name = "category_name")
    @NonNull
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Product> allProductsPerCategory;
}
