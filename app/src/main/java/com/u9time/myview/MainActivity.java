package com.u9time.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.u9time.myview.pie.Pie;
import com.u9time.myview.pie.PieBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Pie mPie;
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bingTu();
    }

    private void bingTu() {
        mPie = (Pie) findViewById(R.id.pie);

        ArrayList<PieBean> pieBeanArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            pieBeanArrayList.add(new PieBean(i + 1, mColors[i]));
        }
        mPie.setDatas(pieBeanArrayList);
    }
}
