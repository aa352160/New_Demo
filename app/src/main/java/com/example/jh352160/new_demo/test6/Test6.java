package com.example.jh352160.new_demo.test6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/9/8.
 */

public class Test6 extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test6);

        textView=(TextView)findViewById(R.id.textView);
    }
}
