package com.example.jh352160.new_demo.test10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.jh352160.new_demo.R;
import com.example.jh352160.new_demo.test10.massager.MessengerActivity;
import com.example.jh352160.new_demo.test10.network.Test10_2;

import rx.Observable;

/**
 * Created by jh352160 on 2016/9/30.
 */

public class Test10 extends AppCompatActivity {

    Button button,button2,button3;
    EditText editText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test10);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        editText=(EditText)findViewById(R.id.editText);

        editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestData testData=new TestData(10,"123456789",false);

                Intent intent=new Intent(Test10.this,Test10_2.class);
                intent.putExtra("testData",testData);

                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager=(InputMethodManager)Test10.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Test10.this,MessengerActivity.class);
                startActivity(intent);
            }
        });

        Observable.range(1,2);
    }

}
