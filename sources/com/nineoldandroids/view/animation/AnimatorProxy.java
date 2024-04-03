package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, AnimatorProxy> PROXIES = new WeakHashMap<>();
    private final RectF mAfter = new RectF();
    private float mAlpha = 1.0f;
    private final RectF mBefore = new RectF();
    private final Camera mCamera = new Camera();
    private boolean mHasPivot;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private final Matrix mTempMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;

    static {
        boolean z11;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
            z11 = true;
        } else {
            z11 = false;
        }
        NEEDS_PROXY = z11;
    }

    private AnimatorProxy(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.mView = new WeakReference<>(view);
    }

    private void computeRect(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        float f11 = rectF.right;
        float f12 = rectF.left;
        if (f11 < f12) {
            rectF.right = f12;
            rectF.left = f11;
        }
        float f13 = rectF.bottom;
        float f14 = rectF.top;
        if (f13 < f14) {
            rectF.top = f13;
            rectF.bottom = f14;
        }
    }

    private void invalidateAfterUpdate() {
        View view = this.mView.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.mAfter;
            computeRect(rectF, view);
            rectF.union(this.mBefore);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void prepareForUpdate() {
        View view = this.mView.get();
        if (view != null) {
            computeRect(this.mBefore, view);
        }
    }

    private void transformMatrix(Matrix matrix, View view) {
        float f11;
        float f12;
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z11 = this.mHasPivot;
        if (z11) {
            f11 = this.mPivotX;
        } else {
            f11 = width / 2.0f;
        }
        if (z11) {
            f12 = this.mPivotY;
        } else {
            f12 = height / 2.0f;
        }
        float f13 = this.mRotationX;
        float f14 = this.mRotationY;
        float f15 = this.mRotationZ;
        if (!(f13 == 0.0f && f14 == 0.0f && f15 == 0.0f)) {
            Camera camera = this.mCamera;
            camera.save();
            camera.rotateX(f13);
            camera.rotateY(f14);
            camera.rotateZ(-f15);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f11, -f12);
            matrix.postTranslate(f11, f12);
        }
        float f16 = this.mScaleX;
        float f17 = this.mScaleY;
        if (!(f16 == 1.0f && f17 == 1.0f)) {
            matrix.postScale(f16, f17);
            matrix.postTranslate((-(f11 / width)) * ((f16 * width) - width), (-(f12 / height)) * ((f17 * height) - height));
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }

    public static AnimatorProxy wrap(View view) {
        WeakHashMap<View, AnimatorProxy> weakHashMap = PROXIES;
        AnimatorProxy animatorProxy = weakHashMap.get(view);
        if (animatorProxy != null && animatorProxy == view.getAnimation()) {
            return animatorProxy;
        }
        AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
        weakHashMap.put(view, animatorProxy2);
        return animatorProxy2;
    }

    public void applyTransformation(float f11, Transformation transformation) {
        View view = this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotationZ;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getScrollX() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getX() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.mTranslationX;
    }

    public float getY() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.mTranslationY;
    }

    public void setAlpha(float f11) {
        if (this.mAlpha != f11) {
            this.mAlpha = f11;
            View view = this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f11) {
        if (!this.mHasPivot || this.mPivotX != f11) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotX = f11;
            invalidateAfterUpdate();
        }
    }

    public void setPivotY(float f11) {
        if (!this.mHasPivot || this.mPivotY != f11) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotY = f11;
            invalidateAfterUpdate();
        }
    }

    public void setRotation(float f11) {
        if (this.mRotationZ != f11) {
            prepareForUpdate();
            this.mRotationZ = f11;
            invalidateAfterUpdate();
        }
    }

    public void setRotationX(float f11) {
        if (this.mRotationX != f11) {
            prepareForUpdate();
            this.mRotationX = f11;
            invalidateAfterUpdate();
        }
    }

    public void setRotationY(float f11) {
        if (this.mRotationY != f11) {
            prepareForUpdate();
            this.mRotationY = f11;
            invalidateAfterUpdate();
        }
    }

    public void setScaleX(float f11) {
        if (this.mScaleX != f11) {
            prepareForUpdate();
            this.mScaleX = f11;
            invalidateAfterUpdate();
        }
    }

    public void setScaleY(float f11) {
        if (this.mScaleY != f11) {
            prepareForUpdate();
            this.mScaleY = f11;
            invalidateAfterUpdate();
        }
    }

    public void setScrollX(int i11) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(i11, view.getScrollY());
        }
    }

    public void setScrollY(int i11) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i11);
        }
    }

    public void setTranslationX(float f11) {
        if (this.mTranslationX != f11) {
            prepareForUpdate();
            this.mTranslationX = f11;
            invalidateAfterUpdate();
        }
    }

    public void setTranslationY(float f11) {
        if (this.mTranslationY != f11) {
            prepareForUpdate();
            this.mTranslationY = f11;
            invalidateAfterUpdate();
        }
    }

    public void setX(float f11) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationX(f11 - ((float) view.getLeft()));
        }
    }

    public void setY(float f11) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationY(f11 - ((float) view.getTop()));
        }
    }
}
