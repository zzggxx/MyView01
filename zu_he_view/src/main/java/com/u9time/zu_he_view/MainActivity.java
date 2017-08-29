package com.u9time.zu_he_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.u9time.zu_he_view.view.SettingImageView;

/**
 * 组合控件的做法
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SettingImageView settingImageView = (SettingImageView) findViewById(R.id.setting1);
        settingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingImageView.toggle();
            }
        });
    }
}
