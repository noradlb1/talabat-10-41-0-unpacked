package com.talabat.helpers;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.talabat.designhelpers.Utils;

public class SliderAnimationEffect extends Animation {
    public static final int COLLAPSE = 1;
    public static final int EXPAND = 0;
    private int mEndHeight;
    private LinearLayout.LayoutParams mLayoutParams;
    private int mType;
    private View mView;

    public SliderAnimationEffect(View view, int i11, int i12) {
        setDuration((long) i11);
        this.mView = view;
        this.mEndHeight = Utils.dpToPixel(36, view.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.mLayoutParams = layoutParams;
        this.mType = i12;
        if (i12 == 0) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = Utils.dpToPixel(36, this.mView.getContext());
        }
        view.setVisibility(0);
    }

    public void applyTransformation(float f11, Transformation transformation) {
        super.applyTransformation(f11, transformation);
        if (f11 < 1.0f) {
            if (this.mType == 0) {
                this.mLayoutParams.height = (int) (((float) this.mEndHeight) * f11);
            } else {
                this.mLayoutParams.height = (int) (((float) this.mEndHeight) * (1.0f - f11));
            }
            this.mView.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.height = Utils.dpToPixel(36, this.mView.getContext());
            this.mView.requestLayout();
        } else {
            this.mView.setVisibility(8);
        }
    }

    public int getHeight() {
        return this.mView.getHeight();
    }

    public void setHeight(int i11) {
        this.mEndHeight = i11;
    }
}
