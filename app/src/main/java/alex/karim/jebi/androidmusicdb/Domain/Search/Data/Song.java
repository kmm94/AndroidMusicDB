package alex.karim.jebi.androidmusicdb.Domain.Search.Data;

public class Song {
    private String name;
    private String artist;
    private int listeners;

    public Song(String name, String artist, int listeners) {
        this.name = name;
        this.artist = artist;
        this.listeners = listeners;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getListeners() {
        return listeners;
    }
}
