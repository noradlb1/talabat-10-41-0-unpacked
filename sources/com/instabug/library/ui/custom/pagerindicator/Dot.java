package com.instabug.library.ui.custom.pagerindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.view.ViewUtils;

public final class Dot extends RelativeLayout {
    private static final int DEFAULT_ACTIVE_COLOR = -1;
    private static final int DEFAULT_ACTIVE_DIAMETER_DP = 9;
    private static final int DEFAULT_INACTIVE_COLOR = -1;
    private static final int DEFAULT_INACTIVE_DIAMETER_DP = 6;
    private static final boolean DEFAULT_INITIALLY_ACTIVE = false;
    private static final int DEFAULT_TRANSITION_DURATION_MS = 200;
    private int activeColor;
    private int activeDiameterPx;
    /* access modifiers changed from: private */
    @Nullable
    public AnimatorSet currentAnimator;
    private ImageView drawableHolder;
    private int inactiveColor;
    private int inactiveDiameterPx;
    private ShapeDrawable shape;
    /* access modifiers changed from: private */
    @Nullable
    public State state;
    private int transitionDurationMs;

    public enum State {
        INACTIVE(true, (int) null, (boolean) null),
        ACTIVE(true, (int) null, (boolean) null),
        TRANSITIONING_TO_ACTIVE(false, r7, r0),
        TRANSITIONING_TO_INACTIVE(false, r0, r7);
        
        @Nullable
        private final State from;
        private final boolean isStable;
        @Nullable

        /* renamed from: to  reason: collision with root package name */
        private final State f51973to;

        private State(boolean z11, @Nullable State state, @Nullable State state2) {
            this.isStable = z11;
            this.f51973to = state;
            this.from = state2;
        }

        public boolean isStable() {
            return this.isStable;
        }

        @Nullable
        public State transitioningFrom() {
            return this.from;
        }

        @Nullable
        public State transitioningTo() {
            return this.f51973to;
        }
    }

