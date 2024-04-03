package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = {16842910};
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    private int alpha = 255;
    private boolean checkable;
    @Nullable
    private Drawable checkedIcon;
    @Nullable
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    @Nullable
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius = -1.0f;
    private float chipEndPadding;
    @Nullable
    private Drawable chipIcon;
    private float chipIconSize;
    @Nullable
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint = new Paint(1);
    private float chipStartPadding;
    @Nullable
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    @Nullable
    private ColorStateList chipSurfaceColor;
    @Nullable
    private Drawable closeIcon;
    @Nullable
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    @Nullable
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    @Nullable
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    @Nullable
    private ColorFilter colorFilter;
    @Nullable
    private ColorStateList compatRippleColor;
    @NonNull
    private final Context context;
    private boolean currentChecked;
    @ColorInt
    private int currentChipBackgroundColor;
    @ColorInt
    private int currentChipStrokeColor;
    @ColorInt
    private int currentChipSurfaceColor;
    @ColorInt
    private int currentCompatRippleColor;
    @ColorInt
    private int currentCompositeSurfaceBackgroundColor;
    @ColorInt
    private int currentTextColor;
    @ColorInt
    private int currentTint;
    @Nullable
    private final Paint debugPaint;
    @NonNull
    private WeakReference<Delegate> delegate = new WeakReference<>((Object) null);
    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private boolean hasChipIconTint;
    @Nullable
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF = new PointF();
    private final RectF rectF = new RectF();
    @Nullable
    private ColorStateList rippleColor;
    private final Path shapePath = new Path();
    private boolean shouldDrawText;
    @Nullable
    private MotionSpec showMotionSpec;
    @Nullable
    private CharSequence text;
    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    @Nullable
    private ColorStateList tint;
    @Nullable
    private PorterDuffColorFilter tintFilter;
    @Nullable
    private PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(@NonNull Context context2, AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        super(context2, attributeSet, i11, i12);
        initializeElevationOverlay(context2);
        this.context = context2;
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        this.text = "";
        textDrawableHelper2.getTextPaint().density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        setCloseIconState(iArr);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(getCloseIconState());
                }
                DrawableCompat.setTintList(drawable, this.closeIconTint);
                return;
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                DrawableCompat.setTintList(drawable2, this.chipIconTint);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private void calculateChipIconBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f11 = this.chipStartPadding + this.iconStartPadding;
            float currentChipIconWidth = getCurrentChipIconWidth();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f12 = ((float) rect.left) + f11;
                rectF2.left = f12;
                rectF2.right = f12 + currentChipIconWidth;
            } else {
                float f13 = ((float) rect.right) - f11;
                rectF2.right = f13;
                rectF2.left = f13 - currentChipIconWidth;
            }
            float currentChipIconHeight = getCurrentChipIconHeight();
            float exactCenterY = rect.exactCenterY() - (currentChipIconHeight / 2.0f);
            rectF2.top = exactCenterY;
            rectF2.bottom = exactCenterY + currentChipIconHeight;
        }
    }

    private void calculateChipTouchBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.set(rect);
        if (showsCloseIcon()) {
            float f11 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.right = ((float) rect.right) - f11;
            } else {
                rectF2.left = ((float) rect.left) + f11;
            }
        }
    }

    private void calculateCloseIconBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f11 = this.chipEndPadding + this.closeIconEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f12 = ((float) rect.right) - f11;
                rectF2.right = f12;
                rectF2.left = f12 - this.closeIconSize;
            } else {
                float f13 = ((float) rect.left) + f11;
                rectF2.left = f13;
                rectF2.right = f13 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f14 = this.closeIconSize;
            float f15 = exactCenterY - (f14 / 2.0f);
            rectF2.top = f15;
            rectF2.bottom = f15 + f14;
        }
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f11 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f12 = (float) rect.right;
                rectF2.right = f12;
                rectF2.left = f12 - f11;
            } else {
                int i11 = rect.left;
                rectF2.left = (float) i11;
                rectF2.right = ((float) i11) + f11;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private void calculateTextBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.left = ((float) rect.left) + calculateChipIconWidth;
                rectF2.right = ((float) rect.right) - calculateCloseIconWidth;
            } else {
                rectF2.left = ((float) rect.left) + calculateCloseIconWidth;
                rectF2.right = ((float) rect.right) - calculateChipIconWidth;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics fontMetrics2 = this.fontMetrics;
        return (fontMetrics2.descent + fontMetrics2.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context2, @Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i11, i12);
        chipDrawable.loadFromAttributes(attributeSet, i11, i12);
        return chipDrawable;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context2, @XmlRes int i11) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context2, i11, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context2, parseDrawableXml, R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void drawCheckedIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f11 = rectF2.left;
            float f12 = rectF2.top;
            canvas.translate(f11, f12);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f11, -f12);
        }
    }

    private void drawChipBackground(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.chipPaint.setColorFilter(getTintColorFilter());
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawChipIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f11 = rectF2.left;
            float f12 = rectF2.top;
            canvas.translate(f11, f12);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f11, -f12);
        }
    }

    private void drawChipStroke(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Paint.Style.STROKE);
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColorFilter(getTintColorFilter());
            }
            RectF rectF2 = this.rectF;
            float f11 = this.chipStrokeWidth;
            rectF2.set(((float) rect.left) + (f11 / 2.0f), ((float) rect.top) + (f11 / 2.0f), ((float) rect.right) - (f11 / 2.0f), ((float) rect.bottom) - (f11 / 2.0f));
            float f12 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas.drawRoundRect(this.rectF, f12, f12, this.chipPaint);
        }
    }

    private void drawChipSurface(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipSurfaceColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawCloseIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f11 = rectF2.left;
            float f12 = rectF2.top;
            canvas.translate(f11, f12);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f11, -f12);
        }
    }

    private void drawCompatRipple(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            return;
        }
        calculatePathForSize(new RectF(rect), this.shapePath);
        super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z11;
        if (this.text != null) {
            Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i11 = 0;
            if (Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width())) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.text;
            if (z11 && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.pointF;
            canvas.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.textDrawableHelper.getTextPaint());
            if (z11) {
                canvas.restoreToCount(i11);
            }
        }
    }

    private float getCurrentChipIconHeight() {
        Drawable drawable;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f11 = this.chipIconSize;
        if (f11 <= 0.0f && drawable != null) {
            f11 = (float) Math.ceil((double) ViewUtils.dpToPx(this.context, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f11) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f11;
    }

    private float getCurrentChipIconWidth() {
        Drawable drawable;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f11 = this.chipIconSize;
        if (f11 > 0.0f || drawable == null) {
            return f11;
        }
        return (float) drawable.getIntrinsicWidth();
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter2 = this.colorFilter;
        return colorFilter2 != null ? colorFilter2 : this.tintFilter;
    }

    private static boolean hasState(@Nullable int[] iArr, @AttrRes int i11) {
        if (iArr == null) {
            return false;
        }
        for (int i12 : iArr) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    private void loadFromAttributes(@Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, R.styleable.Chip, i11, i12, new int[0]);
        this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i13 = R.styleable.Chip_chipCornerRadius;
        if (obtainStyledAttributes.hasValue(i13)) {
            setChipCornerRadius(obtainStyledAttributes.getDimension(i13, 0.0f));
        }
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(R.styleable.Chip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, R.styleable.Chip_android_textAppearance);
        textAppearance.setTextSize(obtainStyledAttributes.getDimension(R.styleable.Chip_android_textSize, textAppearance.getTextSize()));
        setTextAppearance(textAppearance);
        int i14 = obtainStyledAttributes.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i14 == 1) {
            setEllipsize(TextUtils.TruncateAt.START);
        } else if (i14 == 2) {
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i14 == 3) {
            setEllipsize(TextUtils.TruncateAt.END);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null || attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null)) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_chipIcon));
        int i15 = R.styleable.Chip_chipIconTint;
        if (obtainStyledAttributes.hasValue(i15)) {
            setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i15));
        }
        setChipIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null || attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null)) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null || attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null)) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_checkedIcon));
        int i16 = R.styleable.Chip_checkedIconTint;
        if (obtainStyledAttributes.hasValue(i16)) {
            setCheckedIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i16));
        }
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    private void setChipSurfaceColor(@Nullable ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    private void unapplyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void updateCompatRippleColor() {
        ColorStateList colorStateList;
        if (this.useCompatRipple) {
            colorStateList = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
        } else {
            colorStateList = null;
        }
        this.compatRippleColor = colorStateList;
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + getCurrentChipIconWidth() + this.iconEndPadding;
        }
        return 0.0f;
    }

    public float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    @NonNull
    public Paint.Align calculateTextOriginAndAlignment(@NonNull Rect rect, @NonNull PointF pointF2) {
        pointF2.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF2.x = ((float) rect.left) + calculateChipIconWidth;
                align = Paint.Align.LEFT;
            } else {
                pointF2.x = ((float) rect.right) - calculateChipIconWidth;
                align = Paint.Align.RIGHT;
            }
            pointF2.y = ((float) rect.centerY()) - calculateTextCenterFromBaseline();
        }
        return align;
    }

    public void draw(@NonNull Canvas canvas) {
        int i11;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i12 = this.alpha;
            if (i12 < 255) {
                i11 = CanvasCompat.saveLayerAlpha(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i12);
            } else {
                i11 = 0;
            }
            drawChipSurface(canvas, bounds);
            drawChipBackground(canvas, bounds);
            if (this.isShapeThemingEnabled) {
                super.draw(canvas);
            }
            drawChipStroke(canvas, bounds);
            drawCompatRipple(canvas, bounds);
            drawChipIcon(canvas, bounds);
            drawCheckedIcon(canvas, bounds);
            if (this.shouldDrawText) {
                drawText(canvas, bounds);
            }
            drawCloseIcon(canvas, bounds);
            drawDebug(canvas, bounds);
            if (this.alpha < 255) {
                canvas.restoreToCount(i11);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(@NonNull RectF rectF2) {
        calculateChipTouchBounds(getBounds(), rectF2);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF2) {
        calculateCloseIconTouchBounds(getBounds(), rectF2);
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    public boolean isStateful() {
        return isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    public boolean onLayoutDirectionChanged(int i11) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i11);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.chipIcon, i11);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.checkedIcon, i11);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.closeIcon, i11);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public boolean onLevelChange(int i11) {
        boolean onLevelChange = super.onLevelChange(i11);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i11);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i11);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i11);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        Delegate delegate2 = this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        if (this.alpha != i11) {
            this.alpha = i11;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z11) {
        if (this.checkable != z11) {
            this.checkable = z11;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z11 && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(@BoolRes int i11) {
        setCheckable(this.context.getResources().getBoolean(i11));
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z11) {
        setCheckedIconVisible(z11);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i11) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i11));
    }

    public void setCheckedIconResource(@DrawableRes int i11) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, i11));
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                DrawableCompat.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i11) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, i11));
    }

    public void setCheckedIconVisible(@BoolRes int i11) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i11));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i11) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i11));
    }

    @Deprecated
    public void setChipCornerRadius(float f11) {
        if (this.chipCornerRadius != f11) {
            this.chipCornerRadius = f11;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f11));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i11) {
        setChipCornerRadius(this.context.getResources().getDimension(i11));
    }

    public void setChipEndPadding(float f11) {
        if (this.chipEndPadding != f11) {
            this.chipEndPadding = f11;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i11) {
        setChipEndPadding(this.context.getResources().getDimension(i11));
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable chipIcon2 = getChipIcon();
        if (chipIcon2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.chipIcon = drawable2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z11) {
        setChipIconVisible(z11);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i11) {
        setChipIconVisible(i11);
    }

    public void setChipIconResource(@DrawableRes int i11) {
        setChipIcon(AppCompatResources.getDrawable(this.context, i11));
    }

    public void setChipIconSize(float f11) {
        if (this.chipIconSize != f11) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f11;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(@DimenRes int i11) {
        setChipIconSize(this.context.getResources().getDimension(i11));
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(@ColorRes int i11) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, i11));
    }

    public void setChipIconVisible(@BoolRes int i11) {
        setChipIconVisible(this.context.getResources().getBoolean(i11));
    }

    public void setChipMinHeight(float f11) {
        if (this.chipMinHeight != f11) {
            this.chipMinHeight = f11;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i11) {
        setChipMinHeight(this.context.getResources().getDimension(i11));
    }

    public void setChipStartPadding(float f11) {
        if (this.chipStartPadding != f11) {
            this.chipStartPadding = f11;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i11) {
        setChipStartPadding(this.context.getResources().getDimension(i11));
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i11) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i11));
    }

    public void setChipStrokeWidth(float f11) {
        if (this.chipStrokeWidth != f11) {
            this.chipStrokeWidth = f11;
            this.chipPaint.setStrokeWidth(f11);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f11);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i11) {
        setChipStrokeWidth(this.context.getResources().getDimension(i11));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.closeIcon = drawable2;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z11) {
        setCloseIconVisible(z11);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i11) {
        setCloseIconVisible(i11);
    }

    public void setCloseIconEndPadding(float f11) {
        if (this.closeIconEndPadding != f11) {
            this.closeIconEndPadding = f11;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i11) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i11));
    }

    public void setCloseIconResource(@DrawableRes int i11) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, i11));
    }

    public void setCloseIconSize(float f11) {
        if (this.closeIconSize != f11) {
            this.closeIconSize = f11;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i11) {
        setCloseIconSize(this.context.getResources().getDimension(i11));
    }

    public void setCloseIconStartPadding(float f11) {
        if (this.closeIconStartPadding != f11) {
            this.closeIconStartPadding = f11;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i11) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i11));
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@ColorRes int i11) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, i11));
    }

    public void setCloseIconVisible(@BoolRes int i11) {
        setCloseIconVisible(this.context.getResources().getBoolean(i11));
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setDelegate(@Nullable Delegate delegate2) {
        this.delegate = new WeakReference<>(delegate2);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt2) {
        this.truncateAt = truncateAt2;
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i11) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, i11));
    }

    public void setIconEndPadding(float f11) {
        if (this.iconEndPadding != f11) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f11;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i11) {
        setIconEndPadding(this.context.getResources().getDimension(i11));
    }

    public void setIconStartPadding(float f11) {
        if (this.iconStartPadding != f11) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f11;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i11) {
        setIconStartPadding(this.context.getResources().getDimension(i11));
    }

    public void setMaxWidth(@Px int i11) {
        this.maxWidth = i11;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@ColorRes int i11) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, i11));
    }

    public void setShouldDrawText(boolean z11) {
        this.shouldDrawText = z11;
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i11) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, i11));
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.setTextWidthDirty(true);
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int i11) {
        setTextAppearance(new TextAppearance(this.context, i11));
    }

    public void setTextEndPadding(float f11) {
        if (this.textEndPadding != f11) {
            this.textEndPadding = f11;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i11) {
        setTextEndPadding(this.context.getResources().getDimension(i11));
    }

    public void setTextResource(@StringRes int i11) {
        setText(this.context.getResources().getString(i11));
    }

    public void setTextSize(@Dimension float f11) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextSize(f11);
            this.textDrawableHelper.getTextPaint().setTextSize(f11);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f11) {
        if (this.textStartPadding != f11) {
            this.textStartPadding = f11;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i11) {
        setTextStartPadding(this.context.getResources().getDimension(i11));
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z11) {
        if (this.useCompatRipple != z11) {
            this.useCompatRipple = z11;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z11, z12);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z11, z12);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z11, z12);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void setCheckedIconVisible(boolean z11) {
        if (this.checkedIconVisible != z11) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z11;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipIconVisible(boolean z11) {
        if (this.chipIconVisible != z11) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z11;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setCloseIconVisible(boolean z11) {
        if (this.closeIconVisible != z11) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z11;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    private boolean onStateChange(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z11;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.chipSurfaceColor;
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList != null ? colorStateList.getColorForState(iArr, this.currentChipSurfaceColor) : 0);
        boolean z12 = true;
        if (this.currentChipSurfaceColor != compositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.chipBackgroundColor;
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != compositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int layer = MaterialColors.layer(compositeElevationOverlayIfNeeded, compositeElevationOverlayIfNeeded2);
        if ((this.currentCompositeSurfaceBackgroundColor != layer) || (getFillColor() == null)) {
            this.currentCompositeSurfaceBackgroundColor = layer;
            setFillColor(ColorStateList.valueOf(layer));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipStrokeColor;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState) {
            this.currentChipStrokeColor = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState2) {
            this.currentCompatRippleColor = colorForState2;
            if (this.useCompatRipple) {
                onStateChange = true;
            }
        }
        int colorForState3 = (this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().getTextColor() == null) ? 0 : this.textDrawableHelper.getTextAppearance().getTextColor().getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState3) {
            this.currentTextColor = colorForState3;
            onStateChange = true;
        }
        boolean z13 = hasState(getState(), 16842912) && this.checkable;
        if (this.currentChecked == z13 || this.checkedIcon == null) {
            z11 = false;
        } else {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z13;
            if (calculateChipIconWidth != calculateChipIconWidth()) {
                onStateChange = true;
                z11 = true;
            } else {
                z11 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.tint;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentTint) : 0;
        if (this.currentTint != colorForState4) {
            this.currentTint = colorForState4;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
        } else {
            z12 = onStateChange;
        }
        if (isStateful(this.chipIcon)) {
            z12 |= this.chipIcon.setState(iArr);
        }
        if (isStateful(this.checkedIcon)) {
            z12 |= this.checkedIcon.setState(iArr);
        }
        if (isStateful(this.closeIcon)) {
            int[] iArr3 = new int[(iArr.length + iArr2.length)];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z12 |= this.closeIcon.setState(iArr3);
        }
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
            z12 |= this.closeIconRipple.setState(iArr2);
        }
        if (z12) {
            invalidateSelf();
        }
        if (z11) {
            onSizeChange();
        }
        return z12;
    }

    private static boolean isStateful(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(@Nullable TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.getTextColor() == null || !textAppearance.getTextColor().isStateful()) ? false : true;
    }
}
