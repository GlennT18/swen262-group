import model.Artist;
import model.Release;
import model.Song;
import model.database.AllMusic;
import model.database.Database;
import model.database.PersonalMusicLibrary;

public class Application {
    public static void main(String[] args) {
        // Initial Setup of Databases
        Database allMusic = new AllMusic();
        Database personalLibrary = new PersonalMusicLibrary();

        System.out.println(personalLibrary.getArtists().keySet());
        System.out.println(personalLibrary.getSongs().keySet());
        System.out.println(personalLibrary.getReleases().keySet());

        // Add release and song and artist to test personal music library
        Artist artist1 = allMusic.getArtists().get("183d6ef6-e161-47ff-9085-063c8b897e97");
        personalLibrary.addArtist(artist1);

        Song song1 = allMusic.getSongs().get("6e33056b-2a34-4ed0-b49c-f7a8ae2c5bcc");
        personalLibrary.addSong(song1);

        Release release1 = allMusic.getReleases().get("c4c90ef7-da52-48b4-8c3a-b30c1367e75e");
        personalLibrary.addRelease(release1);

        // Save personalLibrary
        personalLibrary.save();

    }
}
