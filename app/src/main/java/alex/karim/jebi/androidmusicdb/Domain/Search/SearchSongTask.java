package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import android.util.Log;


import java.util.ArrayList;


import alex.karim.jebi.androidmusicdb.Domain.Search.Data.Song;
import alex.karim.jebi.androidmusicdb.MainActivity;

public class SearchSongTask extends AsyncTask<String, Void, ArrayList<Song>> {

    private Context mContext;
    private String TAG = MainActivity.class.getSimpleName();

    public SearchSongTask (Context context){
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(mContext, "Getting Search result", Toast.LENGTH_LONG).show();
    }

    @Override
    protected ArrayList<Song> doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
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
