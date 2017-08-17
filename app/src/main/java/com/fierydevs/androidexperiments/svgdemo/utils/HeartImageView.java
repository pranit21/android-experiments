package com.fierydevs.androidexperiments.svgdemo.utils;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.fierydevs.androidexperiments.R;

/**
 * Created by morep on 17-08-2017.
 */

public class HeartImageView extends ImageView {
    private AnimatedVectorDrawable favoriteToUnfavorite;
    private AnimatedVectorDrawable unfavoriteToFavorite;
    private boolean isFavoriteToUnfavorite;

    public HeartImageView(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public HeartImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public HeartImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            init();
        }
    }

    public void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            isFavoriteToUnfavorite = false;
            favoriteToUnfavorite = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.make_favorite_target);
            unfavoriteToFavorite = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.make_unfavorite_target);
            setImageDrawable(favoriteToUnfavorite);
        }
    }

    public void morph() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable drawable
                    = isFavoriteToUnfavorite ? unfavoriteToFavorite : favoriteToUnfavorite;
            setImageDrawable(drawable);
            drawable.start();
            isFavoriteToUnfavorite = !isFavoriteToUnfavorite;
        }
    }
}
