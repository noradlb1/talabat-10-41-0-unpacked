package com.talabat.designhelpers.LoadingHelper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.talabatcommon.R;

@RemoteViews.RemoteView
public class LoadingIndicatorView extends View {
    private static final BallPulseIndicator DEFAULT_INDICATOR = new BallPulseIndicator();
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private static final String TAG = "LoadingIndicatorView";

    /* renamed from: b  reason: collision with root package name */
    public int f58256b;

    /* renamed from: c  reason: collision with root package name */
    public int f58257c;

    /* renamed from: d  reason: collision with root package name */
    public int f58258d;

    /* renamed from: e  reason: collision with root package name */
    public int f58259e;
    private final Runnable mDelayedHide = new Runnable() {
        public void run() {
            LoadingIndicatorView.this.mPostedHide = false;
            LoadingIndicatorView.this.mStartTime = -1;
            LoadingIndicatorView.this.setVisibility(8);
        }
    };
    private final Runnable mDelayedShow = new Runnable() {
        public void run() {
            LoadingIndicatorView.this.mPostedShow = false;
            if (!LoadingIndicatorView.this.mDismissed) {
                LoadingIndicatorView.this.mStartTime = System.currentTimeMillis();
                LoadingIndicatorView.this.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mDismissed = false;
    private Indicator mIndicator;
    private int mIndicatorColor;
    /* access modifiers changed from: private */
    public boolean mPostedHide = false;
    /* access modifiers changed from: private */
    public boolean mPostedShow = false;
    private boolean mShouldStartAnimationDrawable;
    /* access modifiers changed from: private */
    public long mStartTime = -1;

    public LoadingIndicatorView(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f58256b = 18;
        this.f58257c = 36;
        this.f58258d = 18;
        this.f58259e = 36;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingIndicatorView, i11, i12);
        this.f58256b = obtainStyledAttributes.getDimensionPixelSize(5, this.f58256b);
        this.f58257c = obtainStyledAttributes.getDimensionPixelSize(3, this.f58257c);
        this.f58258d = obtainStyledAttributes.getDimensionPixelSize(4, this.f58258d);
        this.f58259e = obtainStyledAttributes.getDimensionPixelSize(2, this.f58259e);
        String string = obtainStyledAttributes.getString(1);
        this.mIndicatorColor = obtainStyledAttributes.getColor(0, -16711936);
        setIndicator(string);
        if (this.mIndicator == null) {
            setIndicator((Indicator) DEFAULT_INDICATOR);
        }
        obtainStyledAttributes.recycle();
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    private void updateDrawableBounds(int i11, int i12) {
        int i13;
        int paddingRight = i11 - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i12 - (getPaddingTop() + getPaddingBottom());
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            float intrinsicWidth = ((float) indicator.getIntrinsicWidth()) / ((float) this.mIndicator.getIntrinsicHeight());
            float f11 = (float) paddingRight;
            float f12 = (float) paddingTop;
            float f13 = f11 / f12;
            int i14 = 0;
            if (intrinsicWidth == f13) {
                i13 = 0;
            } else if (f13 > intrinsicWidth) {
                int i15 = (int) (f12 * intrinsicWidth);
                int i16 = (paddingRight - i15) / 2;
                i14 = i16;
                paddingRight = i15 + i16;
                i13 = 0;
            } else {
                int i17 = (int) (f11 * (1.0f / intrinsicWidth));
                int i18 = (paddingTop - i17) / 2;
                int i19 = i17 + i18;
                i13 = i18;
                paddingTop = i19;
            }
            this.mIndicator.setBounds(i14, i13, paddingRight, paddingTop);
        }
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.isStateful()) {
            this.mIndicator.setState(drawableState);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f11, float f12) {
        super.drawableHotspotChanged(f11, f12);
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.setHotspot(f11, f12);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    public void e(Canvas canvas) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            int save = canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            indicator.draw(canvas);
            canvas.restoreToCount(save);
            if (this.mShouldStartAnimationDrawable) {
                indicator.start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    public void f() {
        if (getVisibility() == 0) {
            if (this.mIndicator instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
            }
            postInvalidate();
        }
    }

    public void g() {
        Indicator indicator = this.mIndicator;
        if (indicator instanceof Animatable) {
            indicator.stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    public Indicator getIndicator() {
        return this.mIndicator;
    }

    public void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.mStartTime;
        long j12 = currentTimeMillis - j11;
        if (j12 >= 500 || j11 == -1) {
            setVisibility(8);
        } else if (!this.mPostedHide) {
            postDelayed(this.mDelayedHide, 500 - j12);
            this.mPostedHide = true;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
        removeCallbacks();
    }

    public void onDetachedFromWindow() {
        g();
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
    }

    public synchronized void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            i13 = Math.max(this.f58256b, Math.min(this.f58257c, indicator.getIntrinsicWidth()));
            i14 = Math.max(this.f58258d, Math.min(this.f58259e, indicator.getIntrinsicHeight()));
        } else {
            i14 = 0;
            i13 = 0;
        }
        updateDrawableState();
        setMeasuredDimension(View.resolveSizeAndState(i13 + getPaddingLeft() + getPaddingRight(), i11, 0), View.resolveSizeAndState(i14 + getPaddingTop() + getPaddingBottom(), i12, 0));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        updateDrawableBounds(i11, i12);
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 8 || i11 == 4) {
            g();
        } else {
            f();
        }
    }

    public void setIndicator(Indicator indicator) {
        Indicator indicator2 = this.mIndicator;
        if (indicator2 != indicator) {
            if (indicator2 != null) {
                indicator2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mIndicator);
            }
            this.mIndicator = indicator;
            setIndicatorColor(this.mIndicatorColor);
            if (indicator != null) {
                indicator.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int i11) {
        this.mIndicatorColor = i11;
        this.mIndicator.setColor(i11);
    }

    public void setVisibility(int i11) {
        if (getVisibility() != i11) {
            super.setVisibility(i11);
            if (i11 == 8 || i11 == 4) {
                g();
            } else {
                f();
            }
        }
    }

    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mIndicator || super.verifyDrawable(drawable);
    }

    public void setIndicator(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb2 = new StringBuilder();
            if (!str.contains(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                sb2.append(getClass().getPackage().getName());
                sb2.append(".indicators");
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            }
            sb2.append(str);
            try {
                setIndicator((Indicator) Class.forName(sb2.toString()).newInstance());
            } catch (ClassNotFoundException unused) {
                Log.e(TAG, "Didn't find your class , check the name again !");
            } catch (InstantiationException e11) {
                e11.printStackTrace();
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            }
        }
    }

    public LoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, com.talabat.R.style.LoadingIndicatorView);
    }

    public LoadingIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet, i11, com.talabat.R.style.LoadingIndicatorView);
    }

    @TargetApi(21)
    public LoadingIndicatorView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(context, attributeSet, i11, com.talabat.R.style.LoadingIndicatorView);
    }
}
