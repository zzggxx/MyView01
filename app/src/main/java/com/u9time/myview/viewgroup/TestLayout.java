package com.u9time.myview.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.u9time.myview.R;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class TestLayout extends ViewGroup {
    public TestLayout(Context context) {
        this(context, null);
    }

    public TestLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
            addView(imageView);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        /*横向排列*/
//        for (int i = 0; i < getChildCount(); i++) {
//            getChildAt(i).layout(60 * i, 0, 60 * (i + 1), 60);
//        }
        /*竖向排列*/
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(0, 60 * i, 60, 60 * (i + 1));
        }
    }
}
