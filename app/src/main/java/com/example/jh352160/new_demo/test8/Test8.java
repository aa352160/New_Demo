package com.example.jh352160.new_demo.test8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/9/20.
 */

public class Test8 extends AppCompatActivity{

    private Button button,button2,button3;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test8);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        imageView=(ImageView)findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap1= BitmapFactory.decodeResource(Test8.this.getResources(),R.drawable.category_image5);
                imageView.setImageBitmap(handleImageNegative(bitmap1,1));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap1= BitmapFactory.decodeResource(Test8.this.getResources(),R.drawable.category_image5);
                imageView.setImageBitmap(handleImageNegative(bitmap1,2));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap1= BitmapFactory.decodeResource(Test8.this.getResources(),R.drawable.category_image5);
                imageView.setImageBitmap(bitmap1);
            }
        });
    }

    public Bitmap handleImageNegative(Bitmap bm,int type){
        int width=bm.getWidth();
        int height=bm.getHeight();
        int color;
        int r,g,b,a;

        Bitmap bmp=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);

        int[] oldPx=new int[width*height];
        int[] newPx=new int[width*height];
        bm.getPixels(oldPx,0,width,0,0,width,height);
        for (int i = 0; i < width * height; i++) {
            color=oldPx[i];
            r= Color.red(color);
            g= Color.green(color);
            b= Color.blue(color);
            a= Color.alpha(color);

            if (type==1) {
//            底片效果
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
            }else if (type==2) {
//            老照片效果
                r = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                g = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                b = (int) (0.272 * r + 0.534 * g + 0.131 * b);
            }

            if (r>255){
                r=255;
            }else if(r<0){
                r=0;
            }

            if (g>255){
                g=255;
            }else if(g<0){
                g=0;
            }

            if (b>255){
                b=255;
            }else if(b<0){
                b=0;
            }
            newPx[i]=Color.argb(a,r,g,b);
        }
        bmp.setPixels(newPx,0,width,0,0,width,height);
        return bmp;
    }

}
