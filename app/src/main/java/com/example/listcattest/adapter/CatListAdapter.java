package com.example.listcattest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listcattest.R;
import com.example.listcattest.model.Images;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.CatListHolder> {

    private Context context;
    private ArrayList<Images> imageList;
    private AdapterView.OnItemClickListener listener;


    public CatListAdapter(ArrayList<Images> list) {
        this.imageList = list;
        notifyDataSetChanged();
    }


    //region OnCreateViewHolder
    @NonNull
    @Override
    public CatListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_list, parent, false);
        CatListHolder catHolder = new CatListHolder(itemView, (CatListHolder.OnItemClickListener) listener);
        context = parent.getContext();
        return catHolder;
    }
    //endregion

    //region OnBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull CatListHolder holder, int position) {
        Images currentItem = imageList.get(position);
        if (currentItem.getType().contains("image")) {
            loadPhotoGallery(currentItem.getLink(), holder.CatImage);
        }
    }
    //endregion

    //region getItemCount
    @Override
    public int getItemCount() {
        return imageList.size();
    }
    //endregion

    //region loadPhotoGallery
    private void loadPhotoGallery(String link, ImageView catImage) {
        Picasso.with(context)
                .load(link)
                .resize(300, 200)
                .into(catImage);
    }
    //endregion



    public static class CatListHolder extends RecyclerView.ViewHolder {
        public ImageView CatImage;

        //region CatListHolder
        public CatListHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            CatImage = itemView.findViewById(R.id.cat_image);
        }
        //endregion

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

    }

}
