package com.example.jh352160.new_demo.test4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jh352160 on 2016/9/5.
 */

public class PieView extends View{

    private Context context;
    private int[] mColor={0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080, 0xFFE6B800, 0xFF7CFC00};
    private float mStartAngle=0;
    private ArrayList<PieData> mData;
    private int mWidth,mHeight;
    private Paint mPaint=new Paint();

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public PieView(Context context) {
        this(context,null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mData==null){
            return;
        }
        float currentStartAngle=mStartAngle;
        canvas.translate(mWidth/2,mHeight/2);
        float r=(float)(Math.min(mWidth,mHeight)/2*0.8);
        RectF rect=new RectF(-r,-r,r,r);

        for (int i = 0; i < mData.size(); i++) {
            PieData pie=mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect,currentStartAngle,pie.getAngle(),true,mPaint);
            currentStartAngle+=pie.getAngle();
        }
    }

    public void setStartAngle(int mStartAngle){
        this.mStartAngle=mStartAngle;
        invalidate();
    }

    public void setData(ArrayList<PieData> mData){
        this.mData=mData;
        initDate(mData);
        invalidate();
    }

    private void initDate(ArrayList<PieData> mData){
        if(mData==null||mData.size()==0){
            return;
        }
        float sumValue=0;
        for (int i=0;i<mData.size();i++){
            PieData pie=mData.get(i);
            sumValue+=pie.getValue();
            int j=i%mColor.length;
            pie.setColor(mColor[j]);
        }
        float sumAngle=0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie=mData.get(i);
            float percentage=pie.getValue()/sumValue;
            float angle=percentage*360;
            pie.setPercentage(percentage);
            pie.setAngle(angle);
            sumAngle+=angle;
            Log.i("angle",""+pie.getAngle());
        }
    }
}
