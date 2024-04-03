package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;
    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    @Nullable
    private Drawable checkedIcon;
    @Dimension
    private int checkedIconMargin;
    @Dimension
    private int checkedIconSize;
    @Nullable
    private ColorStateList checkedIconTint;
    @Nullable
    private LayerDrawable clickableForegroundDrawable;
    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;
    @Nullable
    private Drawable fgDrawable;
    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;
    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;
    private boolean isBackgroundOverwritten = false;
    @NonNull
    private final MaterialCardView materialCardView;
    @Nullable
    private ColorStateList rippleColor;
    @Nullable
    private Drawable rippleDrawable;
    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private ColorStateList strokeColor;
    @Dimension
    private int strokeWidth;
    @NonNull
    private final Rect userContentPadding = new Rect();

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView2, AttributeSet attributeSet, int i11, @StyleRes int i12) {
        this.materialCardView = materialCardView2;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView2.getContext(), attributeSet, i11, i12);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView2.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView2.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i11, R.style.CardView);
        int i13 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i13)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i13, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        obtainStyledAttributes.recycle();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f11) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * ((double) f11));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f11 / 2.0f;
        }
        return 0.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        float f11;
        float maxCardElevation = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            f11 = calculateActualCornerPadding();
        } else {
            f11 = 0.0f;
        }
        return maxCardElevation + f11;
    }

    private float calculateVerticalBackgroundPadding() {
        float f11;
        float maxCardElevation = this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER;
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            f11 = calculateActualCornerPadding();
        } else {
            f11 = 0.0f;
        }
        return maxCardElevation + f11;
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable;
        createForegroundShapeDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{16842919}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return createCompatRippleDrawable();
        }
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, (Drawable) null, this.foregroundShapeDrawable);
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (!this.materialCardView.getPreventCornerOverlap() || !this.materialCardView.getUseCompatPadding()) {
            return 0.0f;
        }
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(Drawable drawable) {
        int i11;
        int i12;
        if (this.materialCardView.getUseCompatPadding()) {
            i11 = (int) Math.ceil((double) calculateVerticalBackgroundPadding());
            i12 = (int) Math.ceil((double) calculateHorizontalBackgroundPadding());
        } else {
            i12 = 0;
            i11 = 0;
        }
        return new InsetDrawable(drawable, i12, i11, i12, i11) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if (!this.materialCardView.getPreventCornerOverlap() || !canClipToOutline() || !this.materialCardView.getUseCompatPadding()) {
            return false;
        }
        return true;
    }

    private void updateInsetForeground(Drawable drawable) {
        if (this.materialCardView.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    private void updateRippleColor() {
        Drawable drawable;
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE || (drawable = this.rippleDrawable) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setFillColor(this.rippleColor);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.rippleColor);
    }

    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i11 = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i11 - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i11);
        }
    }

    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    public int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z11 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z11;
        this.materialCardView.setLongClickable(z11);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (this.materialCardView.isClickable()) {
            drawable = getClickableForeground();
        } else {
            drawable = this.foregroundContentDrawable;
        }
        this.fgDrawable = drawable;
        this.materialCardView.setForeground(insetDrawable(drawable));
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (this.clickableForegroundDrawable != null) {
            int i15 = this.checkedIconMargin;
            int i16 = this.checkedIconSize;
            int i17 = (i11 - i15) - i16;
            int i18 = (i12 - i15) - i16;
            if (this.materialCardView.getUseCompatPadding()) {
                i18 -= (int) Math.ceil((double) (calculateVerticalBackgroundPadding() * 2.0f));
                i17 -= (int) Math.ceil((double) (calculateHorizontalBackgroundPadding() * 2.0f));
            }
            int i19 = i18;
            int i21 = this.checkedIconMargin;
            if (ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                i13 = i17;
                i14 = i21;
            } else {
                i14 = i17;
                i13 = i21;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i14, this.checkedIconMargin, i13, i19);
        }
    }

    public void setBackgroundOverwritten(boolean z11) {
        this.isBackgroundOverwritten = z11;
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z11) {
        this.checkable = z11;
    }

    public void setChecked(boolean z11) {
        int i11;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            if (z11) {
                i11 = 255;
            } else {
                i11 = 0;
            }
            drawable.setAlpha(i11);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.checkedIcon = mutate;
            DrawableCompat.setTintList(mutate, this.checkedIconTint);
            setChecked(this.materialCardView.isChecked());
        }
        LayerDrawable layerDrawable = this.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    public void setCheckedIconMargin(@Dimension int i11) {
        this.checkedIconMargin = i11;
    }

    public void setCheckedIconSize(@Dimension int i11) {
        this.checkedIconSize = i11;
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    public void setCornerRadius(float f11) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f11));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.bgDrawable.setInterpolation(f11);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f11);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f11);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.compatRippleDrawable;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    public void setStrokeWidth(@Dimension int i11) {
        if (i11 != this.strokeWidth) {
            this.strokeWidth = i11;
            updateStroke();
        }
    }

    public void setUserContentPadding(int i11, int i12, int i13, int i14) {
        this.userContentPadding.set(i11, i12, i13, i14);
        updateContentPadding();
    }

    public void updateClickable() {
        Drawable drawable;
        Drawable drawable2 = this.fgDrawable;
        if (this.materialCardView.isClickable()) {
            drawable = getClickableForeground();
        } else {
            drawable = this.foregroundContentDrawable;
        }
        this.fgDrawable = drawable;
        if (drawable2 != drawable) {
            updateInsetForeground(drawable);
        }
    }

    public void updateContentPadding() {
        boolean z11;
        float f11;
        if (shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f11 = calculateActualCornerPadding();
        } else {
            f11 = 0.0f;
        }
        int parentCardViewCalculatedCornerPadding = (int) (f11 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView materialCardView2 = this.materialCardView;
        Rect rect = this.userContentPadding;
        materialCardView2.setAncestorContentPadding(rect.left + parentCardViewCalculatedCornerPadding, rect.top + parentCardViewCalculatedCornerPadding, rect.right + parentCardViewCalculatedCornerPadding, rect.bottom + parentCardViewCalculatedCornerPadding);
    }

    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
    }
}
