package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;


import java.util.ArrayList;

public class SearchSongTitelTask extends AsyncTask<String, Void, ArrayList<Song>> {


    @Override
    protected ArrayList<Song> doInBackground(String... strings) {


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
