package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.IUpdateContent;
import alex.karim.jebi.androidmusicdb.ListContent.MusicDataContent;
import alex.karim.jebi.androidmusicdb.MainActivity;
import de.umass.lastfm.Album;

public class SearchAlbumTask extends AsyncTask<String, Void, ArrayList<Album>> {

    private IUpdateContent contentToUpdate;

    public SearchAlbumTask(IUpdateContent updatableContent) {
        contentToUpdate = updatableContent;
    }

    @Override
    protected ArrayList<Album> doInBackground(String... strings) {
        ArrayList<Album> albums = new ArrayList<>(Album.search(strings[0], MainActivity.apiKey));
        return albums;
    }

    @Override
    protected void onPostExecute(ArrayList<Album> albums) {
        super.onPostExecute(albums);
        MusicDataContent.getInstance().addAlbums(albums);
        contentToUpdate.updateAdapterContent();
    }
}
