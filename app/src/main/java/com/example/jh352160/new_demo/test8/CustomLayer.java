package com.example.jh352160.new_demo.test8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jh352160 on 2016/9/21.
 */

public class CustomLayer extends View {

    Context context;

    public CustomLayer(Context context) {
        this(context,null);
    }

    public CustomLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint mPaint=new Paint();
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(150,150,100,mPaint);

        canvas.saveLayerAlpha(0,0,400,400,127,Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(200,200,100,mPaint);
        canvas.restore();
    }
}
