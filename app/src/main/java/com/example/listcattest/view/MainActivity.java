package com.example.listcattest.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.listcattest.R;
import com.example.listcattest.retrofit.ImgurConfig;


public class MainActivity extends AppCompatActivity {


    ImgurConfig imgurConfig;

    //region ONCREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imgurConfig = new ImgurConfig(this);
        imgurConfig.getListImgurRetrofit();


    }
    //endregion

}
