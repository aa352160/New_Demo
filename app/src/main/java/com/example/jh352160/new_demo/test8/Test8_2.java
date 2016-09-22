package com.example.jh352160.new_demo.test8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/9/22.
 */

public class Test8_2 extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test8_2);
        imageView=(ImageView)findViewById(R.id.imageView);
    }
}
