package io.supercharge.shimmerlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class ShimmerLayout extends FrameLayout {
    private static final byte DEFAULT_ANGLE = 20;
    private static final int DEFAULT_ANIMATION_DURATION = 1500;
    private static final byte MAX_ANGLE_VALUE = 45;
    private static final byte MAX_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 1;
    private static final byte MAX_MASK_WIDTH_VALUE = 1;
    private static final byte MIN_ANGLE_VALUE = -45;
    private static final byte MIN_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 0;
    private static final byte MIN_MASK_WIDTH_VALUE = 0;
    private boolean autoStart;
    private Canvas canvasForShimmerMask;
    private float gradientCenterColorWidth;
    private Paint gradientTexturePaint;
    private boolean isAnimationReversed;
    private boolean isAnimationStarted;
    private Bitmap localMaskBitmap;
    private ValueAnimator maskAnimator;
    private Bitmap maskBitmap;
    /* access modifiers changed from: private */
    public int maskOffsetX;
    private Rect maskRect;
    private float maskWidth;
    private int shimmerAngle;
    private int shimmerAnimationDuration;
    private int shimmerColor;
    private ViewTreeObserver.OnPreDrawListener startAnimationPreDrawListener;

    public ShimmerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private Rect calculateBitmapMaskRect() {
        return new Rect(0, 0, calculateMaskWidth(), getHeight());
    }

    private int calculateMaskWidth() {
        return (int) ((((double) (((float) (getWidth() / 2)) * this.maskWidth)) / Math.cos(Math.toRadians((double) Math.abs(this.shimmerAngle)))) + (((double) getHeight()) * Math.tan(Math.toRadians((double) Math.abs(this.shimmerAngle)))));
    }

    private Bitmap createBitmap(int i11, int i12) {
        try {
            return Bitmap.createBitmap(i11, i12, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    private void createShimmerPaint() {
        float f11;
        if (this.gradientTexturePaint == null) {
            int reduceColorAlphaValueToZero = reduceColorAlphaValueToZero(this.shimmerColor);
            float width = ((float) (getWidth() / 2)) * this.maskWidth;
            if (this.shimmerAngle >= 0) {
                f11 = (float) getHeight();
            } else {
                f11 = 0.0f;
            }
            float f12 = f11;
            int i11 = this.shimmerColor;
            LinearGradient linearGradient = new LinearGradient(0.0f, f12, ((float) Math.cos(Math.toRadians((double) this.shimmerAngle))) * width, f12 + (((float) Math.sin(Math.toRadians((double) this.shimmerAngle))) * width), new int[]{reduceColorAlphaValueToZero, i11, i11, reduceColorAlphaValueToZero}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
            Bitmap bitmap = this.localMaskBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.gradientTexturePaint = paint;
            paint.setAntiAlias(true);
            this.gradientTexturePaint.setDither(true);
            this.gradientTexturePaint.setFilterBitmap(true);
            this.gradientTexturePaint.setShader(composeShader);
        }
    }

    private void dispatchDrawShimmer(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap2 = getMaskBitmap();
        this.localMaskBitmap = maskBitmap2;
        if (maskBitmap2 != null) {
            if (this.canvasForShimmerMask == null) {
                this.canvasForShimmerMask = new Canvas(this.localMaskBitmap);
            }
            this.canvasForShimmerMask.drawColor(0, PorterDuff.Mode.CLEAR);
            this.canvasForShimmerMask.save();
            this.canvasForShimmerMask.translate((float) (-this.maskOffsetX), 0.0f);
            super.dispatchDraw(this.canvasForShimmerMask);
            this.canvasForShimmerMask.restore();
            drawShimmer(canvas);
            this.localMaskBitmap = null;
        }
    }

    private void drawShimmer(Canvas canvas) {
        createShimmerPaint();
        canvas.save();
        canvas.translate((float) this.maskOffsetX, 0.0f);
        Rect rect = this.maskRect;
        canvas.drawRect((float) rect.left, 0.0f, (float) rect.width(), (float) this.maskRect.height(), this.gradientTexturePaint);
        canvas.restore();
    }

    private int getColor(int i11) {
        return getContext().getColor(i11);
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f11 = this.gradientCenterColorWidth;
        fArr[1] = 0.5f - (f11 / 2.0f);
        fArr[2] = (f11 / 2.0f) + 0.5f;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        if (this.maskBitmap == null) {
            this.maskBitmap = createBitmap(this.maskRect.width(), getHeight());
        }
        return this.maskBitmap;
    }

    private Animator getShimmerAnimation() {
        final int i11;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.maskAnimator;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.maskRect == null) {
            this.maskRect = calculateBitmapMaskRect();
        }
        int width = getWidth();
        if (getWidth() > this.maskRect.width()) {
            i11 = -width;
        } else {
            i11 = -this.maskRect.width();
        }
        final int width2 = this.maskRect.width();
        int i12 = width - i11;
        if (this.isAnimationReversed) {
            valueAnimator = ValueAnimator.ofInt(new int[]{i12, 0});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{0, i12});
        }
        this.maskAnimator = valueAnimator;
        valueAnimator.setDuration((long) this.shimmerAnimationDuration);
        this.maskAnimator.setRepeatCount(-1);
        this.maskAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ShimmerLayout.this.maskOffsetX = i11 + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (ShimmerLayout.this.maskOffsetX + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.maskAnimator;
    }

    private int reduceColorAlphaValueToZero(int i11) {
        return Color.argb(0, Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private void releaseBitMaps() {
        this.canvasForShimmerMask = null;
        Bitmap bitmap = this.maskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.maskBitmap = null;
        }
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
        this.gradientTexturePaint = null;
        this.isAnimationStarted = false;
        releaseBitMaps();
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.isAnimationStarted || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawShimmer(canvas);
        }
    }

    public void onDetachedFromWindow() {
        resetShimmering();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z11) {
        this.isAnimationReversed = z11;
        resetIfStarted();
    }

    public void setGradientCenterColorWidth(float f11) {
        if (f11 <= 0.0f || 1.0f <= f11) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.gradientCenterColorWidth = f11;
        resetIfStarted();
    }

    public void setMaskWidth(float f11) {
        if (f11 <= 0.0f || 1.0f < f11) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.maskWidth = f11;
        resetIfStarted();
    }

    public void setShimmerAngle(int i11) {
        if (i11 < -45 || 45 < i11) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", new Object[]{Byte.valueOf(MIN_ANGLE_VALUE), Byte.valueOf(MAX_ANGLE_VALUE)}));
        }
        this.shimmerAngle = i11;
        resetIfStarted();
    }

    public void setShimmerAnimationDuration(int i11) {
        this.shimmerAnimationDuration = i11;
        resetIfStarted();
    }

    public void setShimmerColor(int i11) {
        this.shimmerColor = i11;
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
                this.startAnimationPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        ShimmerLayout.this.startShimmerAnimation();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.startAnimationPreDrawListener);
                return;
            }
            getShimmerAnimation().start();
            this.isAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.startAnimationPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.startAnimationPreDrawListener);
        }
        resetShimmering();
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ShimmerLayout, 0, 0);
        try {
            this.shimmerAngle = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_angle, 20);
            this.shimmerAnimationDuration = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_animation_duration, 1500);
            this.shimmerColor = obtainStyledAttributes.getColor(R.styleable.ShimmerLayout_shimmer_color, getColor(R.color.shimmer_color));
            this.autoStart = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_auto_start, false);
            this.maskWidth = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.gradientCenterColorWidth = obtainStyledAttributes.getFloat(R.styleable.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.isAnimationReversed = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_reverse_animation, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.maskWidth);
            setGradientCenterColorWidth(this.gradientCenterColorWidth);
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
