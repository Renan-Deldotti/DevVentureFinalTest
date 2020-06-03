package br.com.renandeldotti.devventurefinaltest.viewModel;



import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Map;

import br.com.renandeldotti.devventurefinaltest.model.Cat;
import br.com.renandeldotti.devventurefinaltest.retrofit.RetrofitCatConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();

    private RetrofitCatConfig retrofitCatConfig = new RetrofitCatConfig();
    private MutableLiveData<Cat> catData = new MutableLiveData<>();
    private MutableLiveData<Map<String, Object>> catPhotos = new MutableLiveData<>();

    /*public MutableLiveData<List<Cat>> getCatPhotos(){
        Call<List<Cat>> catCall = retrofitCatConfig.getFetchPhotosAPI()
                .getCatImages("cats", "jpg");

        catCall.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                if (response.body() != null){
                    catData.postValue(response.body());
                }
                Log.e(TAG,"Response code: "+response.code());
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                Log.e(TAG,"Error fetching data from API...\nError: "+t.getMessage());
            }
        });

        return catData;
    }*/

    public MutableLiveData<Cat> getCatData(){
        Call<Cat> catCall = retrofitCatConfig.getFetchPhotosAPI().getCatImages("cats","jpg");
        catCall.enqueue(new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {
                if (response.body() != null) {
                    catData.postValue(response.body());
                }
                Log.e(TAG,"Response code: "+response.code());
            }

            @Override
            public void onFailure(Call<Cat> call, Throwable t) {
                Log.e(TAG,"Error fetching data from API...\nError: "+t.getMessage());
            }
        });
        return catData;
    }

    public void testApi(){
        Call<Cat> catCall = retrofitCatConfig.getFetchPhotosAPI().getCatImages("cats","jpg");
        catCall.enqueue(new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {
                Log.e(TAG,"Response code: "+response.code());
            }

            @Override
            public void onFailure(Call<Cat> call, Throwable t) {
                Log.e(TAG,"Error fetching data from API...\nError: "+t.getMessage());
            }
        });
    }

    /*public MutableLiveData<Map<String, Object>> testApi(){
        Call<Map<String,Object>> catCall = retrofitCatConfig.getFetchPhotosAPI().getCatImages("cats","jpg");
        catCall.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                catPhotos.postValue(response.body());
                Log.e(TAG,"Response code: "+response.code());
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e(TAG,"Error fetching data from API...\nError: "+t.getMessage());

            }
        });
        return catPhotos;
    }*/
}
