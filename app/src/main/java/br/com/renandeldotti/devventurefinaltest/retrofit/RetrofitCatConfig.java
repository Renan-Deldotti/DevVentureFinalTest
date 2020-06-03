package br.com.renandeldotti.devventurefinaltest.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCatConfig {

    private static final String baseUrl = "https://api.imgur.com/3/";

    private final Retrofit retrofit;

    public RetrofitCatConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public FetchPhotosAPI getFetchPhotosAPI() {
        return retrofit.create(FetchPhotosAPI.class);
    }
}
