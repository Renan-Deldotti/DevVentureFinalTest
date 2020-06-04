package br.com.renandeldotti.devventurefinaltest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import br.com.renandeldotti.devventurefinaltest.databinding.ActivityMainBinding;
import br.com.renandeldotti.devventurefinaltest.model.Cat;
import br.com.renandeldotti.devventurefinaltest.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainActivityViewModel viewModel;
    private CatImageAdapter adapter;
    private List<String> imagesUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        imagesUrl = new ArrayList<>();
        adapter = new CatImageAdapter(imagesUrl);
        mainBinding.recyclerViewCats.setLayoutManager(new GridLayoutManager(this, 4));
        mainBinding.recyclerViewCats.setHasFixedSize(true);
        mainBinding.recyclerViewCats.setAdapter(adapter);

        mainBinding.buttonSync.setOnClickListener(v -> updateData());

        updateData();

        setContentView(mainBinding.getRoot());
    }

    private void updateData() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {

            if (mainBinding.buttonSync.getVisibility() == View.VISIBLE) {
                mainBinding.buttonSync.setVisibility(View.GONE);
            }

            viewModel.getCatData().observe(this, cat -> {
                if (cat != null) {
                    for (Cat.Data catData : cat.getData()) {
                        for (Cat.Images catImages : catData.getImages()) {
                            imagesUrl.add(catImages.getLink());
                        }
                    }
                }
                mainBinding.progressBarLoading.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            });

        } else {
            mainBinding.progressBarLoading.setVisibility(View.GONE);
            mainBinding.buttonSync.setVisibility(View.VISIBLE);
            Toast.makeText(this, "No internet connection.", Toast.LENGTH_SHORT).show();
        }
    }
}