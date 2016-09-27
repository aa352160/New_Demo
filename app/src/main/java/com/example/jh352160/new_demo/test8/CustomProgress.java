package com.example.jh352160.new_demo.test8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jh352160 on 2016/9/26.
 */

public class CustomProgress extends View {

    public CustomProgress(Context context) {
        super(context);
    }

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //对于部分混合规则，需要关闭硬件加速才可以显示出效果
        this.setLayerType(LAYER_TYPE_SOFTWARE,null);

        //设置背景色
        canvas.drawARGB(255, 139, 197, 186);

        int canvasWidth=canvas.getWidth()/3;
        int canvasHeight =canvas.getHeight();
        int layerId=canvas.saveLayer(0,0,canvasWidth,canvasHeight,null,Canvas.ALL_SAVE_FLAG);
        Paint paint=new Paint();

        int r = canvasWidth / 3;
        //正常绘制黄色的圆形
        paint.setColor(0xFFFFCC44);
        canvas.drawCircle(r, r, r, paint);
        //使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        paint.setColor(0xFF66AAFF);
        canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);
        //最后将画笔去除Xfermode
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
