package com.example.jh352160.new_demo.test9;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jh352160.new_demo.R;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jh352160 on 2016/9/27.
 */

public class Test9 extends AppCompatActivity{

    private TextView textView1,textView2;
    private Button button,button2;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test9);
        progressBar=(ProgressBar)findViewById(R.id.progress1);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        button=(Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask dTask=new DownloadTask();
                dTask.execute(100);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class DownloadTask extends AsyncTask<Integer,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {
            for (int i = 0; i <= 100; i++) {
                progressBar.setProgress(i);
                publishProgress(i);

                try {
                    Thread.sleep(params[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "执行完毕";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView2.setText(values[0]+"");
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            textView1.setText(s);
            super.onPostExecute(s);
        }
    }
}
