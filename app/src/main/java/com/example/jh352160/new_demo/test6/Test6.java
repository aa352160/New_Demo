package com.example.jh352160.new_demo.test6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/9/8.
 */

public class Test6 extends AppCompatActivity{

    private View view;
    int lastX,lastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test6);

        view=(View)findViewById(R.id.drag_view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int rawX=(int)(event.getRawX());
                int rawY=(int)(event.getRawY());
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        lastX=rawX;
                        lastY=rawY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int offsetX=rawX-lastX;
                        int offsetY=rawY-lastY;
//                        view.layout(view.getLeft()+offsetX,view.getTop()+offsetY,view.getRight()+offsetX,view.getBottom()+offsetY);
                        view.layout(0,0,view.getRight()+offsetX,view.getBottom()+offsetY);
                        lastX=rawX;
                        lastY=rawY;
                        break;
                }
                return true;
            }
        });
    }

}
