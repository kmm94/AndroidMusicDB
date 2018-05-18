package alex.karim.jebi.androidmusicdb.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.umass.lastfm.Album;

public class AlbumContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Album> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Album> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

/*    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }*/

    public static void addAlbums(List<Album> albumsToAdd) {
        ITEMS.addAll(albumsToAdd);
        //ITEM_MAP.putAll(albumsToAdd);
    }

    private static void addItem(Album album) {
        ITEMS.add(album);
        ITEM_MAP.put(album.getArtist(), album);
    }

    private static DummyContent.DummyItem createDummyItem(int position) {
        return new DummyContent.DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
