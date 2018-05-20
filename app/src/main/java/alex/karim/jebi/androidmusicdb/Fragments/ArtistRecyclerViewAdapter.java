package alex.karim.jebi.androidmusicdb.Fragments;

import android.icu.text.NumberFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import alex.karim.jebi.androidmusicdb.Fragments.ArtistFragment.OnListFragmentInteractionListener;
import alex.karim.jebi.androidmusicdb.R;
import de.umass.lastfm.Artist;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Artist} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ArtistRecyclerViewAdapter extends RecyclerView.Adapter<ArtistRecyclerViewAdapter.ViewHolder> {

    private final List<Artist> mValues;
    private final OnListFragmentInteractionListener mListener;

    ArtistRecyclerViewAdapter(List<Artist> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.artistName.setText(mValues.get(position).getName());
        holder.numberOfListeners.setText(java.text.NumberFormat.getInstance().format(mValues.get(position).getListeners()));

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView artistName;
        final TextView numberOfListeners;
        Artist mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            artistName = view.findViewById(R.id.artistFragmentNameTextView);
            numberOfListeners = view.findViewById(R.id.listenersTextView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + numberOfListeners.getText() + "'";
        }
    }
}
