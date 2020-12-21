
package com.mvpSample.data.entity.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mvpSample.data.entity.CommonResponse;

import java.util.ArrayList;

/**
 * GetSearch
 */
public class GetSearch extends CommonResponse {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("results-for")
    @Expose
    private String resultsFor;
    @SerializedName("results")
    @Expose
    private ArrayList<SearchResult> searchResults = null;

    public String getResponse() {
        return response;
    }

    public String getResultsFor() {
        return resultsFor;
    }

    public ArrayList<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

}
