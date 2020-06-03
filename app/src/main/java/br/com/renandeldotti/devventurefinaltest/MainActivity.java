package br.com.renandeldotti.devventurefinaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.renandeldotti.devventurefinaltest.databinding.ActivityMainBinding;
import br.com.renandeldotti.devventurefinaltest.model.Cat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        mainBinding.recyclerViewCats.setLayoutManager(new GridLayoutManager(this, 4));
        mainBinding.recyclerViewCats.setHasFixedSize(true);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));
        cats.add(new Cat("","",""));

        mainBinding.recyclerViewCats.setAdapter(new CatImageAdapter(cats));

        setContentView(mainBinding.getRoot());
    }
}