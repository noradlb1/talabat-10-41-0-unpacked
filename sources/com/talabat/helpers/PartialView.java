package com.talabat.helpers;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;

public class PartialView extends RelativeLayout {
    private ImageView mEmptyView;
    private ImageView mFilledView;

    public PartialView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ImageView imageView = new ImageView(getContext());
        this.mFilledView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView2 = new ImageView(getContext());
        this.mEmptyView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mFilledView);
        addView(this.mEmptyView);
        setEmpty();
    }

    public void setEmpty() {
        this.mFilledView.setImageLevel(0);
        this.mEmptyView.setImageLevel(10000);
    }

    public void setEmptyDrawable(Drawable drawable) {
        if (drawable.getConstantState() != null) {
            this.mEmptyView.setImageDrawable(new ClipDrawable(drawable.getConstantState().newDrawable(), GravityCompat.END, 1));
        }
    }

    public void setFilled() {
        this.mFilledView.setImageLevel(10000);
        this.mEmptyView.setImageLevel(0);
    }

    public void setFilledDrawable(Drawable drawable) {
        if (drawable.getConstantState() != null) {
            this.mFilledView.setImageDrawable(new ClipDrawable(drawable.getConstantState().newDrawable(), GravityCompat.START, 1));
        }
    }

    public void setPartialFilled(float f11) {
        int i11 = (int) ((f11 % 1.0f) * 10000.0f);
        if (i11 == 0) {
            i11 = 10000;
        }
        this.mFilledView.setImageLevel(i11);
        this.mEmptyView.setImageLevel(10000 - i11);
    }

    public PartialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PartialView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
