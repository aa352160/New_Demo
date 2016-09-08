package com.example.jh352160.new_demo.test4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jh352160.new_demo.R;

import java.util.ArrayList;

/**
 * Created by jh352160 on 2016/8/26
 */

public class Test4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);

        PieView pieView=(PieView)findViewById(R.id.pieView);
        pieView.setStartAngle(0);
        PieData pieData1=new PieData("1",100);
        PieData pieData2=new PieData("2",200);
        PieData pieData3=new PieData("3",300);
        PieData pieData4=new PieData("4",400);
        ArrayList<PieData> pieDatas=new ArrayList<>();
        pieDatas.add(pieData1);
        pieDatas.add(pieData2);
        pieDatas.add(pieData3);
        pieDatas.add(pieData4);
        pieView.setData(pieDatas);
    }

}
