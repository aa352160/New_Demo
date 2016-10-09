package com.example.jh352160.new_demo.test10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/8.
 */

public class Test10_2 extends AppCompatActivity{

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test10_2);

        Intent intent=getIntent();
        TestData testData=(TestData)intent.getParcelableExtra("testData");

        Log.i("this is name",testData.userName);

    }
}
