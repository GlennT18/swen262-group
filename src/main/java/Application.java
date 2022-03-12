import com.opencsv.exceptions.CsvValidationException;
import model.Database;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws CsvValidationException, IOException {
        // Initial Setup of Database
        Database database = new Database();
        database.initialize();
    }
}
