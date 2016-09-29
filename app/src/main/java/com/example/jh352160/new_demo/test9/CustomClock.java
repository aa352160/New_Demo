package com.example.jh352160.new_demo.test9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/9/21.
 */

public class CustomClock extends View{

    Context context;
    int minut=1,hour=1;
    int mWidth,mHeight;
    boolean haveContent=false;

    public CustomClock(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public CustomClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init(){
        haveContent=false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        mWidth=display.getWidth();
        mHeight=display.getHeight();

        canvas.save();

        //绘制外边圆
        Paint paintCircle=new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        paintCircle.setColor(getResources().getColor(R.color.black));
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,paintCircle);

        //绘制刻度与时间
        Paint paintDegree=new Paint();
        for (int i=0;i<24;i++){
            paintDegree.setStrokeWidth(5);
            if (i==0||i==6||i==12||i==18) {
                paintDegree.setTextSize(30);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2,mWidth/2,mHeight/2-mWidth/2+60,paintDegree);
                canvas.drawText(i+"",mWidth/2-paintDegree.measureText(i+"")/2,mHeight/2-mWidth/2+90,paintDegree);
            }else{
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(mWidth/2,mHeight/2-mWidth/2,mWidth/2,mHeight/2-mWidth/2+30,paintDegree);
                canvas.drawText(i+"",mWidth/2-paintDegree.measureText(i+"")/2,mHeight/2-mWidth/2+60,paintDegree);
            }
            canvas.rotate(15,mWidth/2,mHeight/2);
        }
        drawHands(canvas);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (minut<60) {
            minut++;
        }else{
            hour++;
            minut=1;
        }
        canvas.restore();
        invalidate();
    }

    private void drawHands(Canvas canvas){
        //画指针
        Paint paintHour=new Paint();
        paintHour.setStrokeWidth(20);
        Paint paintMinute=new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate(mWidth/2,mHeight/2);

        canvas.drawLine(0,0,(float) (200*(Math.cos(Math.PI*2*(hour/24.0)))),(float) (200*(Math.sin(Math.PI*2*(hour/24.0)))),paintHour);
        canvas.drawLine(0,0,(float) (350*(Math.cos(Math.PI*2*(minut/60.0)))),(float) (350*(Math.sin(Math.PI*2*(minut/60.0)))),paintMinute);
        canvas.restore();
    }

    public void setTime(int hour,int minute){
        this.hour=hour;
        this.minut=minute;
    }
}
