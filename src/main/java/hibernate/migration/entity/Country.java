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
@Table(name = "country")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Country extends BaseEntity {
    @Column(name = "code")
    @NonNull
    private String code;

    @Column(name = "name")
    @NonNull
    private String name;

    // TODO: 25/04/2023 implement join relationship with State table, use OneToMany or ManyToOne in State class
}
