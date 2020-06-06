package com.example.listcattest.retrofit;

import android.app.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.listcattest.R;
import com.example.listcattest.adapter.CatListAdapter;
import com.example.listcattest.model.CatResponse;
import com.example.listcattest.model.DataItem;
import com.example.listcattest.model.Images;
import com.example.listcattest.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImgurConfig {

    private RecyclerView recyclerView;
    private CatListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Activity activity;

    //region ImgurConfig
    public ImgurConfig(MainActivity activity) {
        this.activity = activity;
    }
    //endregion

    //region getListImgurRetrofit
    public void getListImgurRetrofit() {

        Call<CatResponse> call = new RetrofitConfig().getApiService().getPhoto();

        call.enqueue(new Callback<CatResponse>() {
            @Override
            public void onResponse(Call<CatResponse> call, Response<CatResponse> response) {
                ArrayList<Images> imagesList = new ArrayList<>();
                List<DataItem> dataItem = response.body().getData();

                for (int i = 0; i < dataItem.size(); i++) {
                    final DataItem dItem = dataItem.get(i);
                    if (dItem.getImages() != null) {
                        for (int j = 0; j < dataItem.get(i).getImages().size(); j++) {
                            imagesList.add(dataItem.get(i).getImages().get(j));
                        }
                    }
                }
                buildRecyclerView(imagesList);

            }

            @Override
            public void onFailure(Call<CatResponse> call, Throwable t) {

            }
        });
    }
    //endregion

    //region buildRecyclerView
    private void buildRecyclerView(ArrayList<Images> imageList) {
        recyclerView = activity.findViewById(R.id.recyclerViewCat);
        recyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(4,1);

        adapter = new CatListAdapter(imageList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    //endregion

}
