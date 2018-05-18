package alex.karim.jebi.androidmusicdb.ListContent;

import java.util.ArrayList;
import java.util.List;

import de.umass.lastfm.Artist;

public class ArtistContent {
    /**
     * An array of sample (dummy) items.
     */
    private List<Artist> ITEMS = new ArrayList<>();
    private static ArtistContent instance;

    private ArtistContent() {
    }

    public static ArtistContent getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return instance = new ArtistContent();
        }
    }

    /**
     * Clears internal list first and then added new albums from search result.
     *
     * @param artistsToAdd albums from search result.
     */
    public void addArtists(List<Artist> artistsToAdd) {
        ITEMS.clear();
        ITEMS.addAll(artistsToAdd);
    }

    public List<Artist> getITEMS() {
        return ITEMS;
    }
}
