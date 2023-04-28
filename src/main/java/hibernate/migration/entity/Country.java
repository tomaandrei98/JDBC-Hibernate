package hibernate.migration.entity;

import hibernate.migration.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "country_id")
    private List<State> states;
}
