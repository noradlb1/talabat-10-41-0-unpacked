package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Shimmer {
    private static final int COMPONENT_COUNT = 4;
    boolean alphaShimmer = true;
    long animationDuration = 1000;
    boolean autoStart = true;
    @ColorInt
    int baseColor = 1291845631;
    final RectF bounds = new RectF();
    boolean clipToChildren = true;
    final int[] colors = new int[4];
    int direction = 0;
    float dropoff = 0.5f;
    int fixedHeight = 0;
    int fixedWidth = 0;
    float heightRatio = 1.0f;
    @ColorInt
    int highlightColor = -1;
    float intensity = 0.0f;
    final float[] positions = new float[4];
    int repeatCount = -1;
    long repeatDelay;
    int repeatMode = 1;
    int shape = 0;
    float tilt = 20.0f;
    float widthRatio = 1.0f;

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }

        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder setBaseColor(@ColorInt int i11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (i11 & 16777215) | (shimmer.baseColor & ViewCompat.MEASURED_STATE_MASK);
            return getThis();
        }

        public ColorHighlightBuilder setHighlightColor(@ColorInt int i11) {
            this.mShimmer.highlightColor = i11;
            return getThis();
        }

        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i11)) {
                setBaseColor(typedArray.getColor(i11, this.mShimmer.baseColor));
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i12)) {
                setHighlightColor(typedArray.getColor(i12, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public int height(int i11) {
        int i12 = this.fixedHeight;
        return i12 > 0 ? i12 : Math.round(this.heightRatio * ((float) i11));
    }

    public void updateBounds(int i11, int i12) {
        double max = (double) Math.max(i11, i12);
        int round = Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians((double) (this.tilt % 90.0f)))) - max)) / 2.0f) * 3;
        float f11 = (float) (-round);
        this.bounds.set(f11, f11, (float) (width(i11) + round), (float) (height(i12) + round));
    }

    public void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i11 = this.baseColor;
            iArr[0] = i11;
            int i12 = this.highlightColor;
            iArr[1] = i12;
            iArr[2] = i12;
            iArr[3] = i11;
            return;
        }
        int[] iArr2 = this.colors;
        int i13 = this.highlightColor;
        iArr2[0] = i13;
        iArr2[1] = i13;
        int i14 = this.baseColor;
        iArr2[2] = i14;
        iArr2[3] = i14;
    }

    public void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    public int width(int i11) {
        int i12 = this.fixedWidth;
        return i12 > 0 ? i12 : Math.round(this.widthRatio * ((float) i11));
    }

    public static abstract class Builder<T extends Builder<T>> {
        final Shimmer mShimmer = new Shimmer();

        private static float clamp(float f11, float f12, float f13) {
            return Math.min(f12, Math.max(f11, f13));
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T copyFrom(Shimmer shimmer) {
            setDirection(shimmer.direction);
            setShape(shimmer.shape);
            setFixedWidth(shimmer.fixedWidth);
            setFixedHeight(shimmer.fixedHeight);
            setWidthRatio(shimmer.widthRatio);
            setHeightRatio(shimmer.heightRatio);
            setIntensity(shimmer.intensity);
            setDropoff(shimmer.dropoff);
            setTilt(shimmer.tilt);
            setClipToChildren(shimmer.clipToChildren);
            setAutoStart(shimmer.autoStart);
            setRepeatCount(shimmer.repeatCount);
            setRepeatMode(shimmer.repeatMode);
            setRepeatDelay(shimmer.repeatDelay);
            setDuration(shimmer.animationDuration);
            Shimmer shimmer2 = this.mShimmer;
            shimmer2.baseColor = shimmer.baseColor;
            shimmer2.highlightColor = shimmer.highlightColor;
            return getThis();
        }

        public abstract T getThis();

        public T setAutoStart(boolean z11) {
            this.mShimmer.autoStart = z11;
            return getThis();
        }

        public T setBaseAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f11) * 255.0f)) << 24) | (shimmer.baseColor & 16777215);
            return getThis();
        }

        public T setClipToChildren(boolean z11) {
            this.mShimmer.clipToChildren = z11;
            return getThis();
        }

        public T setDirection(int i11) {
            this.mShimmer.direction = i11;
            return getThis();
        }

        public T setDropoff(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.dropoff = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f11);
        }

        public T setDuration(long j11) {
            if (j11 >= 0) {
                this.mShimmer.animationDuration = j11;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j11);
        }

        public T setFixedHeight(@Px int i11) {
            if (i11 >= 0) {
                this.mShimmer.fixedHeight = i11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height: " + i11);
        }

        public T setFixedWidth(@Px int i11) {
            if (i11 >= 0) {
                this.mShimmer.fixedWidth = i11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width: " + i11);
        }

        public T setHeightRatio(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.heightRatio = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f11);
        }

        public T setHighlightAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.highlightColor = (((int) (clamp(0.0f, 1.0f, f11) * 255.0f)) << 24) | (shimmer.highlightColor & 16777215);
            return getThis();
        }

        public T setIntensity(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.intensity = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f11);
        }

        public T setRepeatCount(int i11) {
            this.mShimmer.repeatCount = i11;
            return getThis();
        }

        public T setRepeatDelay(long j11) {
            if (j11 >= 0) {
                this.mShimmer.repeatDelay = j11;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j11);
        }

        public T setRepeatMode(int i11) {
            this.mShimmer.repeatMode = i11;
            return getThis();
        }

        public T setShape(int i11) {
            this.mShimmer.shape = i11;
            return getThis();
        }

        public T setTilt(float f11) {
            this.mShimmer.tilt = f11;
            return getThis();
        }

        public T setWidthRatio(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.widthRatio = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f11);
        }

        public T consumeAttributes(TypedArray typedArray) {
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i11)) {
                setClipToChildren(typedArray.getBoolean(i11, this.mShimmer.clipToChildren));
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i12)) {
                setAutoStart(typedArray.getBoolean(i12, this.mShimmer.autoStart));
            }
            int i13 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i13)) {
                setBaseAlpha(typedArray.getFloat(i13, 0.3f));
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i14)) {
                setHighlightAlpha(typedArray.getFloat(i14, 1.0f));
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i15)) {
                setDuration((long) typedArray.getInt(i15, (int) this.mShimmer.animationDuration));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i16)) {
                setRepeatCount(typedArray.getInt(i16, this.mShimmer.repeatCount));
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i17)) {
                setRepeatDelay((long) typedArray.getInt(i17, (int) this.mShimmer.repeatDelay));
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i18)) {
                setRepeatMode(typedArray.getInt(i18, this.mShimmer.repeatMode));
            }
            int i19 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i19)) {
                int i21 = typedArray.getInt(i19, this.mShimmer.direction);
                if (i21 == 1) {
                    setDirection(1);
                } else if (i21 == 2) {
                    setDirection(2);
                } else if (i21 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            int i22 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i22)) {
                if (typedArray.getInt(i22, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i23 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i23)) {
                setDropoff(typedArray.getFloat(i23, this.mShimmer.dropoff));
            }
            int i24 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i24)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i24, this.mShimmer.fixedWidth));
            }
            int i25 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i25)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i25, this.mShimmer.fixedHeight));
            }
            int i26 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i26)) {
                setIntensity(typedArray.getFloat(i26, this.mShimmer.intensity));
            }
            int i27 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i27)) {
                setWidthRatio(typedArray.getFloat(i27, this.mShimmer.widthRatio));
            }
            int i28 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i28)) {
                setHeightRatio(typedArray.getFloat(i28, this.mShimmer.heightRatio));
            }
            int i29 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i29)) {
                setTilt(typedArray.getFloat(i29, this.mShimmer.tilt));
            }
            return getThis();
        }
    }
}
