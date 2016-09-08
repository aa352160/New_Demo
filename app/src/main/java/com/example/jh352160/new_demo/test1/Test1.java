package com.example.jh352160.new_demo.test1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/8/18.
 */

public class Test1 extends AppCompatActivity implements View.OnClickListener{

    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        //绑定控件
        button1=(Button)findViewById(R.id.button1);

        //绑定点击事件
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                MyToast myToast=new MyToast();
                myToast.Short(Test1.this,"自定义message字体，背景色").setToastColor(Color.WHITE,getResources().getColor(R.color.colorAccent)).show();
                break;
        }
    }
}
