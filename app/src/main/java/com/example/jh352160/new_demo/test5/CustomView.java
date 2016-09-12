package com.example.jh352160.new_demo.test5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jh352160 on 2016/9/12.
 */

public class CustomView extends View {

    int mRectCount=5;
    int mWidth;
    int offset=100;
    int mRectWidth;
    int mRectHeight=2000;
    Paint mPaint;
    LinearGradient mLinearGradient;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            double mRandom=Math.random();
            float currectHeight=(float)(mRectHeight*mRandom);
            canvas.drawRect(
                    (float)(mWidth*0.4/2+mRectWidth*i+offset),
                    currectHeight,
                    (float)(mWidth*0.4/2+mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=getWidth();
        mRectHeight=getHeight();
        mRectWidth=(int)(mWidth*0.6/mRectCount);
        mLinearGradient=new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }
}
