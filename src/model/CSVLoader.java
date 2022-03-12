package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {
    static final String DELIMITER = ",";
    static final String ARTISTS_CSV = "data/artists.csv";

    private void loadArtists() {

    }

    public static void main(String[] args) throws IOException {
        // Open artists csv
        BufferedReader br = new BufferedReader(new FileReader(ARTISTS_CSV));

        // read lines
        String line = br.readLine();
        String[] row;
        while (line != null) {
            row = line.split(DELIMITER);
            for (String field : row) {
                System.out.print(field + "|");
            }
            System.out.println();

            // Read next line
            line = br.readLine();
        }
        System.out.println("Done");
    }

}
