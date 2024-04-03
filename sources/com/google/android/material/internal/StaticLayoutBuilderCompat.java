package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY = 1;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    @Nullable
    private static Object textDirection;
    private Layout.Alignment alignment;
    @Nullable
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start = 0;
    private final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i11;
        this.end = charSequence.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        boolean z11;
        TextDirectionHeuristic textDirectionHeuristic;
        if (!initialized) {
            try {
                if (this.isRtl) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Class<TextDirectionHeuristic> cls = TextDirectionHeuristic.class;
                if (z11) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
                textDirection = textDirectionHeuristic;
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2});
                constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
                initialized = true;
            } catch (Exception e11) {
                throw new StaticLayoutBuilderCompatException(e11);
            }
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i11) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i11);
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, (float) max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        if (this.isRtl && this.maxLines == 1) {
            this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
        obtain.setAlignment(this.alignment);
        obtain.setIncludePad(this.includePad);
        if (this.isRtl) {
            textDirectionHeuristic = TextDirectionHeuristics.RTL;
        } else {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        }
        obtain.setTextDirection(textDirectionHeuristic);
        TextUtils.TruncateAt truncateAt = this.ellipsize;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.maxLines);
        float f11 = this.lineSpacingAdd;
        if (!(f11 == 0.0f && this.lineSpacingMultiplier == 1.0f)) {
            obtain.setLineSpacing(f11, this.lineSpacingMultiplier);
        }
        if (this.maxLines > 1) {
            obtain.setHyphenationFrequency(this.hyphenationFrequency);
        }
        return obtain.build();
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment alignment2) {
        this.alignment = alignment2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int i11) {
        this.end = i11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setHyphenationFrequency(int i11) {
        this.hyphenationFrequency = i11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean z11) {
        this.includePad = z11;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z11) {
        this.isRtl = z11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setLineSpacing(float f11, float f12) {
        this.lineSpacingAdd = f11;
        this.lineSpacingMultiplier = f12;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int i11) {
        this.maxLines = i11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int i11) {
        this.start = i11;
        return this;
    }
}
