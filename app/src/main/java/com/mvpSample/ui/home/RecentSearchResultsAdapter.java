package com.mvpSample.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mvpSample.R;

import java.util.ArrayList;

/**
 * Recent Search Results Adapter
 */
public class RecentSearchResultsAdapter extends RecyclerView.Adapter<RecentSearchResultsAdapter.ViewHolder> {
    private final ArrayList<String> recentSearchResultArrayList;
    private final RecentSearchAdapterCallback mListener;

    /**
     * Instantiates a new Adapter
     *
     * @param list the list
     */
    public RecentSearchResultsAdapter(final ArrayList<String> list, final RecentSearchAdapterCallback callback) {
        this.recentSearchResultArrayList = list;
        mListener = callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_recent_search_results, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int pos) {
        final int position = holder.getAdapterPosition();
        String searchString = recentSearchResultArrayList.get(position);
        holder.tvSearchString.setText(searchString);
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onClickRecentSearchString(searchString);
            }
        });
    }

    @Override
    public int getItemCount() {
        assert recentSearchResultArrayList != null;
        return recentSearchResultArrayList.size();
    }

    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSearchString;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        ViewHolder(final View v) {
            super(v);
            tvSearchString = v.findViewById(R.id.tvSearchString);
        }
    }

    /**
     * Recent Search Adapter Callback
     */
    public interface RecentSearchAdapterCallback {
        /**
         * onClickRecentSearchString
         *
         * @param searchString search string
         */
        void onClickRecentSearchString(String searchString);
    }

}