    public Dot(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateDotChange(int i11, int i12, int i13, final int i14, int i15) {
        if (i11 < 0) {
            throw new IllegalArgumentException("startSize cannot be less than 0");
        } else if (i12 < 0) {
            throw new IllegalArgumentException("endSize cannot be less than 0");
        } else if (i15 >= 0) {
            AnimatorSet animatorSet = this.currentAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimator = animatorSet2;
            animatorSet2.setDuration((long) i15);
            final int i16 = i12;
            final int i17 = i14;
            final int i18 = i11;
            final int i19 = i13;
            this.currentAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (Dot.this.state != null && !Dot.this.state.isStable()) {
                        Dot dot = Dot.this;
                        State unused = dot.state = dot.state.transitioningFrom();
                    }
                    Dot.this.changeSize(i18);
                    Dot.this.changeColor(i19);
                    AnimatorSet unused2 = Dot.this.currentAnimator = null;
                }

                public void onAnimationEnd(Animator animator) {
                    if (Dot.this.state != null && !Dot.this.state.isStable()) {
                        Dot dot = Dot.this;
                        State unused = dot.state = dot.state.transitioningTo();
                    }
                    Dot.this.changeSize(i16);
                    Dot.this.changeColor(i17);
                    AnimatorSet unused2 = Dot.this.currentAnimator = null;
                }

                public void onAnimationStart(Animator animator) {
                    if (Dot.this.state == State.INACTIVE) {
                        State unused = Dot.this.state = State.TRANSITIONING_TO_ACTIVE;
                    } else if (Dot.this.state == State.ACTIVE) {
                        State unused2 = Dot.this.state = State.TRANSITIONING_TO_INACTIVE;
                    }
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Dot.this.changeSize(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Dot.this.changeColor(i14);
                }
            });
            AnimatorSet animatorSet3 = this.currentAnimator;
            if (animatorSet3 != null) {
                animatorSet3.playTogether(new Animator[]{ofInt, ofFloat});
                this.currentAnimator.start();
            }
        } else {
            throw new IllegalArgumentException("duration cannot be less than 0");
        }
    }

    /* access modifiers changed from: private */
    public void changeColor(int i11) {
        this.shape.getPaint().setColor(i11);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void changeSize(int i11) {
        this.shape.setIntrinsicWidth(i11);
        this.shape.setIntrinsicHeight(i11);
        this.drawableHolder.setImageDrawable((Drawable) null);
        this.drawableHolder.setImageDrawable(this.shape);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE", "CustomViewStyleable"})
    private void init(@Nullable AttributeSet attributeSet, int i11) {
        State state2;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.IBDot, i11, 0);
        int convertDpToPx = ViewUtils.convertDpToPx(getContext(), 9.0f);
        this.inactiveDiameterPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IBDot_ibViewPagerInactiveDiameter, ViewUtils.convertDpToPx(getContext(), 6.0f));
        this.activeDiameterPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IBDot_ibViewPagerActiveDiameter, convertDpToPx);
        this.inactiveColor = obtainStyledAttributes.getColor(R.styleable.IBDot_ibViewPagerInactiveColor, -1);
        this.activeColor = obtainStyledAttributes.getColor(R.styleable.IBDot_ibViewPagerActiveColor, -1);
        this.transitionDurationMs = obtainStyledAttributes.getInt(R.styleable.IBDot_ibViewPagerTransitionDuration, 200);
        if (obtainStyledAttributes.getBoolean(R.styleable.IBDot_ibViewPagerInitiallyActive, false)) {
            state2 = State.ACTIVE;
        } else {
            state2 = State.INACTIVE;
        }
        this.state = state2;
        obtainStyledAttributes.recycle();
        reflectParametersInView();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void reflectParametersInView() {
        int i11;
        int i12;
        removeAllViews();
        int max = Math.max(this.inactiveDiameterPx, this.activeDiameterPx);
        setLayoutParams(new RelativeLayout.LayoutParams(max, max));
        setGravity(17);
        State state2 = this.state;
        State state3 = State.ACTIVE;
        if (state2 == state3) {
            i11 = this.activeDiameterPx;
        } else {
            i11 = this.inactiveDiameterPx;
        }
        if (state2 == state3) {
            i12 = this.activeColor;
        } else {
            i12 = this.inactiveColor;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.shape = shapeDrawable;
        shapeDrawable.setIntrinsicWidth(i11);
        this.shape.setIntrinsicHeight(i11);
        this.shape.getPaint().setColor(i12);
        ImageView imageView = new ImageView(getContext());
        this.drawableHolder = imageView;
        imageView.setImageDrawable((Drawable) null);
        this.drawableHolder.setImageDrawable(this.shape);
        addView(this.drawableHolder);
    }

    public int getActiveColor() {
        return this.activeColor;
    }

    public int getActiveDiameter() {
        return this.activeDiameterPx;
    }

    public int getInactiveColor() {
        return this.inactiveColor;
    }

    public int getInactiveDiameter() {
        return this.inactiveDiameterPx;
    }

    public int getTransitionDuration() {
        return this.transitionDurationMs;
    }

    public void setActive(boolean z11) {
        boolean z12;
        AnimatorSet animatorSet = this.currentAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (!z11 || this.state == State.ACTIVE || this.transitionDurationMs <= 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            animateDotChange(this.inactiveDiameterPx, this.activeDiameterPx, this.inactiveColor, this.activeColor, this.transitionDurationMs);
            return;
        }
        changeSize(this.activeDiameterPx);
        changeColor(this.activeColor);
        this.state = State.ACTIVE;
    }

    public Dot setActiveColor(int i11) {
        this.activeColor = i11;
        reflectParametersInView();
        return this;
    }

    public Dot setActiveDiameterDp(int i11) {
        if (i11 >= 0) {
            setActiveDiameterPx(i11);
            return this;
        }
        throw new IllegalArgumentException("activeDiameterDp cannot be less than 0");
    }

    public Dot setActiveDiameterPx(int i11) {
        if (i11 >= 0) {
            this.activeDiameterPx = i11;
            reflectParametersInView();
            return this;
        }
        throw new IllegalArgumentException("activeDiameterPx cannot be less than 0");
    }

    public void setInactive(boolean z11) {
        boolean z12;
        AnimatorSet animatorSet = this.currentAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (!z11 || this.state == State.INACTIVE || this.transitionDurationMs <= 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            animateDotChange(this.activeDiameterPx, this.inactiveDiameterPx, this.activeColor, this.inactiveColor, this.transitionDurationMs);
            return;
        }
        changeSize(this.inactiveDiameterPx);
        changeColor(this.inactiveColor);
        this.state = State.INACTIVE;
    }

    public Dot setInactiveColor(int i11) {
        this.inactiveColor = i11;
        reflectParametersInView();
        return this;
    }

    public Dot setInactiveDiameterDp(int i11) {
        if (i11 >= 0) {
            setInactiveDiameterPx(ViewUtils.convertDpToPx(getContext(), (float) i11));
            return this;
        }
        throw new IllegalArgumentException("inactiveDiameterDp cannot be less than 0");
    }

    public Dot setInactiveDiameterPx(int i11) {
        if (i11 >= 0) {
            this.inactiveDiameterPx = i11;
            reflectParametersInView();
            return this;
        }
        throw new IllegalArgumentException("inactiveDiameterPx cannot be less than 0");
    }

    public Dot setTransitionDuration(int i11) {
        if (i11 >= 0) {
            this.transitionDurationMs = i11;
            return this;
        }
        throw new IllegalArgumentException("transitionDurationMs cannot be less than 0");
    }

    public void toggleState(boolean z11) {
        AnimatorSet animatorSet = this.currentAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        State state2 = this.state;
        if (state2 != State.ACTIVE) {
            setActive(z11);
        } else if (state2 != State.INACTIVE) {
            setInactive(z11);
        } else {
            Log.e("IBG-Core", "[Animation trying to start from illegal state]");
        }
    }

    public Dot(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public Dot(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.currentAnimator = null;
        init(attributeSet, i11);
    }
}
