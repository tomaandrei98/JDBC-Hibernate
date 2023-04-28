package hibernate.tasks.entity;

import hibernate.tasks.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "movieList", callSuper = true)
@ToString(exclude = "movieList", callSuper = true)
public class Genre extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Movie> movieList = new ArrayList<>();
}
