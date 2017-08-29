package com.u9time.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class PathCanvasView extends View {

    private Paint mPaint;
    private Path mPath;

    public PathCanvasView(Context context) {
        this(context,null);
    }

    public PathCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        /*创建路径*/
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*挪到的地方*/
//        mPath.moveTo(200,200);
//        /*中间画线,上一次结束的地方就是下一次开始的时候除非使用了moveTo*/
//        mPath.lineTo(100,200);
//        mPath.lineTo(100,300);
//        mPath.lineTo(200,300);
//        /*是否闭合path*/
////        mPath.close();
//        canvas.drawPath(mPath,mPaint);

        /*前边两点是相对原来的位置的结束点,后边两个是控制点*/
        /*连续绘制的时候就是接着上一次的位置继续画*/
        mPath.moveTo(100,100);
        mPath.quadTo(200,400,200,200);
        mPath.quadTo(200,400,300,300);
        /*mPath.quadTo(200,400,400,400);
        mPath.quadTo(200,400,500,500);
        mPath.quadTo(200,400,600,600);
        mPath.quadTo(200,400,700,700);*/
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
}
