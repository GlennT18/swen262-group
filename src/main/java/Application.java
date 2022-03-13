import model.AllMusic;
import model.Database;

public class Application {
    public static void main(String[] args) {
        // Initial Setup of Database
        Database database = new AllMusic();
        database.initialize();
    }
}
