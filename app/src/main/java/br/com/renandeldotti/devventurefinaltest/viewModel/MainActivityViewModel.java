package br.com.renandeldotti.devventurefinaltest.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.com.renandeldotti.devventurefinaltest.model.Cat;
import br.com.renandeldotti.devventurefinaltest.retrofit.RetrofitCatConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();

    private RetrofitCatConfig retrofitCatConfig = new RetrofitCatConfig();
    private MutableLiveData<Cat> catData = new MutableLiveData<>();

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
}
