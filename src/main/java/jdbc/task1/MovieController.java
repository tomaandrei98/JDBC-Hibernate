package jdbc.task1;

public class MovieController extends BaseMovie {
    private static final String TABLE_NAME = "MOVIES";

    public static void main(String[] args) {
        dropTableIfExists(TABLE_NAME);
        createTable(TABLE_NAME);

        insert(TABLE_NAME, "Star wars", "action", 1987);
        insert(TABLE_NAME, "Harry Potter", "fantasy", 2014);
        insert(TABLE_NAME, "Rocky", "sport", 1960);

        updateTitleById(TABLE_NAME, "Jurassic Park", 1);

        deleteById(TABLE_NAME, 2);

        findAll(TABLE_NAME);
    }
}