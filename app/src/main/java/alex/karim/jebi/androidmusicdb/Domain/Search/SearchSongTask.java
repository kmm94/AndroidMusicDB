package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.Domain.Search.Data.Song;
import alex.karim.jebi.androidmusicdb.MainActivity;
import de.umass.lastfm.Caller;

public class SearchSongTask extends AsyncTask<String, Void, ArrayList<Song>> {

    /*
    vigtig links:
    https://www.tutorialspoint.com/android/android_json_parser.htm
    https://developer.android.com/reference/android/os/AsyncTask
     */


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
