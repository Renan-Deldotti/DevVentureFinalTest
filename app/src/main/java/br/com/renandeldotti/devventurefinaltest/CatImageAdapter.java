package br.com.renandeldotti.devventurefinaltest;

import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class CatImageAdapter extends RecyclerView.Adapter<CatImageAdapter.CatImageViewHolder> {

    private List<String> catList;

    public CatImageAdapter(List<String> catList) {
        this.catList = catList;
    }

    @NonNull
    @Override
    public CatImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cat_item,parent,false);
        return new CatImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatImageViewHolder holder, int position) {
        Glide.with(holder.catImageView.getContext())
                .load(catList.get(position))
                .into(holder.catImageView);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    static class CatImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView catImageView;
        public CatImageViewHolder(@NonNull View itemView) {
            super(itemView);
            catImageView = itemView.findViewById(R.id.imageView_cat);
        }
    }
}
