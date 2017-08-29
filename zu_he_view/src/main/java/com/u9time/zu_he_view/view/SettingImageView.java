package com.u9time.zu_he_view.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.u9time.zu_he_view.R;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class SettingImageView extends RelativeLayout {

    private ImageView mImageView;

    public SettingImageView(Context context) {
        this(context, null);
    }

    public SettingImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        /**
         * 参数3:(这是addView的一个bug)要引起重视
         *      传null:不携带布局参数,直接返回view视图,需要进行手动的添加addView,也就是说item中的跟布局参数
         *          padding什么的完全没用
         *      传入this:将view中布局参数携带并且交给父类控件也就是this,此时是不需要addview的.
         */
        /*第一种方式*/
//        View view = View.inflate(getContext(), R.layout.view_setting_item, null);
//        view.setBackgroundResource(R.drawable.seting_first_selector);
//        addView(view);

        /*第二种方式*/
        View view = View.inflate(getContext(), R.layout.view_setting_item, this);
//        view.setBackgroundResource(R.drawable.seting_first_selector);/*背景无所谓在哪里加都可以*/

//        获取用户自定的属性值,例如int,boolean,string等
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.SettingImageView);
        int anInt = ta.getInt(R.styleable.SettingImageView_my_background, 1);
        int bg = 0;
        switch (anInt) {
            case 0:
                bg = R.drawable.seting_first_selector;
                break;
            default:
                bg = R.drawable.seting_middle_selector;
                break;
            case 2:
                bg = R.drawable.seting_last_selector;
                break;
        }
        view.setBackgroundResource(bg);

        String string = ta.getString(R.styleable.SettingImageView_my_title);
        TextView textView = (TextView) findViewById(R.id.view_tv_title);
        mImageView = (ImageView) findViewById(R.id.view_iv_toggle);
        textView.setText(string);

        isToggle = ta.getBoolean(R.styleable.SettingImageView_my_istoggle, false);
        setToggle(isToggle);

        ta.recycle();
    }

    //    使控件打开或者关闭
    public void toggle() {
        setToggle(!isToggle);
    }

    private boolean isToggle = false;

    //    改变控件的状态值
    public void setToggle(boolean isToggle) {
        mImageView.setImageResource(isToggle ? R.drawable.on : R.drawable.off);
        this.isToggle = isToggle;
    }

}
