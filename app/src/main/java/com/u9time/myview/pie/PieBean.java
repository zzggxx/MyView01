package com.u9time.myview.pie;

/**
 * Created by Lenovo on 2017/8/29.
 */

public class PieBean {
    private float value;
    private int color;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public PieBean(float value, int color) {
        this.value = value;
        this.color = color;
    }
}
