package br.com.renandeldotti.devventurefinaltest.retrofit;

import br.com.renandeldotti.devventurefinaltest.model.Cat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchPhotosAPI {

    @GET("gallery/search")
    Call<Cat> getCatImages(@Query("q") String searchTag, @Query("q_type") String fileType);

}