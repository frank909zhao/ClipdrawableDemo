package com.frank.clipdrawabledemo;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv_info)
    TextView mTvShow;
    @InjectView(R.id.iv_show)
    ImageView mImageShow;
    @InjectView(R.id.seekbar)
    SeekBar mSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int max = seekBar.getMax();
                double scale = (double)progress/(double)max;
                ClipDrawable drawable = (ClipDrawable) mImageShow.getBackground();
                drawable.setLevel((int) (10000*scale));
                mTvShow.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
