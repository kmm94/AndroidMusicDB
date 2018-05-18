package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.MainActivity;
import alex.karim.jebi.androidmusicdb.dummy.AlbumContent;
import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;

public class SearchAlbumTask extends AsyncTask<String, Void, ArrayList<Album>> {



    public SearchAlbumTask() {

    }

    @Override
    protected ArrayList<Album> doInBackground(String... strings) {
        ArrayList<Album> albums = new ArrayList<>(Album.search(strings[0], MainActivity.apiKey));
        return albums;
    }

    @Override
    protected void onPostExecute(ArrayList<Album> albums) {
        super.onPostExecute(albums);
        AlbumContent.ITEMS.clear();
        AlbumContent.addAlbums(albums);
        //TODO: Notify recycle view somehow to update its list


    }
}
