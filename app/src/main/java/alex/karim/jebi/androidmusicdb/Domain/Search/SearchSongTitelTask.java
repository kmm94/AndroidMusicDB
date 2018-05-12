package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;
import android.util.Log;


import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SearchSongTitelTask extends AsyncTask<String, Void, ArrayList<Song>> {


    @Override
    protected ArrayList<Song> doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=hot&api_key=e3bab7f8adef7e0490d767e0305dd7ce&format=json";
        String jsonStr = sh.makeServiceCall(url);

        Log.e(TAG, "Response from url: " + jsonStr);


        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Song> songs) {
        super.onPostExecute(songs);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
