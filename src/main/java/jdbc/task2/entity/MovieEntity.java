package jdbc.task2.entity;

/* The entity which will be saved in database */
/* Better implementation can be made with Lombok dependency instead of getters/setters */

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
