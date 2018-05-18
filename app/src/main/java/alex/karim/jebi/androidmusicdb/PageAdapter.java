package alex.karim.jebi.androidmusicdb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import alex.karim.jebi.androidmusicdb.Fragments.AlbumFragment;
import alex.karim.jebi.androidmusicdb.Fragments.ArtistFragment;
import alex.karim.jebi.androidmusicdb.Fragments.SongFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    private SongFragment songFragment;
    private ArtistFragment artistFragment;
    private AlbumFragment albumFragment;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
        albumFragment = new AlbumFragment();
        songFragment = new SongFragment();
        artistFragment = new ArtistFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return songFragment;
            case 1:
                return albumFragment;
            case 2:
                return artistFragment;
            default:
                    Log.i("Position: ", "p: "+ position);
                    return null;

        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
