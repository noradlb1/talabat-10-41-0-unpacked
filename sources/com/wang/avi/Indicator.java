package com.wang.avi;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class Indicator extends Drawable implements Animatable {
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    private int alpha = 255;

    /* renamed from: b  reason: collision with root package name */
    public Rect f13688b = ZERO_BOUNDS_RECT;
    private ArrayList<ValueAnimator> mAnimators;
    private boolean mHasAnimators;
    private Paint mPaint;
    private HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners = new HashMap<>();

    public Indicator() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
    }

    private void ensureAnimators() {
        if (!this.mHasAnimators) {
            this.mAnimators = onCreateAnimators();
            this.mHasAnimators = true;
        }
    }

    private boolean isStarted() {
        Iterator<ValueAnimator> it = this.mAnimators.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    private void startAnimators() {
        for (int i11 = 0; i11 < this.mAnimators.size(); i11++) {
            ValueAnimator valueAnimator = this.mAnimators.get(i11);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mUpdateListeners.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    private void stopAnimators() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        if (arrayList != null) {
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null && next.isStarted()) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
    }

    public void addUpdateListener(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListeners.put(valueAnimator, animatorUpdateListener);
    }

    public int centerX() {
        return this.f13688b.centerX();
    }

    public int centerY() {
        return this.f13688b.centerY();
    }

    public void draw(Canvas canvas) {
        draw(canvas, this.mPaint);
    }

    public abstract void draw(Canvas canvas, Paint paint);

    public float exactCenterX() {
        return this.f13688b.exactCenterX();
    }

    public float exactCenterY() {
        return this.f13688b.exactCenterY();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public Rect getDrawBounds() {
        return this.f13688b;
    }

    public int getHeight() {
        return this.f13688b.height();
    }

    public int getOpacity() {
        return -1;
    }

    public int getWidth() {
        return this.f13688b.width();
    }

    public boolean isRunning() {
        Iterator<ValueAnimator> it = this.mAnimators.iterator();
        if (it.hasNext()) {
            return it.next().isRunning();
        }
        return false;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setDrawBounds(rect);
    }

    public abstract ArrayList<ValueAnimator> onCreateAnimators();

    public void postInvalidate() {
        invalidateSelf();
    }

    public void setAlpha(int i11) {
        this.alpha = i11;
    }

    public void setColor(int i11) {
        this.mPaint.setColor(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setDrawBounds(Rect rect) {
        setDrawBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void start() {
        ensureAnimators();
        if (this.mAnimators != null && !isStarted()) {
            startAnimators();
            invalidateSelf();
        }
    }

    public void stop() {
        stopAnimators();
    }

    public void setDrawBounds(int i11, int i12, int i13, int i14) {
        this.f13688b = new Rect(i11, i12, i13, i14);
    }
}
