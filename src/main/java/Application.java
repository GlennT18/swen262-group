import model.database.AllMusic;
import model.database.Database;

public class Application {
    public static void main(String[] args) {
        // Initial Setup of Database
        Database database = new AllMusic();
        database.initialize();
    }
}
