package com.example.jh352160.new_demo.util;

import android.app.Application;

/**
 * Created by jh352160 on 2016/10/10.
 */

public class CommonApplication extends Application {

    private static final String VALUE="Harvey";
    private String value;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setValue(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
