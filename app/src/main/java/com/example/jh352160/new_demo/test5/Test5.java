package com.example.jh352160.new_demo.test5;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jh352160.new_demo.R;
import com.example.jh352160.new_demo.databinding.Test5Binding;

/**
 * Created by jh352160 on 2016/9/5.
 */

public class Test5 extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Test5Binding bingding= DataBindingUtil.setContentView(this, R.layout.test5);
        User user=new User("firstname","lastname");
        bingding.setUser(user);
    }
}
