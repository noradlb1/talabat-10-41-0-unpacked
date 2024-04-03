package com.talabat.designhelpers.CustomSquareProgree;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.talabat.R;
import com.talabat.designhelpers.CustomSquareProgree.Utils.CalculationUtil;
import com.talabat.designhelpers.CustomSquareProgree.Utils.PercentStyle;

public class SquareProgressBar extends RelativeLayout {
    private final SquareProgressView bar;
    private boolean greyscale;
    private boolean isFadingOnProgress = false;
    private boolean opacity = false;
    private boolean roundedCorners = false;

    public interface ProgressAnimationListener {
        void onAnimationFinish();

        void onAnimationProgress(int i11);

        void onAnimationStart();
    }

    public SquareProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.square_progress, this, true);
        SquareProgressView squareProgressView = (SquareProgressView) findViewById(R.id.square_progress_view);
        this.bar = squareProgressView;
        squareProgressView.bringToFront();
    }

    public void animateProgressTo(int i11, final int i12, final ProgressAnimationListener progressAnimationListener) {
        if (i11 != 0) {
            setProgress(i11);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "animateProgress", new float[]{(float) i11, (float) i12});
        ofFloat.setDuration(4750);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                SquareProgressBar.this.setProgress(i12);
                ProgressAnimationListener progressAnimationListener = progressAnimationListener;
                if (progressAnimationListener != null) {
                    progressAnimationListener.onAnimationFinish();
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ProgressAnimationListener progressAnimationListener = progressAnimationListener;
                if (progressAnimationListener != null) {
                    progressAnimationListener.onAnimationStart();
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Float) valueAnimator.getAnimatedValue()).intValue();
                if (((double) intValue) != SquareProgressBar.this.getProgress()) {
                    SquareProgressBar.this.setProgress(intValue);
                    ProgressAnimationListener progressAnimationListener = progressAnimationListener;
                    if (progressAnimationListener != null) {
                        progressAnimationListener.onAnimationProgress(intValue);
                    }
                }
            }
        });
        ofFloat.start();
    }

    public void drawCenterline(boolean z11) {
        this.bar.setCenterline(z11);
    }

    public void drawOutline(boolean z11) {
        this.bar.setOutline(z11);
    }

    public void drawStartline(boolean z11) {
        this.bar.setStartline(z11);
    }

    public PercentStyle getPercentStyle() {
        return this.bar.getPercentStyle();
    }

    public double getProgress() {
        return this.bar.getProgress();
    }

    public boolean isCenterline() {
        return this.bar.isCenterline();
    }

    public boolean isClearOnHundred() {
        return this.bar.isClearOnHundred();
    }

    public boolean isGreyscale() {
        return this.greyscale;
    }

    public boolean isIndeterminate() {
        return this.bar.isIndeterminate();
    }

    public boolean isOpacity() {
        return this.opacity;
    }

    public boolean isOutline() {
        return this.bar.isOutline();
    }

    public boolean isRoundedCorners() {
        return this.bar.isRoundedCorners();
    }

    public boolean isShowProgress() {
        return this.bar.isShowProgress();
    }

    public boolean isStartline() {
        return this.bar.isStartline();
    }

    public void setClearOnHundred(boolean z11) {
        this.bar.setClearOnHundred(z11);
    }

    public void setColor(String str) {
        this.bar.setColor(Color.parseColor(str));
    }

    public void setColorRGB(int i11, int i12, int i13) {
        this.bar.setColor(Color.rgb(i11, i12, i13));
    }

    public void setHoloColor(int i11) {
        this.bar.setColor(getContext().getResources().getColor(i11));
    }

    public void setIndeterminate(boolean z11) {
        this.bar.setIndeterminate(z11);
    }

    public void setOpacity(boolean z11) {
        this.opacity = z11;
        setProgress(this.bar.getProgress());
    }

    public void setPercentStyle(PercentStyle percentStyle) {
        this.bar.setPercentStyle(percentStyle);
    }

    public void setProgress(double d11) {
        this.bar.setProgress(d11);
    }

    public void setRoundedCorners(boolean z11) {
        this.bar.setRoundedCorners(z11, 10.0f);
    }

    public void setView() {
    }

    public void setWidth(int i11) {
        CalculationUtil.convertDpToPx((float) i11, getContext());
        this.bar.setWidthInDp(i11);
    }

    public void showProgress(boolean z11) {
        this.bar.setShowProgress(z11);
    }

    public void setColorRGB(int i11) {
        this.bar.setColor(i11);
    }

    public void setProgress(int i11) {
        setProgress((double) i11);
    }

    public void setRoundedCorners(boolean z11, float f11) {
        this.bar.setRoundedCorners(z11, f11);
    }

    public void setOpacity(boolean z11, boolean z12) {
        this.opacity = z11;
        this.isFadingOnProgress = z12;
        setProgress(this.bar.getProgress());
    }

    public void setProgress(int i11, int i12, ProgressAnimationListener progressAnimationListener) {
        animateProgressTo(i11, i12, progressAnimationListener);
    }

    public SquareProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.square_progress, this, true);
        SquareProgressView squareProgressView = (SquareProgressView) findViewById(R.id.square_progress_view);
        this.bar = squareProgressView;
        squareProgressView.bringToFront();
    }

    public SquareProgressBar(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.square_progress, this, true);
        SquareProgressView squareProgressView = (SquareProgressView) findViewById(R.id.square_progress_view);
        this.bar = squareProgressView;
        squareProgressView.bringToFront();
    }
}
