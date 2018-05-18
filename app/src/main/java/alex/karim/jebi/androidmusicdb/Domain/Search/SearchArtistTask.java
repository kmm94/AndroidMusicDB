package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.IUpdateContent;
import alex.karim.jebi.androidmusicdb.ListContent.MusicDataContent;
import alex.karim.jebi.androidmusicdb.MainActivity;
import de.umass.lastfm.Artist;


public class SearchArtistTask extends AsyncTask<String, Void, ArrayList<Artist>> {

    private IUpdateContent contentToUpdate;

    public SearchArtistTask(IUpdateContent updatableContent) {
        contentToUpdate = updatableContent;
    }

    @Override
    protected ArrayList<Artist> doInBackground(String... strings) {
        ArrayList<Artist> artists = new ArrayList<>(Artist.search(strings[0], MainActivity.apiKey));
        return artists;
    }

    @Override
    protected void onPostExecute(ArrayList<Artist> artists) {
        super.onPostExecute(artists);
        MusicDataContent.getInstance().addArtists(artists);
        //TODO: Display albums fra search results(Alexander)
        contentToUpdate.updateAdapterContent();


    }
}
