package com.talabat.helpers;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.talabat.talabatcommon.R;
import java.util.ArrayList;

public class NoNetworkWaveAnimation extends RelativeLayout {
    private static final int DEFAULT_DURATION_TIME = 3000;
    private static final int DEFAULT_FILL_TYPE = 0;
    private static final int DEFAULT_RIPPLE_COUNT = 6;
    private static final float DEFAULT_SCALE = 6.0f;
    private boolean animationRunning = false;
    private ArrayList<Animator> animatorList;
    private AnimatorSet animatorSet;
    /* access modifiers changed from: private */
    public Paint paint;
    private int rippleAmount;
    private int rippleColor;
    private int rippleDelay;
    private int rippleDurationTime;
    private RelativeLayout.LayoutParams rippleParams;
    private float rippleRadius;
    private float rippleScale;
    /* access modifiers changed from: private */
    public float rippleStrokeWidth;
    private int rippleType;
    private ArrayList<RippleView> rippleViewList = new ArrayList<>();

    public class RippleView extends View {
        public RippleView(Context context) {
            super(context);
            setVisibility(4);
        }

        public void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, min - NoNetworkWaveAnimation.this.rippleStrokeWidth, NoNetworkWaveAnimation.this.paint);
        }
    }

    public NoNetworkWaveAnimation(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NoNetworkWaveAnimation);
                this.rippleColor = obtainStyledAttributes.getColor(0, getResources().getColor(com.talabat.R.color.rippelColor));
                this.rippleStrokeWidth = obtainStyledAttributes.getDimension(5, getResources().getDimension(com.talabat.R.dimen.rippleStrokeWidth));
                this.rippleRadius = obtainStyledAttributes.getDimension(2, getResources().getDimension(com.talabat.R.dimen.rippleRadius));
                this.rippleDurationTime = obtainStyledAttributes.getInt(1, 3000);
                this.rippleAmount = obtainStyledAttributes.getInt(3, 6);
                this.rippleScale = obtainStyledAttributes.getFloat(4, DEFAULT_SCALE);
                this.rippleType = obtainStyledAttributes.getInt(6, 0);
                obtainStyledAttributes.recycle();
                this.rippleDelay = this.rippleDurationTime / this.rippleAmount;
                Paint paint2 = new Paint();
                this.paint = paint2;
                paint2.setAntiAlias(true);
                if (this.rippleType == 0) {
                    this.rippleStrokeWidth = 0.0f;
                    this.paint.setStyle(Paint.Style.FILL);
                } else {
                    this.paint.setStyle(Paint.Style.STROKE);
                }
                this.paint.setColor(this.rippleColor);
                float f11 = this.rippleRadius;
                float f12 = this.rippleStrokeWidth;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f11 + f12) * 2.0f), (int) ((f11 + f12) * 2.0f));
                this.rippleParams = layoutParams;
                layoutParams.addRule(13, -1);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.animatorList = new ArrayList<>();
                for (int i11 = 0; i11 < this.rippleAmount; i11++) {
                    RippleView rippleView = new RippleView(getContext());
                    addView(rippleView, this.rippleParams);
                    this.rippleViewList.add(rippleView);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", new float[]{1.0f, this.rippleScale});
                    ofFloat.setRepeatCount(-1);
                    ofFloat.setRepeatMode(1);
                    ofFloat.setStartDelay((long) (this.rippleDelay * i11));
                    ofFloat.setDuration((long) this.rippleDurationTime);
                    this.animatorList.add(ofFloat);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", new float[]{1.0f, this.rippleScale});
                    ofFloat2.setRepeatCount(-1);
                    ofFloat2.setRepeatMode(1);
                    ofFloat2.setStartDelay((long) (this.rippleDelay * i11));
                    ofFloat2.setDuration((long) this.rippleDurationTime);
                    this.animatorList.add(ofFloat2);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", new float[]{1.0f, 0.0f});
                    ofFloat3.setRepeatCount(-1);
                    ofFloat3.setRepeatMode(1);
                    ofFloat3.setStartDelay((long) (this.rippleDelay * i11));
                    ofFloat3.setDuration((long) this.rippleDurationTime);
                    this.animatorList.add(ofFloat3);
                }
                this.animatorSet.playTogether(this.animatorList);
                return;
            }
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }
    }

    public NoNetworkWaveAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public NoNetworkWaveAnimation(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
