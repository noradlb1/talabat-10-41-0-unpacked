package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    @StyleRes
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    @AttrRes
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    @Nullable
    private WeakReference<View> anchorViewRef;
    @NonNull
    private final Rect badgeBounds = new Rect();
    private float badgeCenterX;
    private float badgeCenterY;
    private float badgeRadius;
    private float badgeWidePadding;
    private float badgeWithTextRadius;
    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    @NonNull
    private final SavedState savedState;
    @NonNull
    private final MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    private BadgeDrawable(@NonNull Context context) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        textDrawableHelper2.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void calculateCenterAndBounds(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i11;
        float f11;
        float f12;
        float f13;
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int access$500 = this.savedState.badgeGravity;
        if (access$500 == 8388691 || access$500 == 8388693) {
            this.badgeCenterY = (float) (rect.bottom - totalVerticalOffsetForState);
        } else {
            this.badgeCenterY = (float) (rect.top + totalVerticalOffsetForState);
        }
        if (getNumber() <= 9) {
            if (!hasNumber()) {
                f13 = this.badgeRadius;
            } else {
                f13 = this.badgeWithTextRadius;
            }
            this.cornerRadius = f13;
            this.halfBadgeHeight = f13;
            this.halfBadgeWidth = f13;
        } else {
            float f14 = this.badgeWithTextRadius;
            this.cornerRadius = f14;
            this.halfBadgeHeight = f14;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        Resources resources = context.getResources();
        if (hasNumber()) {
            i11 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
        } else {
            i11 = R.dimen.mtrl_badge_horizontal_edge_offset;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i11);
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int access$5002 = this.savedState.badgeGravity;
        if (access$5002 == 8388659 || access$5002 == 8388691) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f11 = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState);
            } else {
                f11 = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState);
            }
            this.badgeCenterX = f11;
            return;
        }
        if (ViewCompat.getLayoutDirection(view) == 0) {
            f12 = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState);
        } else {
            f12 = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState);
        }
        this.badgeCenterX = f12;
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return createFromAttributes(context, (AttributeSet) null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    private static BadgeDrawable createFromAttributes(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i11, i12);
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i11) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i11, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, parseDrawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull SavedState savedState2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState2);
        return badgeDrawable;
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + ((float) (rect.height() / 2)), this.textDrawableHelper.getTextPaint());
    }

    @NonNull
    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format((long) getNumber());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    }

    private int getTotalHorizontalOffsetForState() {
        int i11;
        if (hasNumber()) {
            i11 = this.savedState.horizontalOffsetWithText;
        } else {
            i11 = this.savedState.horizontalOffsetWithoutText;
        }
        return i11 + this.savedState.additionalHorizontalOffset;
    }

    private int getTotalVerticalOffsetForState() {
        int i11;
        if (hasNumber()) {
            i11 = this.savedState.verticalOffsetWithText;
        } else {
            i11 = this.savedState.verticalOffsetWithoutText;
        }
        return i11 + this.savedState.additionalVerticalOffset;
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i11, i12, new int[0]);
        setMaxCharacterCount(obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i13 = R.styleable.Badge_number;
        if (obtainStyledAttributes.hasValue(i13)) {
            setNumber(obtainStyledAttributes.getInt(i13, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor));
        int i14 = R.styleable.Badge_badgeTextColor;
        if (obtainStyledAttributes.hasValue(i14)) {
            setBadgeTextColor(readColorFromAttributes(context, obtainStyledAttributes, i14));
        }
        setBadgeGravity(obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        setHorizontalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, getHorizontalOffsetWithoutText()));
        setVerticalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, getVerticalOffsetWithoutText()));
        int i15 = R.styleable.Badge_badgeRadius;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.badgeRadius = (float) obtainStyledAttributes.getDimensionPixelSize(i15, (int) this.badgeRadius);
        }
        int i16 = R.styleable.Badge_badgeWidePadding;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.badgeWidePadding = (float) obtainStyledAttributes.getDimensionPixelSize(i16, (int) this.badgeWidePadding);
        }
        int i17 = R.styleable.Badge_badgeWithTextRadius;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.badgeWithTextRadius = (float) obtainStyledAttributes.getDimensionPixelSize(i17, (int) this.badgeWithTextRadius);
        }
        obtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(Context context, @NonNull TypedArray typedArray, @StyleableRes int i11) {
        return MaterialResources.getColorStateList(context, typedArray, i11).getDefaultColor();
    }

    private void restoreFromSavedState(@NonNull SavedState savedState2) {
        setMaxCharacterCount(savedState2.maxCharacterCount);
        if (savedState2.number != -1) {
            setNumber(savedState2.number);
        }
        setBackgroundColor(savedState2.backgroundColor);
        setBadgeTextColor(savedState2.badgeTextColor);
        setBadgeGravity(savedState2.badgeGravity);
        setHorizontalOffsetWithoutText(savedState2.horizontalOffsetWithoutText);
        setVerticalOffsetWithoutText(savedState2.verticalOffsetWithoutText);
        setHorizontalOffsetWithText(savedState2.horizontalOffsetWithText);
        setVerticalOffsetWithText(savedState2.verticalOffsetWithText);
        setAdditionalHorizontalOffset(savedState2.additionalHorizontalOffset);
        setAdditionalVerticalOffset(savedState2.additionalVerticalOffset);
        setVisible(savedState2.isVisible);
    }

    private void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() != textAppearance && (context = this.contextRef.get()) != null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, context);
            updateCenterAndBounds();
        }
    }

    private void setTextAppearanceResource(@StyleRes int i11) {
        Context context = this.contextRef.get();
        if (context != null) {
            setTextAppearance(new TextAppearance(context, i11));
        }
    }

    private void tryWrapAnchorInCompatParent(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() {
                    public void run() {
                        BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        View view;
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            calculateCenterAndBounds(context, rect2, view);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            this.shapeDrawable.setCornerSize(this.cornerRadius);
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }

    public void clearNumber() {
        int unused = this.savedState.number = -1;
        updateCenterAndBounds();
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                drawText(canvas);
            }
        }
    }

    public int getAdditionalHorizontalOffset() {
        return this.savedState.additionalHorizontalOffset;
    }

    public int getAdditionalVerticalOffset() {
        return this.savedState.additionalVerticalOffset;
    }

    public int getAlpha() {
        return this.savedState.alpha;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.savedState.badgeGravity;
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.savedState.contentDescriptionNumberless;
        }
        if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        if (getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), new Object[]{Integer.valueOf(getNumber())});
        }
        return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.savedState.horizontalOffsetWithoutText;
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.savedState.horizontalOffsetWithText;
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.savedState.horizontalOffsetWithoutText;
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public int getNumber() {
        if (!hasNumber()) {
            return 0;
        }
        return this.savedState.number;
    }

    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.savedState;
    }

    public int getVerticalOffset() {
        return this.savedState.verticalOffsetWithoutText;
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.savedState.verticalOffsetWithText;
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.savedState.verticalOffsetWithoutText;
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setAdditionalHorizontalOffset(int i11) {
        int unused = this.savedState.additionalHorizontalOffset = i11;
        updateCenterAndBounds();
    }

    public void setAdditionalVerticalOffset(int i11) {
        int unused = this.savedState.additionalVerticalOffset = i11;
        updateCenterAndBounds();
    }

    public void setAlpha(int i11) {
        int unused = this.savedState.alpha = i11;
        this.textDrawableHelper.getTextPaint().setAlpha(i11);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int i11) {
        int unused = this.savedState.backgroundColor = i11;
        ColorStateList valueOf = ColorStateList.valueOf(i11);
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i11) {
        FrameLayout frameLayout;
        if (this.savedState.badgeGravity != i11) {
            int unused = this.savedState.badgeGravity = i11;
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.anchorViewRef.get();
                WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
                if (weakReference2 != null) {
                    frameLayout = weakReference2.get();
                } else {
                    frameLayout = null;
                }
                updateBadgeCoordinates(view, frameLayout);
            }
        }
    }

    public void setBadgeTextColor(@ColorInt int i11) {
        int unused = this.savedState.badgeTextColor = i11;
        if (this.textDrawableHelper.getTextPaint().getColor() != i11) {
            this.textDrawableHelper.getTextPaint().setColor(i11);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i11) {
        int unused = this.savedState.contentDescriptionExceedsMaxBadgeNumberRes = i11;
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        CharSequence unused = this.savedState.contentDescriptionNumberless = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i11) {
        int unused = this.savedState.contentDescriptionQuantityStrings = i11;
    }

    public void setHorizontalOffset(int i11) {
        setHorizontalOffsetWithoutText(i11);
        setHorizontalOffsetWithText(i11);
    }

    public void setHorizontalOffsetWithText(@Px int i11) {
        int unused = this.savedState.horizontalOffsetWithText = i11;
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int i11) {
        int unused = this.savedState.horizontalOffsetWithoutText = i11;
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i11) {
        if (this.savedState.maxCharacterCount != i11) {
            int unused = this.savedState.maxCharacterCount = i11;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setNumber(int i11) {
        int max = Math.max(0, i11);
        if (this.savedState.number != max) {
            int unused = this.savedState.number = max;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setVerticalOffset(int i11) {
        setVerticalOffsetWithoutText(i11);
        setVerticalOffsetWithText(i11);
    }

    public void setVerticalOffsetWithText(@Px int i11) {
        int unused = this.savedState.verticalOffsetWithText = i11;
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int i11) {
        int unused = this.savedState.verticalOffsetWithoutText = i11;
        updateCenterAndBounds();
    }

    public void setVisible(boolean z11) {
        setVisible(z11, false);
        boolean unused = this.savedState.isVisible = z11;
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !z11) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        boolean z11 = BadgeUtils.USE_COMPAT_PARENT;
        if (!z11 || frameLayout != null) {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        } else {
            tryWrapAnchorInCompatParent(view);
        }
        if (!z11) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @NonNull
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int additionalHorizontalOffset;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int additionalVerticalOffset;
        /* access modifiers changed from: private */
        public int alpha = 255;
        /* access modifiers changed from: private */
        @ColorInt
        public int backgroundColor;
        /* access modifiers changed from: private */
        public int badgeGravity;
        /* access modifiers changed from: private */
        @ColorInt
        public int badgeTextColor;
        /* access modifiers changed from: private */
        @StringRes
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence contentDescriptionNumberless;
        /* access modifiers changed from: private */
        @PluralsRes
        public int contentDescriptionQuantityStrings;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int horizontalOffsetWithText;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int horizontalOffsetWithoutText;
        /* access modifiers changed from: private */
        public boolean isVisible;
        /* access modifiers changed from: private */
        public int maxCharacterCount;
        /* access modifiers changed from: private */
        public int number = -1;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int verticalOffsetWithText;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public int verticalOffsetWithoutText;

        public SavedState(@NonNull Context context) {
            this.badgeTextColor = new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffsetWithoutText);
            parcel.writeInt(this.verticalOffsetWithoutText);
            parcel.writeInt(this.horizontalOffsetWithText);
            parcel.writeInt(this.verticalOffsetWithText);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffsetWithoutText = parcel.readInt();
            this.verticalOffsetWithoutText = parcel.readInt();
            this.horizontalOffsetWithText = parcel.readInt();
            this.verticalOffsetWithText = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }
    }
}
