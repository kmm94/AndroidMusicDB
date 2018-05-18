package alex.karim.jebi.androidmusicdb.Domain.Search.Data;

import java.util.HashMap;

import de.umass.lastfm.ImageSize;

public class Song {
    private String name;
    private String artist;
    private int listeners;
    private HashMap<ImageSize,String> ImageUrls = new HashMap<>();

    public Song(String name, String artist, int listeners,String mediumImageUrl, String largeImageUrl, String xLargeImageUrl) {
        this.name = name;
        this.artist = artist;
        this.listeners = listeners;
        this.ImageUrls.put(ImageSize.MEDIUM, mediumImageUrl);
        this.ImageUrls.put(ImageSize.LARGE, largeImageUrl);
        this.ImageUrls.put(ImageSize.EXTRALARGE, xLargeImageUrl);

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
