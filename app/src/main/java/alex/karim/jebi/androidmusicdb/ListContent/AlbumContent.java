package alex.karim.jebi.androidmusicdb.ListContent;

import java.util.ArrayList;
import java.util.List;

import de.umass.lastfm.Album;

public class AlbumContent {

    /**
     * An array of sample (dummy) items.
     */
    private List<Album> ITEMS = new ArrayList<>();
    private static AlbumContent instance;

    private AlbumContent() {}

    public static AlbumContent getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return instance = new AlbumContent();
        }
    }

    /**
     * Clears internal list first and then added new albums from search result.
     * @param albumsToAdd albums from search result.
     */
    public void addAlbums(List<Album> albumsToAdd) {
        ITEMS.clear();
        ITEMS.addAll(albumsToAdd);

    }

    public List<Album> getITEMS() {
        return ITEMS;
    }
}