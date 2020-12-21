package com.mvpSample.data.network;

import com.mvpSample.data.entity.search.GetSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The API interface for your application
 */
public interface ApiInterface {

    /**
     * search Super hero by name
     *
     * @return api call
     */
    @GET("search/{name}")
    Call<GetSearch> searchSuperhero(@Path("name") String name);

}
