package com.mvpSample.data.network;

import androidx.annotation.NonNull;

import com.mvpSample.data.entity.CommonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Custom Retrofit ResponseResolver
 *
 * @param <T> the response type
 */
public abstract class ResponseResolver<T> implements Callback<T> {

    /**
     * On Api response success
     *
     * @param t the response
     */
    public abstract void onSuccess(T t);

    /**
     * On Api error received
     *
     * @param error the error sent by the endpoint
     */
    public abstract void onError(ApiError error);

    /**
     * Indicates failure of the request
     *
     * @param throwable the throwable generated
     */
    public abstract void onFailure(Throwable throwable);

    @Override
    public void onResponse(@NonNull final Call<T> t, @NonNull final Response<T> tResponse) {

        if (tResponse.isSuccessful()) {
            assert tResponse.body() != null;
            final CommonResponse body = (CommonResponse) tResponse.body();
            //noinspection ConstantConditions
            if (body != null) {
                if (body.getError() != null)
                    onError(new ApiError(body.getFlag(), body.getError()));
                else
                    onSuccess(tResponse.body());

            }
        } else {
            onError(ErrorUtils.parseError(tResponse));
        }

    }

    @Override
    public void onFailure(@NonNull final Call<T> t, @NonNull final Throwable throwable) {
        onFailure(throwable);
    }
}