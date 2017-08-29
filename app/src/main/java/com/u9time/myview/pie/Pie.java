package com.u9time.myview.pie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * 需求:饼状图
 * 步骤分解:
 * 1,最内侧扇形组成的圆形区域的绘制
 * 2,中间短线的绘制
 * 3,最外侧文本的绘制
 * <p>
 * Created by Lenovo on 2017/8/29.
 */

public class Pie extends View {
    private ArrayList<PieBean> mPieBeanArrayList;
    private int width;
    private int heigth;
    private Paint mPaint;
    private Path mPath;
    private float totalValue;
    private int mRadius;
    private Paint mLinePaint;

    public Pie(Context context) {
        this(context, null);
    }

    public Pie(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Pie(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //    定义扇形组成圆形的外接圆形
    private RectF rectF;

    private void init() {
        rectF = new RectF();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPath = new Path();

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.BLACK);
        /*以下两者互不影响*/
        mLinePaint.setStrokeWidth(4);
        mLinePaint.setTextSize(40);
    }

    //当自定控件的尺寸定好了的时候调用,就是xml布局中的
    //若是包裹性的布局可需要注意了.
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.heigth = h;
//        取小值做半径
        int min = Math.min(w, h);
        mRadius = (int) (min * 0.7f / 2);
        rectF.left = -mRadius;
        rectF.top = -mRadius;
        rectF.right = mRadius;
        rectF.bottom = mRadius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(width / 2, heigth / 2);
//        对扇形的绘制处理
        drawPie(canvas);
        canvas.restore();
    }

    private void drawPie(Canvas canvas) {
        float startAngle = 0;
        for (int i = 0; i < mPieBeanArrayList.size(); i++) {

            mPaint.setColor(mPieBeanArrayList.get(i).getColor());

            mPath.moveTo(0, 0);

//            扇形区域角度,加一减一就是为了中间的空隙
            float swipeAngle =
                    mPieBeanArrayList.get(i).getValue() / totalValue * 360 - 1;
            mPath.arcTo(rectF, startAngle, swipeAngle);

            canvas.drawPath(mPath, mPaint);

//            画外面多出来的延长线
            double a = Math.toRadians(startAngle + swipeAngle / 2);
            float startX = (float) (mRadius * Math.cos(a));
            float startY = (float) (mRadius * Math.sin(a));
            float endX = (float) ((mRadius + 30) * Math.cos(a));
            float endY = (float) ((mRadius + 30) * Math.sin(a));
            canvas.drawLine(startX, startY, endX, endY, mLinePaint);

//            改变每一次的起始角度
            startAngle += swipeAngle + 1;

//            在每次绘制完毕,path必须要进行重置,清除上一次相关记录
            mPath.reset();

//            绘制文本是以左下角为基准点的,其他都是左上角的.
            String persent = String.format("%.1f",
                    mPieBeanArrayList.get(i).getValue() / totalValue * 100);
            persent = persent + "%";
            if (startAngle % 360f >= 90 && startAngle % 360f <= 270) {
                float measureText = mLinePaint.measureText(persent);
                canvas.drawText(persent, endX - measureText, endY, mLinePaint);
            } else {
                canvas.drawText(persent, endX, endY, mLinePaint);
            }

        }
    }

    public void setDatas(ArrayList<PieBean> pieBeanArrayList) {
        this.mPieBeanArrayList = pieBeanArrayList;
        for (PieBean pieBean : pieBeanArrayList) {
            totalValue += pieBean.getValue();
        }
    }
}
