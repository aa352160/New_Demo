package com.example.jh352160.new_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jh352160.new_demo.test1.Test1;
import com.example.jh352160.new_demo.test2.Test2;
import com.example.jh352160.new_demo.test3.Test3;
import com.example.jh352160.new_demo.test4.Test4;
import com.example.jh352160.new_demo.test5.Test5;
import com.example.jh352160.new_demo.test6.Test6;
import com.example.jh352160.new_demo.test7.Test7;
import com.example.jh352160.new_demo.test8.Test8;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4,button5,button6,button7,button8,button9,button10,button11,button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(MainActivity.this, Test1.class);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this, Test2.class);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this, Test3.class);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this, Test4.class);
                break;
            case R.id.button5:
                intent = new Intent(MainActivity.this, Test5.class);
                break;
            case R.id.button6:
                intent = new Intent(MainActivity.this, Test6.class);
                break;
            case R.id.button7:
                intent = new Intent(MainActivity.this, Test7.class);
                break;
            case R.id.button8:
                intent = new Intent(MainActivity.this, Test8.class);
                break;
            case R.id.button9:
                intent = new Intent(MainActivity.this, Test8.class);
                break;
            case R.id.button10:
                intent = new Intent(MainActivity.this, Test8.class);
                break;
            case R.id.button11:
                intent = new Intent(MainActivity.this, Test8.class);
                break;
            case R.id.button12:
                intent = new Intent(MainActivity.this, Test8.class);
                break;
        }
        MainActivity.this.startActivity(intent);
    }

}
