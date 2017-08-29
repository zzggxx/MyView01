package com.u9time.myview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class CanvasTestView extends View {
    private static final String TAG = "CanvasTestView";

    public CanvasTestView(Context context) {
//        super(context);
        this(context,null);
    }

    public CanvasTestView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs,0);
    }

    public CanvasTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Log.i(TAG, "init: ");
    }
}
