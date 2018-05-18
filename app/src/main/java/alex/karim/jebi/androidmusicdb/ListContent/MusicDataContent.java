package alex.karim.jebi.androidmusicdb.ListContent;

import java.util.ArrayList;
import java.util.List;

import alex.karim.jebi.androidmusicdb.Domain.Search.Data.Song;
import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;

public class MusicDataContent {
    /**
     * An array of sample (dummy) items.
     */
    private List<Artist> artists = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();
    private static MusicDataContent instance;

    private MusicDataContent() {
    }

    public static MusicDataContent getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return instance = new MusicDataContent();
        }
    }

    /**
     * Clears internal list first and then added new albums from search result.
     *
     * @param artistsToAdd albums from search result.
     */
    public void addArtists(List<Artist> artistsToAdd) {
        artists.clear();
        artists.addAll(artistsToAdd);
    }

    /**
     * Clears internal list first and then added new albums from search result.
     *
     * @param songsToAdd albums from search result.
     */
    public void addSongs(List<Song> songsToAdd) {
        songs.clear();
        songs.addAll(songsToAdd);
    }

    /**
     * Clears internal list first and then added new albums from search result.
     *
     * @param albumsToAdd albums from search result.
     */
    public void addAlbums(List<Album> albumsToAdd) {
        albums.clear();
        albums.addAll(albumsToAdd);
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
