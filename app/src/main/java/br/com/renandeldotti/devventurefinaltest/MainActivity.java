package br.com.renandeldotti.devventurefinaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        viewModel.getCatData().observe(this, new Observer<Cat>() {
            @Override
            public void onChanged(Cat cat) {
                if (cat != null){
                    for (Cat.Data catData : cat.getData()) {
                        for (Cat.Images catImages : catData.getImages()){
                            imagesUrl.add(catImages.getLink());
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });


        setContentView(mainBinding.getRoot());
    }
}