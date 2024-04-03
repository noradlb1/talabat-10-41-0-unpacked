package com.talabat.designhelpers.shimmer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.talabat.R;

public class ShimmerLayout extends FrameLayout {
    private static final int DEFAULT_ANGLE = 20;
    private static final int DEFAULT_ANIMATION_DURATION = 1500;
    private static final int MAX_ANGLE_VALUE = 30;
    private static final int MIN_ANGLE_VALUE = 0;
    private boolean autoStart;
    private Canvas canvasForRendering;
    private Bitmap destinationBitmap;
    private boolean isAnimationStarted;
    private Bitmap localAvailableBitmap;
    private Bitmap localMaskBitmap;
    private ValueAnimator maskAnimator;
    /* access modifiers changed from: private */
    public int maskOffsetX;
    private Paint maskPaint;
    private Rect maskRect;
    private int shimmerAngle;
    private int shimmerAnimationDuration;
    private int shimmerColor;
    private Bitmap sourceMaskBitmap;

    public ShimmerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private Rect calculateMaskRect() {
        int width = getWidth() / 2;
        if (this.shimmerAngle == 0) {
            double d11 = (double) width;
            return new Rect((int) (0.25d * d11), 0, (int) (d11 * 0.75d), getHeight());
        }
        int height = (int) (((double) getHeight()) * 0.5d);
        int i11 = (int) (((double) width) * 0.75d);
        Point point = new Point(i11, 0);
        Point point2 = new Point(i11, height);
        float f11 = (float) (width / 2);
        Point rotatePoint = rotatePoint(point, (float) this.shimmerAngle, f11, (float) (getHeight() / 2));
        Point rotatePoint2 = rotatePoint(point2, (float) this.shimmerAngle, f11, (float) (getHeight() / 2));
        Point topIntersection = getTopIntersection(rotatePoint, rotatePoint2);
        int height2 = (getHeight() / 2) - distanceBetween(rotatePoint2, topIntersection);
        int i12 = width - topIntersection.x;
        return new Rect(i12, height2, width - i12, getHeight() - height2);
    }

    private Bitmap createBitmap(int i11, int i12) {
        try {
            return Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        }
    }

