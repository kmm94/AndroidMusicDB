package alex.karim.jebi.androidmusicdb.Domain.Search;

import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;

import alex.karim.jebi.androidmusicdb.Domain.Search.Data.Song;
import alex.karim.jebi.androidmusicdb.ITaskProcess;
import alex.karim.jebi.androidmusicdb.IUpdateContent;
import alex.karim.jebi.androidmusicdb.ListContent.MusicDataContent;
import alex.karim.jebi.androidmusicdb.MainActivity;

public class SearchSongTask extends AsyncTask<String, Boolean, ArrayList<Song>> {

    /*
    vigtig links:
    https://www.tutorialspoint.com/android/android_json_parser.htm
    https://developer.android.com/reference/android/os/AsyncTask
     */

    private IUpdateContent contentToUpdate;
    private ITaskProcess iTaskProcess;

    public SearchSongTask(IUpdateContent updatableContent, ITaskProcess iTaskProcess) {
        contentToUpdate = updatableContent;
        this.iTaskProcess = iTaskProcess;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //
    }

    @Override
    protected ArrayList<Song> doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
        String url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" + strings[0] + "&api_key=" + MainActivity.apiKey + "&format=json";
        String jsonStr = sh.makeServiceCall(url);
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(jsonStr).getAsJsonObject();
        JsonObject results = rootObj.getAsJsonObject("results");
        JsonObject trackmatches = results.getAsJsonObject("trackmatches");
        JsonArray tracks = trackmatches.getAsJsonArray("track");
        ArrayList<Song> songs = new ArrayList<>();
        for (JsonElement jsonSong: tracks
             ) {
            if (jsonSong.isJsonObject()){
                JsonObject jsSong = jsonSong.getAsJsonObject();
                JsonArray images = jsSong.get("image").getAsJsonArray();
                String mediumImageUrl = images.get(1).getAsJsonObject().get("#text").getAsString();
                String largeImageUrl = images.get(2).getAsJsonObject().get("#text").getAsString();
                String extraLargeUrl = images.get(3).getAsJsonObject().get("#text").getAsString();

                Song song = new Song(jsSong.get("name").getAsString(), jsSong.get("artist").getAsString(), jsSong.get("listeners").getAsInt(), mediumImageUrl, largeImageUrl, extraLargeUrl);
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
        iTaskProcess.taskCompleted();
    }
}
