package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;
    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity = 16;
    private float collapsedTextSize = 15.0f;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private int currentOffsetY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int maxLines = 1;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;
    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        TextPaint textPaint2 = new TextPaint(129);
        this.textPaint = textPaint2;
        this.tmpPaint = new TextPaint(textPaint2);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    private static int blendColors(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((((float) Color.alpha(i11)) * f12) + (((float) Color.alpha(i12)) * f11)), (int) ((((float) Color.red(i11)) * f12) + (((float) Color.red(i12)) * f11)), (int) ((((float) Color.green(i11)) * f12) + (((float) Color.green(i12)) * f11)), (int) ((((float) Color.blue(i11)) * f12) + (((float) Color.blue(i12)) * f11)));
    }

    private void calculateBaseOffsets(boolean z11) {
        float f11;
        int i11;
        float f12;
        StaticLayout staticLayout;
        float f13 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize, z11);
        CharSequence charSequence = this.textToDraw;
        if (!(charSequence == null || (staticLayout = this.textLayout) == null)) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        float f14 = 0.0f;
        if (this.textToDrawCollapsed != null) {
            TextPaint textPaint2 = new TextPaint(this.textPaint);
            textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
            CharSequence charSequence2 = this.textToDrawCollapsed;
            this.collapsedTextWidth = textPaint2.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i12 = absoluteGravity & 112;
        if (i12 == 48) {
            this.collapsedDrawY = (float) this.collapsedBounds.top;
        } else if (i12 != 80) {
            this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = ((float) this.collapsedBounds.bottom) + this.textPaint.ascent();
        }
        int i13 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 == 1) {
            this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (this.collapsedTextWidth / 2.0f);
        } else if (i13 != 5) {
            this.collapsedDrawX = (float) this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        }
        calculateUsingTextSize(this.expandedTextSize, z11);
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 != null) {
            f11 = (float) staticLayout2.getHeight();
        } else {
            f11 = 0.0f;
        }
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 != null) {
            i11 = staticLayout3.getLineCount();
        } else {
            i11 = 0;
        }
        this.expandedLineCount = i11;
        CharSequence charSequence3 = this.textToDraw;
        if (charSequence3 != null) {
            f12 = this.textPaint.measureText(charSequence3, 0, charSequence3.length());
        } else {
            f12 = 0.0f;
        }
        StaticLayout staticLayout4 = this.textLayout;
        if (staticLayout4 != null && this.maxLines > 1) {
            f12 = (float) staticLayout4.getWidth();
        }
        StaticLayout staticLayout5 = this.textLayout;
        if (staticLayout5 != null) {
            if (this.maxLines > 1) {
                f14 = (float) staticLayout5.getLineStart(0);
            } else {
                f14 = staticLayout5.getLineLeft(0);
            }
        }
        this.expandedFirstLineDrawX = f14;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i14 = absoluteGravity2 & 112;
        if (i14 == 48) {
            this.expandedDrawY = (float) this.expandedBounds.top;
        } else if (i14 != 80) {
            this.expandedDrawY = ((float) this.expandedBounds.centerY()) - (f11 / 2.0f);
        } else {
            this.expandedDrawY = (((float) this.expandedBounds.bottom) - f11) + this.textPaint.descent();
        }
        int i15 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i15 == 1) {
            this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (f12 / 2.0f);
        } else if (i15 != 5) {
            this.expandedDrawX = (float) this.expandedBounds.left;
        } else {
            this.expandedDrawX = ((float) this.expandedBounds.right) - f12;
        }
        clearTexture();
        setInterpolatedTextSize(f13);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        float f12 = this.fadeModeThresholdFraction;
        if (f11 <= f12) {
            return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f12, f11);
        }
        return AnimationUtils.lerp(0.0f, 1.0f, f12, 1.0f, f11);
    }

    private float calculateFadeModeThresholdFraction() {
        float f11 = this.fadeModeStartFraction;
        return f11 + ((1.0f - f11) * 0.5f);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled) {
            return isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl);
        }
        return isDefaultIsRtl;
    }

    private void calculateOffsets(float f11) {
        float f12;
        interpolateBounds(f11);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f11, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f11, this.positionInterpolator);
            setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f11, this.textSizeInterpolator));
            f12 = f11;
        } else if (f11 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(this.expandedTextSize);
            f12 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - ((float) Math.max(0, this.currentOffsetY));
            setInterpolatedTextSize(this.collapsedTextSize);
            f12 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f11, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f11, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f12));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f13 = this.collapsedLetterSpacing;
        float f14 = this.expandedLetterSpacing;
        if (f13 != f14) {
            this.textPaint.setLetterSpacing(lerp(f14, f13, f11, timeInterpolator));
        } else {
            this.textPaint.setLetterSpacing(f13);
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f11, (TimeInterpolator) null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f11, (TimeInterpolator) null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f11, (TimeInterpolator) null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f11));
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f11) * ((float) this.textPaint.getAlpha())));
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void calculateUsingTextSize(float f11) {
        calculateUsingTextSize(f11, false);
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int i11, float f11, boolean z11) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f11).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z11).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i11).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e11) {
            Log.e(TAG, e11.getCause().getMessage(), e11);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void drawMultilineTransition(@NonNull Canvas canvas, float f11, float f12) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f11, f12);
        float f13 = (float) alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f13));
        this.textLayout.draw(canvas);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f13));
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f14 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f14, this.textPaint);
        if (!this.fadeModeEnabled) {
            String trim = this.textToDrawCollapsed.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.textPaint.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f14, this.textPaint);
        }
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            int width = this.textLayout.getWidth();
            int height = this.textLayout.getHeight();
            if (width > 0 && height > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
    }

    private float getCollapsedTextLeftBound(int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (((float) i11) / 2.0f) - (this.collapsedTextWidth / 2.0f);
        }
        if ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) {
            if (this.isRtl) {
                return (float) this.collapsedBounds.left;
            }
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else if (this.isRtl) {
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else {
            return (float) this.collapsedBounds.left;
        }
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (((float) i11) / 2.0f) + (this.collapsedTextWidth / 2.0f);
        }
        if ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) {
            if (this.isRtl) {
                return rectF.left + this.collapsedTextWidth;
            }
            return (float) this.collapsedBounds.right;
        } else if (this.isRtl) {
            return (float) this.collapsedBounds.right;
        } else {
            return rectF.left + this.collapsedTextWidth;
        }
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.expandedTextSize);
        textPaint2.setTypeface(this.expandedTypeface);
        textPaint2.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f11) {
        Rect rect;
        if (this.fadeModeEnabled) {
            RectF rectF = this.currentBounds;
            if (f11 < this.fadeModeThresholdFraction) {
                rect = this.expandedBounds;
            } else {
                rect = this.collapsedBounds;
            }
            rectF.set(rect);
            return;
        }
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f11, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f11, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f11, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f11, this.positionInterpolator);
    }

    private static boolean isClose(float f11, float f12) {
        return Math.abs(f11 - f12) < 0.001f;
    }

    private boolean isDefaultIsRtl() {
        return ViewCompat.getLayoutDirection(this.view) == 1;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence charSequence, boolean z11) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z11) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f11, float f12, float f13, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f13 = timeInterpolator.getInterpolation(f13);
        }
        return AnimationUtils.lerp(f11, f12, f13);
    }

    private static boolean rectEquals(@NonNull Rect rect, int i11, int i12, int i13, int i14) {
        return rect.left == i11 && rect.top == i12 && rect.right == i13 && rect.bottom == i14;
    }

    private void setCollapsedTextBlend(float f11) {
        this.collapsedTextBlend = f11;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypeface == typeface) {
            return false;
        }
        this.collapsedTypeface = typeface;
        return true;
    }

    private void setExpandedTextBlend(float f11) {
        this.expandedTextBlend = f11;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypeface == typeface) {
            return false;
        }
        this.expandedTypeface = typeface;
        return true;
    }

    private void setInterpolatedTextSize(float f11) {
        boolean z11;
        calculateUsingTextSize(f11);
        if (!USE_SCALING_TEXTURE || this.scale == 1.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.useTexture = z11;
        if (z11) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean shouldDrawMultiline() {
        return this.maxLines > 1 && (!this.isRtl || this.fadeModeEnabled) && !this.useTexture;
    }

    public void draw(@NonNull Canvas canvas) {
        float f11;
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            boolean z11 = true;
            if (this.maxLines > 1) {
                f11 = (float) this.textLayout.getLineStart(0);
            } else {
                f11 = this.textLayout.getLineLeft(0);
            }
            float f12 = (this.currentDrawX + f11) - (this.expandedFirstLineDrawX * 2.0f);
            this.textPaint.setTextSize(this.currentTextSize);
            float f13 = this.currentDrawX;
            float f14 = this.currentDrawY;
            if (!this.useTexture || this.expandedTitleTexture == null) {
                z11 = false;
            }
            float f15 = this.scale;
            if (f15 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f15, f15, f13, f14);
            }
            if (z11) {
                canvas.drawBitmap(this.expandedTitleTexture, f13, f14, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (!shouldDrawMultiline() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
                canvas.translate(f13, f14);
                this.textLayout.draw(canvas);
            } else {
                drawMultilineTransition(canvas, f12, f14);
            }
            canvas.restoreToCount(save);
        }
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i11, int i12) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i11, i12);
        rectF.top = (float) this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i11, i12);
        rectF.bottom = ((float) this.collapsedBounds.top) + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.collapsedTextColor;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = this.expandedTextColor) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    public void onBoundsChanged() {
        boolean z11;
        if (this.collapsedBounds.width() <= 0 || this.collapsedBounds.height() <= 0 || this.expandedBounds.width() <= 0 || this.expandedBounds.height() <= 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.drawTitle = z11;
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.collapsedBounds, i11, i12, i13, i14)) {
            this.collapsedBounds.set(i11, i12, i13, i14);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setCollapsedTextAppearance(int i11) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i11);
        if (textAppearance.getTextColor() != null) {
            this.collapsedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.collapsedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i11) {
        if (this.collapsedTextGravity != i11) {
            this.collapsedTextGravity = i11;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f11) {
        if (this.collapsedTextSize != f11) {
            this.collapsedTextSize = f11;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i11) {
        this.currentOffsetY = i11;
    }

    public void setExpandedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.expandedBounds, i11, i12, i13, i14)) {
            this.expandedBounds.set(i11, i12, i13, i14);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedTextAppearance(int i11) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i11);
        if (textAppearance.getTextColor() != null) {
            this.expandedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.expandedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i11) {
        if (this.expandedTextGravity != i11) {
            this.expandedTextGravity = i11;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f11) {
        if (this.expandedTextSize != f11) {
            this.expandedTextSize = f11;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f11) {
        float clamp = MathUtils.clamp(f11, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z11) {
        this.fadeModeEnabled = z11;
    }

    public void setFadeModeStartFraction(float f11) {
        this.fadeModeStartFraction = f11;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i11) {
        this.hyphenationFrequency = i11;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f11) {
        this.lineSpacingAdd = f11;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f11) {
        this.lineSpacingMultiplier = f11;
    }

    public void setMaxLines(int i11) {
        if (i11 != this.maxLines) {
            this.maxLines = i11;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z11) {
        this.isRtlTextDirectionHeuristicsEnabled = z11;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private void calculateUsingTextSize(float f11, boolean z11) {
        boolean z12;
        float f12;
        boolean z13;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            boolean z14 = false;
            int i11 = 1;
            if (isClose(f11, this.collapsedTextSize)) {
                f12 = this.collapsedTextSize;
                this.scale = 1.0f;
                Typeface typeface = this.currentTypeface;
                Typeface typeface2 = this.collapsedTypeface;
                if (typeface != typeface2) {
                    this.currentTypeface = typeface2;
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                float f13 = this.expandedTextSize;
                Typeface typeface3 = this.currentTypeface;
                Typeface typeface4 = this.expandedTypeface;
                if (typeface3 != typeface4) {
                    this.currentTypeface = typeface4;
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (isClose(f11, f13)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f11 / this.expandedTextSize;
                }
                float f14 = this.collapsedTextSize / this.expandedTextSize;
                float f15 = width2 * f14;
                if (!z11 && f15 > width) {
                    width = Math.min(width / f14, width2);
                } else {
                    width = width2;
                }
                f12 = f13;
                z12 = z13;
            }
            if (width > 0.0f) {
                z12 = this.currentTextSize != f12 || this.boundsChanged || z12;
                this.currentTextSize = f12;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z12) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                TextPaint textPaint2 = this.textPaint;
                if (this.scale != 1.0f) {
                    z14 = true;
                }
                textPaint2.setLinearText(z14);
                this.isRtl = calculateIsRtl(this.text);
                if (shouldDrawMultiline()) {
                    i11 = this.maxLines;
                }
                StaticLayout createStaticLayout = createStaticLayout(i11, width, this.isRtl);
                this.textLayout = createStaticLayout;
                this.textToDraw = createStaticLayout.getText();
            }
        }
    }

    public void recalculate(boolean z11) {
        if ((this.view.getHeight() > 0 && this.view.getWidth() > 0) || z11) {
            calculateBaseOffsets(z11);
            calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
