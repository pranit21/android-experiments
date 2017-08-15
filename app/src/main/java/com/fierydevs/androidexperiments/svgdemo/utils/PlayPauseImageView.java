package com.fierydevs.androidexperiments.svgdemo.utils;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.fierydevs.androidexperiments.R;

/**
 * Created by morep on 14-08-2017.
 */

public class PlayPauseImageView extends ImageView {
    private AnimatedVectorDrawable playToPause;
    private AnimatedVectorDrawable pauseToPlay;
    private boolean isPlayToPause;

    public PlayPauseImageView(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public PlayPauseImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public PlayPauseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
            isPlayToPause = false;
            playToPause = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.play_to_pause_animation);
            pauseToPlay = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.pause_to_play_animation);
            setImageDrawable(playToPause);
        }
    }

    public void morph() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable drawable
                    = isPlayToPause ? pauseToPlay : playToPause;
            setImageDrawable(drawable);
            drawable.start();
            isPlayToPause = !isPlayToPause;
        }
    }
}
