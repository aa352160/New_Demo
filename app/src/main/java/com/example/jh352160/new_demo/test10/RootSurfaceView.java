package com.example.jh352160.new_demo.test10;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/11.
 */

public class RootSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private float mViewWidth = 0;
    private float mViewHeight = 0;
    private int mResourceId = 0;
    private Context mContext = null;
    private volatile boolean isRunning = false;
    private SurfaceHolder mSurfaceHolder = null;

    public RootSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRootSurfaceView(context, attrs, 0, 0);
    }

    public RootSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initRootSurfaceView(context, attrs, defStyleAttr, 0);
    }

    private void initRootSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RootSurfaceView, defStyleAttr, defStyleRes);
        int n = a.length();
        mViewWidth = displayMetrics.widthPixels;
        mViewHeight = displayMetrics.heightPixels;
        for (int index = 0; index < n; index++) {
            int attr = a.getIndex(index);
            switch (attr) {
                case R.styleable.RootSurfaceView_background:
                    //mResourceId = a.getResourceId(attr, R.drawable.category_image5);
                    //mResourceId = getResources().getDrawable(R.drawable.category_image5);
                    break;
                case R.styleable.RootSurfaceView_view_height:
                    mViewHeight = a.getDimension(attr, displayMetrics.heightPixels);
                    break;
                case R.styleable.RootSurfaceView_view_width:
                    mViewWidth = a.getDimension(attr, displayMetrics.widthPixels);
                    break;
            }
        }
        a.recycle();
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
    }

    private Bitmap getDrawBitmap(Context context, float width, float height) {
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),mResourceId);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.category_image5);
        Bitmap resultBitmap = zoomImage(bitmap, width, height);
        return resultBitmap;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawBackGround(holder);
        System.out.println("RootSurfaceView surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        System.out.println("RootSurfaceView surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
        System.out.println("RootSurfaceView surfaceDestroyed");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        System.out.println("RootSurfaceView onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        System.out.print("RootSurfaceView onDetachedFromWindow");
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (mSurfaceHolder) {
                if (!mSurfaceHolder.getSurface().isValid()) {
                    continue;
                }
                drawBackGround(mSurfaceHolder);
            }
            isRunning = false;
            break;
        }
    }

    private void drawBackGround(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        Bitmap bitmap = getDrawBitmap(mContext, mViewWidth, mViewHeight);
        canvas.drawBitmap(bitmap, 0, 0, null);
        bitmap.recycle();
        holder.unlockCanvasAndPost(canvas);
    }

    public static Bitmap zoomImage(Bitmap bgimage, float newWidth, float newHeight) {
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width, (int) height, matrix, true);
        if (bitmap != bgimage) {
            bgimage.recycle();
            bgimage = null;
        }
        return bitmap;
    }
}
