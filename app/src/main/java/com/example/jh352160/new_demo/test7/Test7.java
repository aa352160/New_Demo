package com.example.jh352160.new_demo.test7;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jh352160.new_demo.R;
import com.example.jh352160.new_demo.test7.network.CommonRetrofit;
import com.example.jh352160.new_demo.test7.network.GankItem;
import com.example.jh352160.new_demo.test7.network.GankService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by jh352160 on 2016/9/6
 */

public class Test7 extends AppCompatActivity {

    Button button,button1;
    CustomSwitchView customSwitchView;
    List<String> allImageUrlList;

    private static final int NETWORK_OK = 0;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case NETWORK_OK:
                    customSwitchView.changeData(allImageUrlList);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test7);

        button = (Button) findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        customSwitchView=(CustomSwitchView)findViewById(R.id.customSwitchView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customSwitchView.switchView();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit= CommonRetrofit.getRetrofit();
                GankService gankService=retrofit.create(GankService.class);
                Call<GankItem> call=gankService.getItem(100,2);
                call.enqueue(new Callback<GankItem>() {
                    @Override
                    public void onResponse(Call<GankItem> call, Response<GankItem> response) {
                        allImageUrlList =new ArrayList<>();
                        for (int i = 0; i < response.body().getResults().size(); i++) {
                            allImageUrlList.add(response.body().getResults().get(i).getUrl());
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
        });

    }

}