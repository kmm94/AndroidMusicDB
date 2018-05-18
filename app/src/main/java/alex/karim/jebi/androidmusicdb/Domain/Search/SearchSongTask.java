package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import alex.karim.jebi.androidmusicdb.Domain.Search.Data.Song;
import alex.karim.jebi.androidmusicdb.IUpdateContent;
import alex.karim.jebi.androidmusicdb.ListContent.MusicDataContent;
import alex.karim.jebi.androidmusicdb.MainActivity;

public class SearchSongTask extends AsyncTask<String, Void, ArrayList<Song>> {

    /*
    vigtig links:
    https://www.tutorialspoint.com/android/android_json_parser.htm
    https://developer.android.com/reference/android/os/AsyncTask
     */

    private IUpdateContent contentToUpdate;
    public SearchSongTask(IUpdateContent updatableContent) {
        contentToUpdate = updatableContent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //
    }

    @Override
    protected ArrayList<Song> doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
        String url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=hot&api_key=e3bab7f8adef7e0490d767e0305dd7ce&format=json";
        String jsonStr = sh.makeServiceCall(url);
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(jsonStr).getAsJsonObject();
        JsonObject results = rootObj.getAsJsonObject("results");
        JsonObject trackmatches = results.getAsJsonObject("trackmatches");
        JsonArray tracks = trackmatches.getAsJsonArray("track");
        ArrayList<Song> songs = new ArrayList<Song>();
        for (JsonElement jsonSong: tracks
             ) {
            if (jsonSong.isJsonObject()){
                JsonObject jsSong = jsonSong.getAsJsonObject();
                Song song = new Song(jsSong.get("name").getAsString(), jsSong.get("artist").getAsString(), jsSong.get("listeners").getAsInt());
                songs.add(song);
            }
        }
        return songs;
    }

    @Override
    protected void onPostExecute(ArrayList<Song> songs) {
        super.onPostExecute(songs);
        MusicDataContent.getInstance().addSongs(songs);
        contentToUpdate.updateAdapterContent();
    }

}
