package com.mvpSample.data.network;


import com.mvpSample.BaseApplication;
import com.mvpSample.BuildConfig;

import java.util.concurrent.TimeUnit;

import io.requestly.android.okhttp.api.RQCollector;
import io.requestly.android.okhttp.api.RQInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rest Client
 */
public final class RestClient {

    private static final int TIME_OUT = 120;
    private static Retrofit retrofit = null;

    /**
     * Prevent instantiation
     */
    private RestClient() {
    }

    /**
     * Gets api interface.
     *
     * @return object of ApiInterface
     */
    public static ApiInterface getApiInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    //.client(secureConnection().build())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

    /**
     * Gets retrofit builder.
     *
     * @return object of Retrofit
     */
    static Retrofit getRetrofitBuilder() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    .build();
        }
        return retrofit;
    }

    /**
     * Gets request header.
     *
     * @return the request header
     */
    private static OkHttpClient getRequestHeader() {
        return new OkHttpClient.Builder()
                //.addInterceptor(getLoggingInterceptor())
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * @return object of OkHttpClient.Builder
     */
    public static OkHttpClient.Builder httpClient() {
        RQCollector collector = new RQCollector(BaseApplication.getAppContext());

        RQInterceptor rqInterceptor = new RQInterceptor.Builder(BaseApplication.getAppContext())
                .collector(collector)
                .build();

        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(rqInterceptor);
        return httpClient;
    }

    /**
     * Method to get object of HttpLoggingInterceptor
     *
     * @return object of HttpLoggingInterceptor
     */
    private static HttpLoggingInterceptor getLoggingInterceptor() {
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return logging;
    }
}
