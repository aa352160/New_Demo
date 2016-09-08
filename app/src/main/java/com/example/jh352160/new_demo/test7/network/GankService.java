package com.example.jh352160.new_demo.test7.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jh352160 on 2016/8/23.
 */

public interface GankService {

    @GET("data/福利/{count}/{page}")
    Call<GankItem> getItem(
            @Path("count") int count,
            @Path("page") int page
    );

}
