package alex.karim.jebi.androidmusicdb.Fragments;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alex.karim.jebi.androidmusicdb.Fragments.AlbumFragment.OnListFragmentInteractionListener;
import alex.karim.jebi.androidmusicdb.R;
import de.umass.lastfm.Album;
import de.umass.lastfm.ImageHolder;
import de.umass.lastfm.ImageSize;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Album} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.ViewHolder> {

    private final List<Album> mValues;
    private final OnListFragmentInteractionListener mListener;

    public AlbumRecyclerViewAdapter(List<Album> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.albumName.setText(mValues.get(position).getName()); // artist of album
        holder.artistName.setText(mValues.get(position).getArtist()); //Name of album
        String albumCoverUrl = mValues.get(position).getImageURL(ImageSize.MEDIUM);
        if(albumCoverUrl != null && !albumCoverUrl.isEmpty()) {
            Picasso.with(holder.itemView.getContext()).load(mValues.get(position).getImageURL(ImageSize.LARGE)).into(holder.albumCover);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView albumName;
        public final TextView artistName;
        public final ImageView albumCover;
        public Album mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            albumName = view.findViewById(R.id.albumNameTextView);
            artistName = view.findViewById(R.id.artistNameTextView);
            albumCover = view.findViewById(R.id.albumCover);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + artistName.getText() + "'";
        }
    }
}
