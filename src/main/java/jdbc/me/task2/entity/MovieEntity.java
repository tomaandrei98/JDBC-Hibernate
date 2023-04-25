package jdbc.me.task2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class MovieEntity {
    private Integer id;
    private String title;
    private String genre;
    private Integer yearOfRelease;

    public MovieEntity() {
        this.id = -1;
        this.title = "";
        this.genre = "";
        this.yearOfRelease = -1;
    }

    public MovieEntity(String title, String genre, Integer yearOfRelease) {
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }
}
