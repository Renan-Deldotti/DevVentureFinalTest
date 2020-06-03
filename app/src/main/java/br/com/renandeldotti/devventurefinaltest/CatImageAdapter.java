package br.com.renandeldotti.devventurefinaltest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.renandeldotti.devventurefinaltest.model.Cat;

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
        holder.catImageView.setImageResource(R.drawable.cat_placeholder);
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
