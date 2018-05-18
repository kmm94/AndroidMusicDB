package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.ListContent.AlbumContent;
import alex.karim.jebi.androidmusicdb.MainActivity;
import de.umass.lastfm.Album;

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
        AlbumContent.getInstance().addAlbums(albums);
        //TODO: Notify recycle view somehow to update its list


    }
}
