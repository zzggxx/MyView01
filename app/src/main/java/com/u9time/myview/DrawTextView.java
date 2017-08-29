package com.u9time.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class DrawTextView extends View {

    private Paint mPaint;

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(80);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrikeThruText(true);
        mPaint.setFakeBoldText(true);
        mPaint.setUnderlineText(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextScaleX(1.5f);
    }

    private String text = "我是中国人";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, 200, 400, mPaint);
    }
}
