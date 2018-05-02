package alex.karim.jebi.androidmusicdb.dummy;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

public class searchSuggestion {

    private String searchtext;

    public searchSuggestion(String text){
        this.searchtext = text;
    }

    public String getBody() {
        return searchtext;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel parcel, int i) {

    }


}
