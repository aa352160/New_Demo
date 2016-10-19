package com.example.jh352160.new_demo.test11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/13.
 */

public class Test11 extends AppCompatActivity {

    TextView textView,textView2,textView3;
    ScoreView scoreView,scoreView2,scoreView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test11);

        scoreView=(ScoreView)findViewById(R.id.scoreView);
        scoreView2=(ScoreView)findViewById(R.id.scoreView2);
        scoreView3=(ScoreView)findViewById(R.id.scoreView3);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        float i=scoreView.getScore();
        textView.setText(""+i);

        scoreView.setHaveHalf(true);
        scoreView.setStar(6);
        scoreView.setScore(0.5f);
        scoreView.setScoreChangeListener(new ScoreView.ScoreChangeListener() {
            @Override
            public void scoreChange() {
                textView.setText(scoreView.getScore()+"");
            }
        });

        scoreView2.setHaveHalf(false);
        scoreView2.setStar(6);
        scoreView2.setScore(3);
        scoreView2.isEnable(false);
        scoreView2.setScoreChangeListener(new ScoreView.ScoreChangeListener() {
            @Override
            public void scoreChange() {
                textView2.setText(scoreView2.getScore()+"");
            }
        });

        scoreView3.setHaveHalf(false);
        scoreView3.setStar(3);
        scoreView3.setStarSize(200);
        scoreView3.setScoreChangeListener(new ScoreView.ScoreChangeListener() {
            @Override
            public void scoreChange() {
                textView3.setText(scoreView3.getScore()+"");
            }
        });
    }

}
