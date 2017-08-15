package com.fierydevs.androidexperiments.svgdemo.utils;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.fierydevs.androidexperiments.R;

/**
 * Created by morep on 15-08-2017.
 */

public class SmilingSadFaceImageView extends ImageView {
    private AnimatedVectorDrawable smilingToSad;
    private AnimatedVectorDrawable sadToSmiling;
    private boolean isSmilingToSad;

    public SmilingSadFaceImageView(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public SmilingSadFaceImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public SmilingSadFaceImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    /*public PlayPauseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

    public void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            isSmilingToSad = false;
            smilingToSad = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.smiling_to_sad);
            sadToSmiling = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.sad_to_smiling);
            setImageDrawable(smilingToSad);
        }
    }

    public void morph() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable drawable
                    = isSmilingToSad ? sadToSmiling : smilingToSad;
            setImageDrawable(drawable);
            drawable.start();
            isSmilingToSad = !isSmilingToSad;
        }
    }
}