    private void dispatchDrawUsingBitmap(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap destinationBitmap2 = getDestinationBitmap();
        this.localAvailableBitmap = destinationBitmap2;
        if (destinationBitmap2 != null) {
            if (this.canvasForRendering == null) {
                this.canvasForRendering = new Canvas(this.localAvailableBitmap);
            }
            drawMask(this.canvasForRendering);
            canvas.save();
            int i11 = this.maskOffsetX;
            canvas.clipRect(i11, 0, this.maskRect.width() + i11, getHeight());
            canvas.drawBitmap(this.localAvailableBitmap, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
            this.localAvailableBitmap = null;
        }
    }

    private int distanceBetween(Point point, Point point2) {
        return (int) Math.ceil(Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d)));
    }

    private void drawMask(Canvas canvas) {
        Bitmap sourceMaskBitmap2 = getSourceMaskBitmap();
        this.localMaskBitmap = sourceMaskBitmap2;
        if (sourceMaskBitmap2 != null) {
            canvas.save();
            int i11 = this.maskOffsetX;
            canvas.clipRect(i11, 0, this.localMaskBitmap.getWidth() + i11, getHeight());
            super.dispatchDraw(canvas);
            canvas.drawBitmap(this.localMaskBitmap, (float) this.maskOffsetX, 0.0f, this.maskPaint);
            canvas.restore();
            this.localMaskBitmap = null;
        }
    }

    private int getColor(int i11) {
        return getContext().getColor(i11);
    }

    private Bitmap getDestinationBitmap() {
        if (this.destinationBitmap == null) {
            this.destinationBitmap = createBitmap(getWidth(), getHeight());
        }
        return this.destinationBitmap;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.maskRect == null) {
            this.maskRect = calculateMaskRect();
        }
        int width = getWidth();
        final int i11 = -width;
        final int width2 = this.maskRect.width();
        final int i12 = width - i11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.maskAnimator = ofFloat;
        ofFloat.setDuration((long) this.shimmerAnimationDuration);
        this.maskAnimator.setRepeatCount(-1);
        final float[] fArr = new float[1];
        this.maskAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                fArr[0] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShimmerLayout.this.maskOffsetX = (int) (((float) i11) + (((float) i12) * fArr[0]));
                if (ShimmerLayout.this.maskOffsetX + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.maskAnimator;
    }

    private Bitmap getSourceMaskBitmap() {
        Bitmap bitmap = this.sourceMaskBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        int width = this.maskRect.width();
        int height = getHeight();
        int reduceColorAlphaValueToZero = reduceColorAlphaValueToZero(this.shimmerColor);
        int i11 = this.maskRect.left;
        int i12 = this.shimmerColor;
        LinearGradient linearGradient = new LinearGradient((float) (-i11), 0.0f, (float) (i11 + width), 0.0f, new int[]{reduceColorAlphaValueToZero, i12, i12, reduceColorAlphaValueToZero}, new float[]{0.25f, 0.47f, 0.53f, 0.75f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        this.sourceMaskBitmap = createBitmap(width, height);
        Canvas canvas = new Canvas(this.sourceMaskBitmap);
        canvas.rotate((float) this.shimmerAngle, (float) (width / 2), (float) (height / 2));
        Rect rect = this.maskRect;
        int i13 = rect.left;
        canvas.drawRect((float) (-i13), (float) rect.top, (float) (width + i13), (float) rect.bottom, paint);
        return this.sourceMaskBitmap;
    }

    private Point getTopIntersection(Point point, Point point2) {
        double d11 = (double) point.x;
        double d12 = (double) (-point.y);
        double d13 = (((double) (-point2.y)) - d12) / (((double) point2.x) - d11);
        return new Point((int) ((0.0d - (d12 - (d11 * d13))) / d13), 0);
    }

    private int reduceColorAlphaValueToZero(int i11) {
        return Color.argb(0, Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private void releaseBitMaps() {
        Bitmap bitmap = this.sourceMaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.sourceMaskBitmap = null;
        }
        Bitmap bitmap2 = this.destinationBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.destinationBitmap = null;
        }
        this.canvasForRendering = null;
    }

    /* access modifiers changed from: private */
    public void removeGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void resetIfStarted() {
        if (this.isAnimationStarted) {
            resetShimmering();
            startShimmerAnimation();
        }
    }

    private void resetShimmering() {
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.maskAnimator.removeAllUpdateListeners();
        }
        this.maskAnimator = null;
        this.isAnimationStarted = false;
        releaseBitMaps();
    }

    private Point rotatePoint(Point point, float f11, float f12, float f13) {
        float[] fArr = {(float) point.x, (float) point.y};
        Matrix matrix = new Matrix();
        matrix.setRotate(f11, f12, f13);
        matrix.mapPoints(fArr);
        return new Point((int) fArr[0], (int) fArr[1]);
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.isAnimationStarted || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawUsingBitmap(canvas);
        }
    }

    public void onDetachedFromWindow() {
        resetShimmering();
        super.onDetachedFromWindow();
    }

    public void setShimmerAngle(int i11) {
        if (i11 < 0 || 30 < i11) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", new Object[]{0, 30}));
        }
        this.shimmerAngle = i11;
        resetIfStarted();
    }

    public void setShimmerAnimationDuration(int i11) {
        this.shimmerAnimationDuration = i11;
        resetIfStarted();
    }

    public void setShimmerColor(int i11) {
        this.shimmerColor = getColor(R.color.gem_card_4);
        resetIfStarted();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 != 0) {
            stopShimmerAnimation();
        } else if (this.autoStart) {
            startShimmerAnimation();
        }
    }

    public void startShimmerAnimation() {
        if (!this.isAnimationStarted) {
            if (getWidth() == 0) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        ShimmerLayout.this.removeGlobalLayoutListener(this);
                        ShimmerLayout.this.startShimmerAnimation();
                    }
                });
                return;
            }
            getShimmerAnimation().start();
            this.isAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        resetShimmering();
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.maskPaint = paint;
        paint.setAntiAlias(true);
        this.maskPaint.setDither(true);
        this.maskPaint.setFilterBitmap(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.talabat.talabatcommon.R.styleable.ShimmerLayout, 0, 0);
        try {
            this.shimmerAngle = obtainStyledAttributes.getInteger(0, 20);
            this.shimmerAnimationDuration = obtainStyledAttributes.getInteger(1, 1500);
            this.shimmerColor = obtainStyledAttributes.getColor(3, getColor(R.color.default_shimmer_color));
            this.autoStart = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            setShimmerAngle(this.shimmerAngle);
            if (this.autoStart && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
