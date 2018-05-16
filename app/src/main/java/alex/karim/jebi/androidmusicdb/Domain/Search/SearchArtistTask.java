package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.MainActivity;

import de.umass.lastfm.Artist;


public class SearchArtistTask extends AsyncTask<String, Void, ArrayList<Artist>> {


    private Context mContext;

    public SearchArtistTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected ArrayList<Artist> doInBackground(String... strings) {

        ArrayList<Artist> artists = new ArrayList<>(Artist.search(strings[0], MainActivity.apiKey));

        return artists;
    }

    @Override
    protected void onPostExecute(ArrayList<Artist> artists) {
        super.onPostExecute(artists);
        //TODO: Display albums fra search results

    }
}
