package com.fierydevs.androidexperiments.svgdemo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.fierydevs.androidexperiments.R;
import com.fierydevs.androidexperiments.svgdemo.utils.HeartImageView;
import com.fierydevs.androidexperiments.svgdemo.utils.PlayPauseImageView;
import com.fierydevs.androidexperiments.svgdemo.utils.SmilingSadFaceImageView;

public class SvgDemoActivity extends AppCompatActivity {
    private PlayPauseImageView svg;
    private SmilingSadFaceImageView svg_1;
    private HeartImageView svg_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_demo);

        svg = (PlayPauseImageView) findViewById(R.id.svg);
        svg_1 = (SmilingSadFaceImageView) findViewById(R.id.svg_1);
        svg_2 = (HeartImageView) findViewById(R.id.svg_2);

        svg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svg.morph();
            }
        });
        svg_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svg_1.morph();
            }
        });
        svg_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svg_2.morph();
            }
        });
    }
}
