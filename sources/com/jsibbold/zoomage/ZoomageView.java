package com.jsibbold.zoomage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ScaleGestureDetectorCompat;
import com.jsibbold.zoomage.AutoResetMode;

public class ZoomageView extends AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener {
    private static final float MAX_SCALE = 8.0f;
    private static final float MIN_SCALE = 0.6f;
    private final int RESET_DURATION = 200;
    private boolean animateOnReset;
    private boolean autoCenter;
    private int autoResetMode;
    private final RectF bounds = new RectF();
    private float calculatedMaxScale = 8.0f;
    private float calculatedMinScale = 0.6f;
    private int currentPointerCount = 0;
    private float currentScaleFactor = 1.0f;
    /* access modifiers changed from: private */
    public boolean doubleTapDetected = false;
    private boolean doubleTapToZoom;
    private float doubleTapToZoomScaleFactor;
    private GestureDetector gestureDetector;
    private final GestureDetector.OnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                boolean unused = ZoomageView.this.doubleTapDetected = true;
            }
            boolean unused2 = ZoomageView.this.singleTapDetected = false;
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            boolean unused = ZoomageView.this.singleTapDetected = false;
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean unused = ZoomageView.this.singleTapDetected = true;
            return false;
        }
    };
    private PointF last = new PointF(0.0f, 0.0f);
    private Matrix matrix = new Matrix();
    private float[] matrixValues = new float[9];
    private float maxScale = 8.0f;
    private float minScale = 0.6f;
    private int previousPointerCount = 1;
    private ValueAnimator resetAnimator;
    private boolean restrictBounds;
    private float scaleBy = 1.0f;
    private ScaleGestureDetector scaleDetector;
    /* access modifiers changed from: private */
    public boolean singleTapDetected = false;
    private Matrix startMatrix = new Matrix();
    private float startScale = 1.0f;
    private ImageView.ScaleType startScaleType;
    private float[] startValues = null;
    private boolean translatable;
    private boolean zoomable;

    public class SimpleAnimatorListener implements Animator.AnimatorListener {
        private SimpleAnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public ZoomageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void animateMatrixIndex(final int i11, float f11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.matrixValues[i11], f11});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            public final float[] f52708a = new float[9];

            /* renamed from: b  reason: collision with root package name */
            public Matrix f52709b = new Matrix();

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f52709b.set(ZoomageView.this.getImageMatrix());
                this.f52709b.getValues(this.f52708a);
                this.f52708a[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f52709b.setValues(this.f52708a);
                ZoomageView.this.setImageMatrix(this.f52709b);
            }
        });
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    private void animateScaleAndTranslationToMatrix(final Matrix matrix2, int i11) {
        float[] fArr = new float[9];
        matrix2.getValues(fArr);
        final Matrix matrix3 = new Matrix(getImageMatrix());
        matrix3.getValues(this.matrixValues);
        float f11 = fArr[0];
        float[] fArr2 = this.matrixValues;
        final float f12 = f11 - fArr2[0];
        final float f13 = fArr[4] - fArr2[4];
        float f14 = fArr[2] - fArr2[2];
        float f15 = fArr[5] - fArr2[5];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.resetAnimator = ofFloat;
        final float f16 = f14;
        final float f17 = f15;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            public final Matrix f52698a;

            /* renamed from: b  reason: collision with root package name */
            public final float[] f52699b = new float[9];

            {
                this.f52698a = new Matrix(ZoomageView.this.getImageMatrix());
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f52698a.set(matrix3);
                this.f52698a.getValues(this.f52699b);
                float[] fArr = this.f52699b;
                fArr[2] = fArr[2] + (f16 * floatValue);
                fArr[5] = fArr[5] + (f17 * floatValue);
                fArr[0] = fArr[0] + (f12 * floatValue);
                fArr[4] = fArr[4] + (f13 * floatValue);
                this.f52698a.setValues(fArr);
                ZoomageView.this.setImageMatrix(this.f52698a);
            }
        });
        this.resetAnimator.addListener(new SimpleAnimatorListener() {
            public void onAnimationEnd(Animator animator) {
                ZoomageView.this.setImageMatrix(matrix2);
            }
        });
        this.resetAnimator.setDuration((long) i11);
        this.resetAnimator.start();
    }

    private void animateToStartMatrix() {
        animateScaleAndTranslationToMatrix(this.startMatrix, 200);
    }

    private void animateTranslationX() {
        if (getCurrentDisplayedWidth() > ((float) getWidth())) {
            RectF rectF = this.bounds;
            if (rectF.left > 0.0f) {
                animateMatrixIndex(2, 0.0f);
            } else if (rectF.right < ((float) getWidth())) {
                animateMatrixIndex(2, (this.bounds.left + ((float) getWidth())) - this.bounds.right);
            }
        } else {
            RectF rectF2 = this.bounds;
            if (rectF2.left < 0.0f) {
                animateMatrixIndex(2, 0.0f);
            } else if (rectF2.right > ((float) getWidth())) {
                animateMatrixIndex(2, (this.bounds.left + ((float) getWidth())) - this.bounds.right);
            }
        }
    }

    private void animateTranslationY() {
        if (getCurrentDisplayedHeight() > ((float) getHeight())) {
            RectF rectF = this.bounds;
            if (rectF.top > 0.0f) {
                animateMatrixIndex(5, 0.0f);
            } else if (rectF.bottom < ((float) getHeight())) {
                animateMatrixIndex(5, (this.bounds.top + ((float) getHeight())) - this.bounds.bottom);
            }
        } else {
            RectF rectF2 = this.bounds;
            if (rectF2.top < 0.0f) {
                animateMatrixIndex(5, 0.0f);
            } else if (rectF2.bottom > ((float) getHeight())) {
                animateMatrixIndex(5, (this.bounds.top + ((float) getHeight())) - this.bounds.bottom);
            }
        }
    }

    private void center() {
        if (this.autoCenter) {
            animateTranslationX();
            animateTranslationY();
        }
    }

    private float getCurrentDisplayedHeight() {
        if (getDrawable() != null) {
            return ((float) getDrawable().getIntrinsicHeight()) * this.matrixValues[4];
        }
        return 0.0f;
    }

    private float getCurrentDisplayedWidth() {
        if (getDrawable() != null) {
            return ((float) getDrawable().getIntrinsicWidth()) * this.matrixValues[0];
        }
        return 0.0f;
    }

    private float getRestrictedXDistance(float f11) {
        float f12;
        float f13;
        if (getCurrentDisplayedWidth() >= ((float) getWidth())) {
            float f14 = this.bounds.left;
            if (f14 <= 0.0f && f14 + f11 > 0.0f && !this.scaleDetector.isInProgress()) {
                return -this.bounds.left;
            }
            if (this.bounds.right < ((float) getWidth()) || this.bounds.right + f11 >= ((float) getWidth()) || this.scaleDetector.isInProgress()) {
                return f11;
            }
            f12 = (float) getWidth();
            f13 = this.bounds.right;
        } else if (this.scaleDetector.isInProgress()) {
            return f11;
        } else {
            RectF rectF = this.bounds;
            float f15 = rectF.left;
            if (f15 >= 0.0f && f15 + f11 < 0.0f) {
                return -f15;
            }
            if (rectF.right > ((float) getWidth()) || this.bounds.right + f11 <= ((float) getWidth())) {
                return f11;
            }
            f12 = (float) getWidth();
            f13 = this.bounds.right;
        }
        return f12 - f13;
    }

    private float getRestrictedYDistance(float f11) {
        float f12;
        float f13;
        if (getCurrentDisplayedHeight() >= ((float) getHeight())) {
            float f14 = this.bounds.top;
            if (f14 <= 0.0f && f14 + f11 > 0.0f && !this.scaleDetector.isInProgress()) {
                return -this.bounds.top;
            }
            if (this.bounds.bottom < ((float) getHeight()) || this.bounds.bottom + f11 >= ((float) getHeight()) || this.scaleDetector.isInProgress()) {
                return f11;
            }
            f12 = (float) getHeight();
            f13 = this.bounds.bottom;
        } else if (this.scaleDetector.isInProgress()) {
            return f11;
        } else {
            RectF rectF = this.bounds;
            float f15 = rectF.top;
            if (f15 >= 0.0f && f15 + f11 < 0.0f) {
                return -f15;
            }
            if (rectF.bottom > ((float) getHeight()) || this.bounds.bottom + f11 <= ((float) getHeight())) {
                return f11;
            }
            f12 = (float) getHeight();
            f13 = this.bounds.bottom;
        }
        return f12 - f13;
    }

    private float getXDistance(float f11, float f12) {
        float f13 = f11 - f12;
        if (this.restrictBounds) {
            f13 = getRestrictedXDistance(f13);
        }
        RectF rectF = this.bounds;
        float f14 = rectF.right;
        if (f14 + f13 < 0.0f) {
            return -f14;
        }
        if (rectF.left + f13 > ((float) getWidth())) {
            return ((float) getWidth()) - this.bounds.left;
        }
        return f13;
    }

    private float getYDistance(float f11, float f12) {
        float f13 = f11 - f12;
        if (this.restrictBounds) {
            f13 = getRestrictedYDistance(f13);
        }
        RectF rectF = this.bounds;
        float f14 = rectF.bottom;
        if (f14 + f13 < 0.0f) {
            return -f14;
        }
        if (rectF.top + f13 > ((float) getHeight())) {
            return ((float) getHeight()) - this.bounds.top;
        }
        return f13;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.scaleDetector = new ScaleGestureDetector(context, this);
        this.gestureDetector = new GestureDetector(context, this.gestureListener);
        ScaleGestureDetectorCompat.setQuickScaleEnabled(this.scaleDetector, false);
        this.startScaleType = getScaleType();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ZoomageView);
        this.zoomable = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_zoomable, true);
        this.translatable = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_translatable, true);
        this.animateOnReset = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_animateOnReset, true);
        this.autoCenter = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_autoCenter, true);
        this.restrictBounds = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_restrictBounds, false);
        this.doubleTapToZoom = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_doubleTapToZoom, true);
        this.minScale = obtainStyledAttributes.getFloat(R.styleable.ZoomageView_zoomage_minScale, 0.6f);
        this.maxScale = obtainStyledAttributes.getFloat(R.styleable.ZoomageView_zoomage_maxScale, 8.0f);
        this.doubleTapToZoomScaleFactor = obtainStyledAttributes.getFloat(R.styleable.ZoomageView_zoomage_doubleTapToZoomScaleFactor, 3.0f);
        this.autoResetMode = AutoResetMode.Parser.fromInt(obtainStyledAttributes.getInt(R.styleable.ZoomageView_zoomage_autoResetMode, 0));
        verifyScaleRange();
        obtainStyledAttributes.recycle();
    }

    private boolean isAnimating() {
        ValueAnimator valueAnimator = this.resetAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    private void resetImage() {
        int i11 = this.autoResetMode;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    reset();
                } else if (i11 == 3) {
                    center();
                }
            } else if (this.matrixValues[0] >= this.startValues[0]) {
                reset();
            } else {
                center();
            }
        } else if (this.matrixValues[0] <= this.startValues[0]) {
            reset();
        } else {
            center();
        }
    }

    private void setStartValues() {
        this.startValues = new float[9];
        Matrix matrix2 = new Matrix(getImageMatrix());
        this.startMatrix = matrix2;
        matrix2.getValues(this.startValues);
        float f11 = this.minScale;
        float f12 = this.startValues[0];
        this.calculatedMinScale = f11 * f12;
        this.calculatedMaxScale = this.maxScale * f12;
    }

    private void updateBounds(float[] fArr) {
        if (getDrawable() != null) {
            this.bounds.set(fArr[2], fArr[5], (((float) getDrawable().getIntrinsicWidth()) * fArr[0]) + fArr[2], (((float) getDrawable().getIntrinsicHeight()) * fArr[4]) + fArr[5]);
        }
    }

    private void verifyScaleRange() {
        float f11 = this.minScale;
        float f12 = this.maxScale;
        if (f11 >= f12) {
            throw new IllegalStateException("minScale must be less than maxScale");
        } else if (f11 < 0.0f) {
            throw new IllegalStateException("minScale must be greater than 0");
        } else if (f12 >= 0.0f) {
            if (this.doubleTapToZoomScaleFactor > f12) {
                this.doubleTapToZoomScaleFactor = f12;
            }
            if (this.doubleTapToZoomScaleFactor < f11) {
                this.doubleTapToZoomScaleFactor = f11;
            }
        } else {
            throw new IllegalStateException("maxScale must be greater than 0");
        }
    }

    public boolean c(MotionEvent motionEvent) {
        return this.translatable && this.currentScaleFactor > 1.0f;
    }

    public boolean d(MotionEvent motionEvent) {
        return this.zoomable;
    }

    public boolean e(MotionEvent motionEvent) {
        return this.currentPointerCount > 1 || this.currentScaleFactor > 1.0f || isAnimating();
    }

    public boolean getAnimateOnReset() {
        return this.animateOnReset;
    }

    public boolean getAutoCenter() {
        return this.autoCenter;
    }

    public int getAutoResetMode() {
        return this.autoResetMode;
    }

    public float getCurrentScaleFactor() {
        return this.currentScaleFactor;
    }

    public boolean getDoubleTapToZoom() {
        return this.doubleTapToZoom;
    }

    public float getDoubleTapToZoomScaleFactor() {
        return this.doubleTapToZoomScaleFactor;
    }

    public boolean getRestrictBounds() {
        return this.restrictBounds;
    }

    public boolean isTranslatable() {
        return this.translatable;
    }

    public boolean isZoomable() {
        return this.zoomable;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = this.startScale * scaleGestureDetector.getScaleFactor();
        float f11 = this.matrixValues[0];
        float f12 = scaleFactor / f11;
        this.scaleBy = f12;
        float f13 = f12 * f11;
        float f14 = this.calculatedMinScale;
        if (f13 < f14) {
            this.scaleBy = f14 / f11;
        } else {
            float f15 = this.calculatedMaxScale;
            if (f13 > f15) {
                this.scaleBy = f15 / f11;
            }
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.startScale = this.matrixValues[0];
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.scaleBy = 1.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() || !isEnabled() || (!this.zoomable && !this.translatable)) {
            return super.onTouchEvent(motionEvent);
        }
        ImageView.ScaleType scaleType = getScaleType();
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
        if (scaleType != scaleType2) {
            super.setScaleType(scaleType2);
        }
        if (this.startValues == null) {
            setStartValues();
        }
        this.currentPointerCount = motionEvent.getPointerCount();
        this.matrix.set(getImageMatrix());
        this.matrix.getValues(this.matrixValues);
        updateBounds(this.matrixValues);
        this.scaleDetector.onTouchEvent(motionEvent);
        this.gestureDetector.onTouchEvent(motionEvent);
        if (!this.doubleTapToZoom || !this.doubleTapDetected) {
            if (!this.singleTapDetected) {
                if (motionEvent.getActionMasked() == 0 || this.currentPointerCount != this.previousPointerCount) {
                    this.last.set(this.scaleDetector.getFocusX(), this.scaleDetector.getFocusY());
                } else if (motionEvent.getActionMasked() == 2) {
                    float focusX = this.scaleDetector.getFocusX();
                    float focusY = this.scaleDetector.getFocusY();
                    if (c(motionEvent)) {
                        this.matrix.postTranslate(getXDistance(focusX, this.last.x), getYDistance(focusY, this.last.y));
                    }
                    if (d(motionEvent)) {
                        Matrix matrix2 = this.matrix;
                        float f11 = this.scaleBy;
                        matrix2.postScale(f11, f11, focusX, focusY);
                        this.currentScaleFactor = this.matrixValues[0] / this.startValues[0];
                    }
                    setImageMatrix(this.matrix);
                    this.last.set(focusX, focusY);
                }
                if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                    this.scaleBy = 1.0f;
                    resetImage();
                }
            }
            getParent().requestDisallowInterceptTouchEvent(e(motionEvent));
            this.previousPointerCount = this.currentPointerCount;
            return true;
        }
        this.doubleTapDetected = false;
        this.singleTapDetected = false;
        if (this.matrixValues[0] != this.startValues[0]) {
            reset();
        } else {
            Matrix matrix3 = new Matrix(this.matrix);
            float f12 = this.doubleTapToZoomScaleFactor;
            matrix3.postScale(f12, f12, this.scaleDetector.getFocusX(), this.scaleDetector.getFocusY());
            animateScaleAndTranslationToMatrix(matrix3, 200);
        }
        return true;
    }

    public void reset() {
        reset(this.animateOnReset);
    }

    public void setAnimateOnReset(boolean z11) {
        this.animateOnReset = z11;
    }

    public void setAutoCenter(boolean z11) {
        this.autoCenter = z11;
    }

    public void setAutoResetMode(int i11) {
        this.autoResetMode = i11;
    }

    public void setDoubleTapToZoom(boolean z11) {
        this.doubleTapToZoom = z11;
    }

    public void setDoubleTapToZoomScaleFactor(float f11) {
        this.doubleTapToZoomScaleFactor = f11;
        verifyScaleRange();
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (!z11) {
            setScaleType(this.startScaleType);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        setScaleType(this.startScaleType);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        setScaleType(this.startScaleType);
    }

    public void setImageResource(int i11) {
        super.setImageResource(i11);
        setScaleType(this.startScaleType);
    }

    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        setScaleType(this.startScaleType);
    }

    public void setRestrictBounds(boolean z11) {
        this.restrictBounds = z11;
    }

    public void setScaleRange(float f11, float f12) {
        this.minScale = f11;
        this.maxScale = f12;
        this.startValues = null;
        verifyScaleRange();
    }

    public void setScaleType(@Nullable ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            super.setScaleType(scaleType);
            this.startScaleType = scaleType;
            this.startValues = null;
        }
    }

    public void setTranslatable(boolean z11) {
        this.translatable = z11;
    }

    public void setZoomable(boolean z11) {
        this.zoomable = z11;
    }

    public void reset(boolean z11) {
        if (z11) {
            animateToStartMatrix();
        } else {
            setImageMatrix(this.startMatrix);
        }
    }

    public ZoomageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ZoomageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
