package com.talabat.helpers;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.talabat.talabatcommon.R;

public class SimpleRatingBar extends View {
    @ColorInt
    private int backgroundColor;
    @ColorInt
    private int borderColor;
    private View.OnClickListener clickListener;
    private CornerPathEffect cornerPathEffect;
    private float currentStarSize;
    private float defaultStarSize;
    private float desiredStarSize;
    private boolean drawBorderEnabled;
    @ColorInt
    private int fillColor;
    private Gravity gravity;
    private Bitmap internalBitmap;
    private Canvas internalCanvas;
    private boolean isIndicator;
    private float maxStarSize;
    private int numberOfStars;
    private Paint paintStarBackground;
    private Paint paintStarBorder;
    private Paint paintStarFill;
    private Paint paintStarOutline;
    @ColorInt
    private int pressedBackgroundColor;
    @ColorInt
    private int pressedBorderColor;
    @ColorInt
    private int pressedFillColor;
    @ColorInt
    private int pressedStarBackgroundColor;
    /* access modifiers changed from: private */
    public float rating;
    private ValueAnimator ratingAnimator;
    /* access modifiers changed from: private */
    public OnRatingBarChangeListener ratingListener;
    @ColorInt
    private int starBackgroundColor;
    private float starBorderWidth;
    private float starCornerRadius;
    private Path starPath;
    private float[] starVertex;
    private RectF starsDrawingSpace;
    private float starsSeparation;
    private RectF starsTouchSpace;
    private float stepSize;
    private boolean touchInProgress;

    public class AnimationBuilder {
        /* access modifiers changed from: private */
        public Animator.AnimatorListener animatorListener;
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public Interpolator interpolator;
        private SimpleRatingBar ratingBar;
        /* access modifiers changed from: private */
        public float ratingTarget;
        /* access modifiers changed from: private */
        public int repeatCount;
        /* access modifiers changed from: private */
        public int repeatMode;

        private AnimationBuilder(SimpleRatingBar simpleRatingBar) {
            this.ratingBar = simpleRatingBar;
            this.duration = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            this.interpolator = new BounceInterpolator();
            this.ratingTarget = (float) simpleRatingBar.getNumberOfStars();
            this.repeatCount = 1;
            this.repeatMode = 2;
        }

        public AnimationBuilder setAnimatorListener(Animator.AnimatorListener animatorListener2) {
            this.animatorListener = animatorListener2;
            return this;
        }

        public AnimationBuilder setDuration(long j11) {
            this.duration = j11;
            return this;
        }

        public AnimationBuilder setInterpolator(Interpolator interpolator2) {
            this.interpolator = interpolator2;
            return this;
        }

        public AnimationBuilder setRatingTarget(float f11) {
            this.ratingTarget = f11;
            return this;
        }

        public AnimationBuilder setRepeatCount(int i11) {
            this.repeatCount = i11;
            return this;
        }

        public AnimationBuilder setRepeatMode(int i11) {
            this.repeatMode = i11;
            return this;
        }

        public void start() {
            this.ratingBar.animateRating(this);
        }
    }

    public enum Gravity {
        Left(0),
        Right(1);
        

        /* renamed from: b  reason: collision with root package name */
        public int f60850b;

        private Gravity(int i11) {
            this.f60850b = i11;
        }

        public static Gravity a(int i11) {
            for (Gravity gravity : values()) {
                if (gravity.f60850b == i11) {
                    return gravity;
                }
            }
            Log.w(BaseRatingBar.TAG, String.format("Gravity chosen is neither 'left' nor 'right', I will set it to Left", new Object[0]));
            return Left;
        }
    }

    public interface OnRatingBarChangeListener {
        void onRatingChanged(SimpleRatingBar simpleRatingBar, float f11, boolean z11);
    }

    public SimpleRatingBar(Context context) {
        super(context);
        initView();
    }

