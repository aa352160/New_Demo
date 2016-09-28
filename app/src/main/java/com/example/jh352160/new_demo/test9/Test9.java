package com.example.jh352160.new_demo.test9;

import android.content.Intent;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jh352160.new_demo.R;

import java.util.Iterator;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by jh352160 on 2016/9/27.
 */

public class Test9 extends AppCompatActivity{

    private TextView textView1,textView2;
    private Button button,button2,button3;
    private ProgressBar progressBar;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test9);
        progressBar=(ProgressBar)findViewById(R.id.progress1);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        button=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2) ;
        button3=(Button)findViewById(R.id.button3);
        imageView=(ImageView)findViewById(R.id.imageView);

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
                Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        Drawable drawable=getTheme().getDrawable(R.drawable.category_image5);
                        subscriber.onNext(drawable);
                        subscriber.onCompleted();
                    }
                }).subscribe(new Subscriber<Drawable>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Message","ImageView is OK");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Test9.this,"Error!!!!!!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                });
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test9.this,Test9_2.class));
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

    class CustomIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
