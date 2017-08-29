package com.u9time.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class CanvasTestView extends View {
    private static final String TAG = "CanvasTestView";
    private Paint mPaint;

    public CanvasTestView(Context context) {
//        super(context);
        this(context, null);
    }

    public CanvasTestView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public CanvasTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Log.i(TAG, "init: ");
        //在这里初始化画笔
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

    }

    /*点的封装类*/
    /*face*/
    private PointF facePoint = new PointF(240, 400);
    private int faceRadius = 200;

    /*eyesLine*/
    private PointF line1Start = new PointF(140, 250);
    private PointF line1End = new PointF(340, 250);
    private PointF line2Start = new PointF(240, 250);
    private PointF line2End = new PointF(240, 500);
    private PointF line3End = new PointF(150, 450);

    /*eyes*/
    private PointF eye1Point = new PointF(170, 330);
    private PointF eye2Point = new PointF(310, 330);
    private int eyeRadius = 50;

    /*mouth*/
    private RectF mouth = new RectF(60, 300, 420, 550);
    private float startAngle = 380f;
    private float sweepAngle = 140f;

    private float[] points = new float[]{10f,20f,30f,40f,50f,60f,70f,80f,90f,100f};

    /**
     * 绘制阶段调用的方法,性能方面的问题
     *
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*绘制圆形,参数自己查看即可知道,多了怎么办呢,使用点的封装*/
//        canvas.drawCircle(240,400,200,mPaint);
        /*绘制脸*/
        canvas.drawCircle(facePoint.x, facePoint.y, faceRadius, mPaint);

        /*绘制线段,绘制眉毛和鼻子*/
        canvas.drawLine(line1Start.x, line1Start.y, line1End.x, line1End.y, mPaint);
        canvas.drawLine(line2Start.x, line2Start.y, line2End.x, line2End.y, mPaint);
        canvas.drawLine(line2End.x, line2End.y, line3End.x, line3End.y, mPaint);

        /*绘制两只眼睛*/
        canvas.drawCircle(eye1Point.x, eye1Point.y, eyeRadius, mPaint);
        canvas.drawCircle(eye2Point.x, eye2Point.y, eyeRadius, mPaint);

        /*绘制嘴*/
        //参数1:rectf:矩形,圆弧外接的矩形
        //参数2:弧的起始角度
        //参数3:弧度
        //参数4:弧度还是扇形
        //参数5:canvas
        canvas.drawArc(mouth, startAngle, sweepAngle, false, mPaint);

        /*绘制rectangle*/
//        canvas.drawRect(mouth, mPaint);

        /*点的绘制*/
//        canvas.drawPoints(points,2,10,mPaint);

        /*自己可以研究图片等画法*/
    }
}
