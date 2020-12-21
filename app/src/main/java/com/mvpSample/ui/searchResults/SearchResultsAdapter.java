package com.mvpSample.ui.searchResults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mvpSample.R;
import com.mvpSample.data.entity.search.Image;
import com.mvpSample.data.entity.search.SearchResult;

import java.util.ArrayList;

/**
 * SearchResultsAdapter
 */
public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder> {
    private final ArrayList<SearchResult> searchResultArrayList;
    private final SearchResultAdapterCallback mListener;

    /**
     * Instantiates a new Adapter
     *
     * @param list the list
     */
    public SearchResultsAdapter(final ArrayList<SearchResult> list, final SearchResultAdapterCallback callback) {
        this.searchResultArrayList = list;
        mListener = callback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_search_results, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int pos) {
        final int position = holder.getAdapterPosition();
        SearchResult searchResult = searchResultArrayList.get(position);
        Context context = holder.itemView.getContext();
        if (searchResult.getImage() != null && searchResult.getImage() != null) {
            Image image = searchResult.getImage();
            Glide.with(context).load(image.getUrl()).into(holder.ivSuperheroImage);
        }
        holder.tvSuperheroName.setText(searchResult.getName());
        if (searchResult.getConnections() != null && searchResult.getConnections().getGroupAffiliation() != null) {
            holder.tvSuperheroDescription.setText(searchResult.getConnections().getGroupAffiliation());
        }
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.openDetailsForSearchItem(searchResult);
            }
        });
    }

    @Override
    public int getItemCount() {
        assert searchResultArrayList != null;
        return searchResultArrayList.size();
    }

    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivSuperheroImage;
        private final TextView tvSuperheroName;
        private final TextView tvSuperheroDescription;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        ViewHolder(final View v) {
            super(v);
            ivSuperheroImage = v.findViewById(R.id.ivSuperheroImage);
            tvSuperheroName = v.findViewById(R.id.tvSuperheroName);
            tvSuperheroDescription = v.findViewById(R.id.tvSuperheroDescription);
        }
    }

    /**
     * Search Result Adapter Callback
     */
    public interface SearchResultAdapterCallback {
        /**
         * open Details For Searched Item
         *
         * @param searchResult search result
         */
        void openDetailsForSearchItem(SearchResult searchResult);
    }
}
