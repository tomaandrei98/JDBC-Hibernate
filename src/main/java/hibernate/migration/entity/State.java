package hibernate.migration.entity;

import hibernate.migration.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "state")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class State extends BaseEntity {
    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "category_id")
    @NonNull
    private int categoryId;
}
