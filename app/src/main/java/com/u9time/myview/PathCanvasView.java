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
        mPath.moveTo(200,200);
        /*中间画线*/
        mPath.lineTo(100,200);
        mPath.lineTo(100,300);
        mPath.lineTo(200,300);
        /*是否闭合path*/
//        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
}
