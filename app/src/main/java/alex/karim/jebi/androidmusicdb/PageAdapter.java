package alex.karim.jebi.androidmusicdb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import javax.xml.parsers.FactoryConfigurationError;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment songFragment = new SongFragment();
                return songFragment;
            case 1:
                Fragment albumFragment = new AlbumFragment();
                return albumFragment;
            case 2:
                Fragment artistFragment = new AristFragment();
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
