package com.example.jh352160.new_demo.test2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jh352160.new_demo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by jh352160 on 2016/8/19.
 */

public class ListSeconde extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> imageUrlList;

    private static final int NETWORK_OK = 0;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case NETWORK_OK:
                    init();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_list_2);
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        //api
        Retrofit retrofit=ListRetrofit.getRetrofit();
        GankService gankService=retrofit.create(GankService.class);
        Call<GankItem> call=gankService.getItem(100,1);
        call.enqueue(new Callback<GankItem>() {
            @Override
            public void onResponse(Call<GankItem> call, Response<GankItem> response) {
                imageUrlList=new ArrayList<>();
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    imageUrlList.add(response.body().getResults().get(i).getUrl());
                }
                Message message=new Message();
                message.what=NETWORK_OK;
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(Call<GankItem> call, Throwable t) {

            }
        });
    }

    private void init(){
        ListSecondeAdapter adapter=new ListSecondeAdapter(this,imageUrlList);
        recyclerView.setAdapter(adapter);
    }
}
