package alex.karim.jebi.androidmusicdb;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import alex.karim.jebi.androidmusicdb.Domain.Search.SearchAlbumTask;
import alex.karim.jebi.androidmusicdb.Domain.Search.SearchArtistTask;
import alex.karim.jebi.androidmusicdb.Domain.Search.SearchSongTask;
import alex.karim.jebi.androidmusicdb.Fragments.AlbumFragment;
import alex.karim.jebi.androidmusicdb.Fragments.SongFragment;
import alex.karim.jebi.androidmusicdb.dummy.DummyContent;
import de.umass.lastfm.Album;
import de.umass.lastfm.Caller;


public class MainActivity extends AppCompatActivity implements SongFragment.OnListFragmentInteractionListener, AlbumFragment.OnListFragmentInteractionListener {

    public static String apiKey = "e3bab7f8adef7e0490d767e0305dd7ce";
    ViewPager viewPager;
    PageAdapter pageAdapter;
    FloatingSearchView mSearchView;
    SearchSongTask searchSongTask;
    SearchArtistTask searchArtistTask;
    SearchAlbumTask searchAlbumTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.pager);
        mSearchView = findViewById(R.id.floating_search_view);

        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));

        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Using PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        //instantiating Api library
        Caller.getInstance().setUserAgent("Jebi");

        searchSongTask = new SearchSongTask(this);
        searchArtistTask = new SearchArtistTask(this);
        searchAlbumTask = new SearchAlbumTask(this);

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                //TODO: add suggestions and add an action for them here. (out of scope)
            }

            @Override
            public void onSearchAction(String currentQuery) {
                //Here a search is started when the user press enter
                Log.i("Searchinput: ", currentQuery);
                searchSongTask.execute(currentQuery);
                searchArtistTask.execute(currentQuery);
                searchAlbumTask.execute(currentQuery);


            }
        });

        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {
                //TODO: make a list from the search query here.(out of scope)
            }
        });

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(Album item) {
        Log.i(String.valueOf(MainActivity.class), "Interacting with: " + item);
    }
}