    /* access modifiers changed from: private */
    public void animateRating(AnimationBuilder animationBuilder) {
        animationBuilder.ratingTarget = normalizeRating(animationBuilder.ratingTarget);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, animationBuilder.ratingTarget});
        this.ratingAnimator = ofFloat;
        ofFloat.setDuration(animationBuilder.duration);
        this.ratingAnimator.setRepeatCount(animationBuilder.repeatCount);
        this.ratingAnimator.setRepeatMode(animationBuilder.repeatMode);
        this.ratingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimpleRatingBar.this.setRating(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (animationBuilder.interpolator != null) {
            this.ratingAnimator.setInterpolator(animationBuilder.interpolator);
        }
        if (animationBuilder.animatorListener != null) {
            this.ratingAnimator.addListener(animationBuilder.animatorListener);
        }
        this.ratingAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                if (SimpleRatingBar.this.ratingListener != null) {
                    OnRatingBarChangeListener b11 = SimpleRatingBar.this.ratingListener;
                    SimpleRatingBar simpleRatingBar = SimpleRatingBar.this;
                    b11.onRatingChanged(simpleRatingBar, simpleRatingBar.rating, false);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (SimpleRatingBar.this.ratingListener != null) {
                    OnRatingBarChangeListener b11 = SimpleRatingBar.this.ratingListener;
                    SimpleRatingBar simpleRatingBar = SimpleRatingBar.this;
                    b11.onRatingChanged(simpleRatingBar, simpleRatingBar.rating, false);
                }
            }

            public void onAnimationRepeat(Animator animator) {
                if (SimpleRatingBar.this.ratingListener != null) {
                    OnRatingBarChangeListener b11 = SimpleRatingBar.this.ratingListener;
                    SimpleRatingBar simpleRatingBar = SimpleRatingBar.this;
                    b11.onRatingChanged(simpleRatingBar, simpleRatingBar.rating, false);
                }
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        this.ratingAnimator.start();
    }

    private float calculateBestStarSize(int i11, int i12) {
        float f11 = this.maxStarSize;
        if (f11 != 2.14748365E9f) {
            float calculateTotalHeight = (float) calculateTotalHeight(this.maxStarSize, this.numberOfStars, this.starsSeparation, true);
            if (((float) calculateTotalWidth(f11, this.numberOfStars, this.starsSeparation, true)) < ((float) i11) && calculateTotalHeight < ((float) i12)) {
                return this.maxStarSize;
            }
            float f12 = this.starsSeparation;
            int i13 = this.numberOfStars;
            return Math.min((((float) ((i11 - getPaddingLeft()) - getPaddingRight())) - (f12 * ((float) (i13 - 1)))) / ((float) i13), (float) ((i12 - getPaddingTop()) - getPaddingBottom()));
        }
        float f13 = this.starsSeparation;
        int i14 = this.numberOfStars;
        return Math.min((((float) ((i11 - getPaddingLeft()) - getPaddingRight())) - (f13 * ((float) (i14 - 1)))) / ((float) i14), (float) ((i12 - getPaddingTop()) - getPaddingBottom()));
    }

    private int calculateTotalHeight(float f11, int i11, float f12, boolean z11) {
        return Math.round(f11) + (z11 ? getPaddingTop() + getPaddingBottom() : 0);
    }

    private int calculateTotalWidth(float f11, int i11, float f12, boolean z11) {
        int i12;
        int round = Math.round((f11 * ((float) i11)) + (f12 * ((float) (i11 - 1))));
        if (z11) {
            i12 = getPaddingLeft() + getPaddingRight();
        } else {
            i12 = 0;
        }
        return round + i12;
    }

    private void drawFromLeftToRight(Canvas canvas) {
        float f11 = this.rating;
        RectF rectF = this.starsDrawingSpace;
        float f12 = rectF.left;
        float f13 = rectF.top;
        float f14 = f11;
        for (int i11 = 0; i11 < this.numberOfStars; i11++) {
            if (f14 >= 1.0f) {
                drawStar(canvas, f12, f13, 1.0f, Gravity.Left);
                f14 -= 1.0f;
            } else {
                drawStar(canvas, f12, f13, f14, Gravity.Left);
                f14 = 0.0f;
            }
            f12 += this.starsSeparation + this.currentStarSize;
        }
    }

    private void drawFromRightToLeft(Canvas canvas) {
        float f11 = this.rating;
        RectF rectF = this.starsDrawingSpace;
        float f12 = rectF.right - this.currentStarSize;
        float f13 = rectF.top;
        float f14 = f11;
        for (int i11 = 0; i11 < this.numberOfStars; i11++) {
            if (f14 >= 1.0f) {
                drawStar(canvas, f12, f13, 1.0f, Gravity.Right);
                f14 -= 1.0f;
            } else {
                drawStar(canvas, f12, f13, f14, Gravity.Right);
                f14 = 0.0f;
            }
            f12 -= this.starsSeparation + this.currentStarSize;
        }
    }

    private void drawStar(Canvas canvas, float f11, float f12, float f13, Gravity gravity2) {
        float f14 = this.currentStarSize * f13;
        this.starPath.reset();
        Path path = this.starPath;
        float[] fArr = this.starVertex;
        path.moveTo(fArr[0] + f11, fArr[1] + f12);
        int i11 = 2;
        while (true) {
            float[] fArr2 = this.starVertex;
            if (i11 >= fArr2.length) {
                break;
            }
            this.starPath.lineTo(fArr2[i11] + f11, fArr2[i11 + 1] + f12);
            i11 += 2;
        }
        this.starPath.close();
        canvas.drawPath(this.starPath, this.paintStarOutline);
        if (gravity2 == Gravity.Left) {
            float f15 = f11 + f14;
            float f16 = this.currentStarSize;
            canvas.drawRect(f11, f12, f15 + (0.02f * f16), f12 + f16, this.paintStarFill);
            float f17 = this.currentStarSize;
            canvas.drawRect(f15, f12, f11 + f17, f12 + f17, this.paintStarBackground);
        } else {
            float f18 = this.currentStarSize;
            canvas.drawRect((f11 + f18) - ((0.02f * f18) + f14), f12, f11 + f18, f12 + f18, this.paintStarFill);
            float f19 = this.currentStarSize;
            canvas.drawRect(f11, f12, (f11 + f19) - f14, f12 + f19, this.paintStarBackground);
        }
        if (this.drawBorderEnabled) {
            canvas.drawPath(this.starPath, this.paintStarBorder);
        }
    }

    private void generateInternalCanvas(int i11, int i12) {
        Bitmap bitmap = this.internalBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (i11 > 0 && i12 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.internalBitmap = createBitmap;
            createBitmap.eraseColor(0);
            this.internalCanvas = new Canvas(this.internalBitmap);
        }
    }

    private void initView() {
        this.starPath = new Path();
        this.cornerPathEffect = new CornerPathEffect(this.starCornerRadius);
        Paint paint = new Paint(5);
        this.paintStarOutline = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paintStarOutline.setAntiAlias(true);
        this.paintStarOutline.setDither(true);
        this.paintStarOutline.setStrokeJoin(Paint.Join.ROUND);
        this.paintStarOutline.setStrokeCap(Paint.Cap.ROUND);
        this.paintStarOutline.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paintStarOutline.setPathEffect(this.cornerPathEffect);
        Paint paint2 = new Paint(5);
        this.paintStarBorder = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.paintStarBorder.setStrokeJoin(Paint.Join.ROUND);
        this.paintStarBorder.setStrokeCap(Paint.Cap.ROUND);
        this.paintStarBorder.setStrokeWidth(this.starBorderWidth);
        this.paintStarBorder.setPathEffect(this.cornerPathEffect);
        Paint paint3 = new Paint(5);
        this.paintStarBackground = paint3;
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paintStarBackground.setAntiAlias(true);
        this.paintStarBackground.setDither(true);
        this.paintStarBackground.setStrokeJoin(Paint.Join.ROUND);
        this.paintStarBackground.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint(5);
        this.paintStarFill = paint4;
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paintStarFill.setAntiAlias(true);
        this.paintStarFill.setDither(true);
        this.paintStarFill.setStrokeJoin(Paint.Join.ROUND);
        this.paintStarFill.setStrokeCap(Paint.Cap.ROUND);
        this.defaultStarSize = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
    }

    private float normalizeRating(float f11) {
        if (f11 < 0.0f) {
            Log.w(BaseRatingBar.TAG, String.format("Assigned rating is less than 0 (%f < 0), I will set it to exactly 0", new Object[]{Float.valueOf(f11)}));
            return 0.0f;
        } else if (f11 <= ((float) this.numberOfStars)) {
            return f11;
        } else {
            Log.w(BaseRatingBar.TAG, String.format("Assigned rating is greater than numberOfStars (%f > %d), I will set it to exactly numberOfStars", new Object[]{Float.valueOf(f11), Integer.valueOf(this.numberOfStars)}));
            return (float) this.numberOfStars;
        }
    }

    private void parseAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SimpleRatingBar);
        int color = obtainStyledAttributes.getColor(1, getResources().getColor(com.talabat.R.color.golden_stars));
        this.borderColor = color;
        this.fillColor = obtainStyledAttributes.getColor(3, color);
        this.starBackgroundColor = obtainStyledAttributes.getColor(13, 0);
        this.backgroundColor = obtainStyledAttributes.getColor(0, 0);
        this.pressedBorderColor = obtainStyledAttributes.getColor(9, this.borderColor);
        this.pressedFillColor = obtainStyledAttributes.getColor(10, this.fillColor);
        this.pressedStarBackgroundColor = obtainStyledAttributes.getColor(11, this.starBackgroundColor);
        this.pressedBackgroundColor = obtainStyledAttributes.getColor(8, this.backgroundColor);
        this.numberOfStars = obtainStyledAttributes.getInteger(7, 5);
        this.starsSeparation = (float) obtainStyledAttributes.getDimensionPixelSize(17, (int) valueToPixels(4.0f, 0));
        this.maxStarSize = (float) obtainStyledAttributes.getDimensionPixelSize(6, Integer.MAX_VALUE);
        this.desiredStarSize = (float) obtainStyledAttributes.getDimensionPixelSize(16, Integer.MAX_VALUE);
        this.stepSize = obtainStyledAttributes.getFloat(18, 0.1f);
        this.starBorderWidth = obtainStyledAttributes.getFloat(14, 5.0f);
        this.starCornerRadius = obtainStyledAttributes.getFloat(15, 0.0f);
        this.rating = normalizeRating(obtainStyledAttributes.getFloat(12, 1.0f));
        this.isIndicator = obtainStyledAttributes.getBoolean(5, false);
        this.drawBorderEnabled = obtainStyledAttributes.getBoolean(2, true);
        this.gravity = Gravity.a(obtainStyledAttributes.getInt(4, Gravity.Left.f60850b));
        obtainStyledAttributes.recycle();
        validateAttrs();
    }

    private void performStarSizeAssociatedCalculations(int i11, int i12) {
        float calculateTotalWidth = (float) calculateTotalWidth(this.currentStarSize, this.numberOfStars, this.starsSeparation, false);
        float calculateTotalHeight = (float) calculateTotalHeight(this.currentStarSize, this.numberOfStars, this.starsSeparation, false);
        float paddingLeft = (((float) (((i11 - getPaddingLeft()) - getPaddingRight()) / 2)) - (calculateTotalWidth / 2.0f)) + ((float) getPaddingLeft());
        float paddingTop = (((float) (((i12 - getPaddingTop()) - getPaddingBottom()) / 2)) - (calculateTotalHeight / 2.0f)) + ((float) getPaddingTop());
        RectF rectF = new RectF(paddingLeft, paddingTop, calculateTotalWidth + paddingLeft, calculateTotalHeight + paddingTop);
        this.starsDrawingSpace = rectF;
        float width = rectF.width() * 0.05f;
        RectF rectF2 = this.starsDrawingSpace;
        this.starsTouchSpace = new RectF(rectF2.left - width, rectF2.top, rectF2.right + width, rectF2.bottom);
        float f11 = this.currentStarSize;
        float f12 = 0.2f * f11;
        float f13 = 0.35f * f11;
        float f14 = 0.5f * f11;
        float f15 = 0.05f * f11;
        float f16 = 0.03f * f11;
        float f17 = 0.38f * f11;
        float f18 = 0.32f * f11;
        float f19 = 0.6f * f11;
        this.starVertex = new float[]{f16, f17, f16 + f13, f17, f14, f15, (f11 - f16) - f13, f17, f11 - f16, f17, f11 - f18, f19, f11 - f12, f11 - f15, f14, f11 - (0.27f * f11), f12, f11 - f15, f18, f19};
    }

    private void setNewRatingFromTouch(float f11, float f12) {
        if (this.gravity != Gravity.Left) {
            f11 = ((float) getWidth()) - f11;
        }
        RectF rectF = this.starsDrawingSpace;
        float f13 = rectF.left;
        if (f11 < f13) {
            this.rating = 0.0f;
        } else if (f11 > rectF.right) {
            this.rating = (float) this.numberOfStars;
        } else {
            float width = (((float) this.numberOfStars) / rectF.width()) * (f11 - f13);
            this.rating = width;
            float f14 = this.stepSize;
            float f15 = width % f14;
            if (f15 < f14 / 4.0f) {
                float f16 = width - f15;
                this.rating = f16;
                this.rating = Math.max(0.0f, f16);
                return;
            }
            float f17 = (width - f15) + f14;
            this.rating = f17;
            this.rating = Math.min((float) this.numberOfStars, f17);
        }
    }

    private void setupColorsInPaint() {
        if (this.touchInProgress) {
            this.paintStarBorder.setColor(this.pressedBorderColor);
            this.paintStarFill.setColor(this.pressedFillColor);
            if (this.pressedFillColor != 0) {
                this.paintStarFill.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.paintStarFill.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            this.paintStarBackground.setColor(this.pressedStarBackgroundColor);
            if (this.pressedStarBackgroundColor != 0) {
                this.paintStarBackground.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.paintStarBackground.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
        } else {
            this.paintStarBorder.setColor(this.borderColor);
            this.paintStarFill.setColor(this.fillColor);
            if (this.fillColor != 0) {
                this.paintStarFill.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.paintStarFill.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            this.paintStarBackground.setColor(this.starBackgroundColor);
            if (this.starBackgroundColor != 0) {
                this.paintStarBackground.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.paintStarBackground.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
        }
    }

    private void validateAttrs() {
        if (this.numberOfStars > 0) {
            float f11 = this.desiredStarSize;
            if (f11 != 2.14748365E9f) {
                float f12 = this.maxStarSize;
                if (f12 != 2.14748365E9f && f11 > f12) {
                    Log.w(BaseRatingBar.TAG, String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", new Object[]{Float.valueOf(f11), Float.valueOf(this.maxStarSize)}));
                }
            }
            if (this.stepSize <= 0.0f) {
                throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", new Object[]{Float.valueOf(this.stepSize)}));
            } else if (this.starBorderWidth <= 0.0f) {
                throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", new Object[]{Float.valueOf(this.starBorderWidth)}));
            } else if (this.starCornerRadius < 0.0f) {
                throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", new Object[]{Float.valueOf(this.starBorderWidth)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", new Object[]{Integer.valueOf(this.numberOfStars)}));
        }
    }

    private float valueFromPixels(float f11, @Dimension int i11) {
        float f12;
        if (i11 == 0) {
            f12 = getResources().getDisplayMetrics().density;
        } else if (i11 != 2) {
            return f11;
        } else {
            f12 = getResources().getDisplayMetrics().scaledDensity;
        }
        return f11 / f12;
    }

    private float valueToPixels(float f11, @Dimension int i11) {
        if (i11 == 0) {
            return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
        }
        if (i11 != 2) {
            return f11;
        }
        return TypedValue.applyDimension(2, f11, getResources().getDisplayMetrics());
    }

    public AnimationBuilder getAnimationBuilder() {
        return new AnimationBuilder(this);
    }

    @ColorInt
    public int getBorderColor() {
        return this.borderColor;
    }

    @ColorInt
    public int getFillColor() {
        return this.fillColor;
    }

    public Gravity getGravity() {
        return this.gravity;
    }

    public float getMaxStarSize() {
        return this.maxStarSize;
    }

    public int getNumberOfStars() {
        return this.numberOfStars;
    }

    @ColorInt
    public int getPressedBorderColor() {
        return this.pressedBorderColor;
    }

    @ColorInt
    public int getPressedFillColor() {
        return this.pressedFillColor;
    }

    @ColorInt
    public int getPressedStarBackgroundColor() {
        return this.pressedStarBackgroundColor;
    }

    public float getRating() {
        return this.rating;
    }

    @ColorInt
    public int getStarBackgroundColor() {
        return this.starBackgroundColor;
    }

    public float getStarBorderWidth() {
        return this.starBorderWidth;
    }

    public float getStarCornerRadius() {
        return this.starCornerRadius;
    }

    public float getStarSize() {
        return this.currentStarSize;
    }

    public float getStarsSeparation() {
        return this.starsSeparation;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public boolean isDrawBorderEnabled() {
        return this.drawBorderEnabled;
    }

    public boolean isIndicator() {
        return this.isIndicator;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        if (getWidth() != 0 && height != 0) {
            this.internalCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            setupColorsInPaint();
            if (this.gravity == Gravity.Left) {
                drawFromLeftToRight(this.internalCanvas);
            } else {
                drawFromRightToLeft(this.internalCanvas);
            }
            if (this.touchInProgress) {
                canvas.drawColor(this.pressedBackgroundColor);
            } else {
                canvas.drawColor(this.backgroundColor);
            }
            canvas.drawBitmap(this.internalBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        int width = getWidth();
        int height = getHeight();
        float f11 = this.desiredStarSize;
        if (f11 == 2.14748365E9f) {
            this.currentStarSize = calculateBestStarSize(width, height);
        } else {
            this.currentStarSize = f11;
        }
        performStarSizeAssociatedCalculations(width, height);
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                float f11 = this.desiredStarSize;
                if (f11 != 2.14748365E9f) {
                    size = Math.min(calculateTotalWidth(f11, this.numberOfStars, this.starsSeparation, true), size);
                } else {
                    float f12 = this.maxStarSize;
                    if (f12 != 2.14748365E9f) {
                        size = Math.min(calculateTotalWidth(f12, this.numberOfStars, this.starsSeparation, true), size);
                    } else {
                        size = Math.min(calculateTotalWidth(this.defaultStarSize, this.numberOfStars, this.starsSeparation, true), size);
                    }
                }
            } else {
                float f13 = this.desiredStarSize;
                if (f13 != 2.14748365E9f) {
                    size = calculateTotalWidth(f13, this.numberOfStars, this.starsSeparation, true);
                } else {
                    float f14 = this.maxStarSize;
                    if (f14 != 2.14748365E9f) {
                        size = calculateTotalWidth(f14, this.numberOfStars, this.starsSeparation, true);
                    } else {
                        size = calculateTotalWidth(this.defaultStarSize, this.numberOfStars, this.starsSeparation, true);
                    }
                }
            }
        }
        float f15 = this.starsSeparation;
        int i13 = this.numberOfStars;
        float paddingLeft = (((float) ((size - getPaddingLeft()) - getPaddingRight())) - (((float) (i13 - 1)) * f15)) / ((float) i13);
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                float f16 = this.desiredStarSize;
                if (f16 != 2.14748365E9f) {
                    size2 = Math.min(calculateTotalHeight(f16, i13, f15, true), size2);
                } else {
                    float f17 = this.maxStarSize;
                    if (f17 != 2.14748365E9f) {
                        size2 = Math.min(calculateTotalHeight(f17, i13, f15, true), size2);
                    } else {
                        size2 = Math.min(calculateTotalHeight(paddingLeft, i13, f15, true), size2);
                    }
                }
            } else {
                float f18 = this.desiredStarSize;
                if (f18 != 2.14748365E9f) {
                    size2 = calculateTotalHeight(f18, i13, f15, true);
                } else {
                    float f19 = this.maxStarSize;
                    if (f19 != 2.14748365E9f) {
                        size2 = calculateTotalHeight(f19, i13, f15, true);
                    } else {
                        size2 = calculateTotalHeight(paddingLeft, i13, f15, true);
                    }
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRating(savedState.rating);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.rating = getRating();
        return savedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        generateInternalCanvas(i11, i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r0 != 3) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isIndicator
            r1 = 0
            if (r0 != 0) goto L_0x0070
            android.animation.ValueAnimator r0 = r5.ratingAnimator
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0010
            goto L_0x0070
        L_0x0010:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r0 == 0) goto L_0x0040
            if (r0 == r2) goto L_0x0022
            r3 = 2
            if (r0 == r3) goto L_0x0040
            r6 = 3
            if (r0 == r6) goto L_0x0034
            goto L_0x005d
        L_0x0022:
            float r0 = r6.getX()
            float r6 = r6.getY()
            r5.setNewRatingFromTouch(r0, r6)
            android.view.View$OnClickListener r6 = r5.clickListener
            if (r6 == 0) goto L_0x0034
            r6.onClick(r5)
        L_0x0034:
            com.talabat.helpers.SimpleRatingBar$OnRatingBarChangeListener r6 = r5.ratingListener
            if (r6 == 0) goto L_0x003d
            float r0 = r5.rating
            r6.onRatingChanged(r5, r0, r2)
        L_0x003d:
            r5.touchInProgress = r1
            goto L_0x005d
        L_0x0040:
            android.graphics.RectF r0 = r5.starsTouchSpace
            float r3 = r6.getX()
            float r4 = r6.getY()
            boolean r0 = r0.contains(r3, r4)
            if (r0 == 0) goto L_0x0061
            r5.touchInProgress = r2
            float r0 = r6.getX()
            float r6 = r6.getY()
            r5.setNewRatingFromTouch(r0, r6)
        L_0x005d:
            r5.invalidate()
            return r2
        L_0x0061:
            boolean r6 = r5.touchInProgress
            if (r6 == 0) goto L_0x006e
            com.talabat.helpers.SimpleRatingBar$OnRatingBarChangeListener r6 = r5.ratingListener
            if (r6 == 0) goto L_0x006e
            float r0 = r5.rating
            r6.onRatingChanged(r5, r0, r2)
        L_0x006e:
            r5.touchInProgress = r1
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.SimpleRatingBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBorderColor(@ColorInt int i11) {
        this.borderColor = i11;
        invalidate();
    }

    public void setDrawBorderEnabled(boolean z11) {
        this.drawBorderEnabled = z11;
        invalidate();
    }

    public void setFillColor(@ColorInt int i11) {
        this.fillColor = i11;
        invalidate();
    }

    public void setGravity(Gravity gravity2) {
        this.gravity = gravity2;
        invalidate();
    }

    public void setIndicator(boolean z11) {
        this.isIndicator = z11;
        this.touchInProgress = false;
    }

    public void setMaxStarSize(float f11) {
        this.maxStarSize = f11;
        if (this.currentStarSize > f11) {
            requestLayout();
            generateInternalCanvas(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setNumberOfStars(int i11) {
        this.numberOfStars = i11;
        if (i11 > 0) {
            this.rating = 0.0f;
            requestLayout();
            generateInternalCanvas(getWidth(), getHeight());
            invalidate();
            return;
        }
        throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", new Object[]{Integer.valueOf(i11)}));
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public void setOnRatingBarChangeListener(OnRatingBarChangeListener onRatingBarChangeListener) {
        this.ratingListener = onRatingBarChangeListener;
    }

    public void setPressedBorderColor(@ColorInt int i11) {
        this.pressedBorderColor = i11;
        invalidate();
    }

    public void setPressedFillColor(@ColorInt int i11) {
        this.pressedFillColor = i11;
        invalidate();
    }

    public void setPressedStarBackgroundColor(@ColorInt int i11) {
        this.pressedStarBackgroundColor = i11;
        invalidate();
    }

    public void setRating(float f11) {
        this.rating = normalizeRating(f11);
        invalidate();
        if (this.ratingListener != null) {
            ValueAnimator valueAnimator = this.ratingAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.ratingListener.onRatingChanged(this, f11, false);
            }
        }
    }

    public void setStarBackgroundColor(@ColorInt int i11) {
        this.starBackgroundColor = i11;
        invalidate();
    }

    public void setStarBorderWidth(float f11) {
        this.starBorderWidth = f11;
        if (f11 > 0.0f) {
            this.paintStarBorder.setStrokeWidth(f11);
            invalidate();
            return;
        }
        throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", new Object[]{Float.valueOf(f11)}));
    }

    public void setStarCornerRadius(float f11) {
        this.starCornerRadius = f11;
        if (f11 >= 0.0f) {
            CornerPathEffect cornerPathEffect2 = new CornerPathEffect(f11);
            this.cornerPathEffect = cornerPathEffect2;
            this.paintStarBorder.setPathEffect(cornerPathEffect2);
            this.paintStarOutline.setPathEffect(this.cornerPathEffect);
            invalidate();
            return;
        }
        throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", new Object[]{Float.valueOf(f11)}));
    }

    public void setStarSize(float f11) {
        this.desiredStarSize = f11;
        if (f11 != 2.14748365E9f) {
            float f12 = this.maxStarSize;
            if (f12 != 2.14748365E9f && f11 > f12) {
                Log.w(BaseRatingBar.TAG, String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", new Object[]{Float.valueOf(f11), Float.valueOf(this.maxStarSize)}));
            }
        }
        requestLayout();
        generateInternalCanvas(getWidth(), getHeight());
        invalidate();
    }

    public void setStarsSeparation(float f11) {
        this.starsSeparation = f11;
        requestLayout();
        generateInternalCanvas(getWidth(), getHeight());
        invalidate();
    }

    public void setStepSize(float f11) {
        this.stepSize = f11;
        if (f11 > 0.0f) {
            invalidate();
        } else {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", new Object[]{Float.valueOf(f11)}));
        }
    }

    public float getMaxStarSize(@Dimension int i11) {
        return valueFromPixels(this.maxStarSize, i11);
    }

    public float getStarBorderWidth(@Dimension int i11) {
        return valueFromPixels(this.starBorderWidth, i11);
    }

    public float getStarCornerRadius(@Dimension int i11) {
        return valueFromPixels(this.starCornerRadius, i11);
    }

    public float getStarSize(@Dimension int i11) {
        return valueFromPixels(this.currentStarSize, i11);
    }

    public float getStarsSeparation(@Dimension int i11) {
        return valueFromPixels(this.starsSeparation, i11);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        /* access modifiers changed from: private */
        public float rating = 0.0f;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.rating = parcel.readFloat();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.rating);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SimpleRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttrs(attributeSet);
        initView();
    }

    public void setStarsSeparation(float f11, @Dimension int i11) {
        setStarsSeparation(valueToPixels(f11, i11));
    }

    public SimpleRatingBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        parseAttrs(attributeSet);
        initView();
    }

    public void setMaxStarSize(float f11, @Dimension int i11) {
        setMaxStarSize(valueToPixels(f11, i11));
    }

    public void setStarBorderWidth(float f11, @Dimension int i11) {
        setStarBorderWidth(valueToPixels(f11, i11));
    }

    public void setStarCornerRadius(float f11, @Dimension int i11) {
        setStarCornerRadius(valueToPixels(f11, i11));
    }

    public void setStarSize(float f11, @Dimension int i11) {
        setStarSize(valueToPixels(f11, i11));
    }
}
