package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.huawei.hms.analytics.instance.CallBack;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final long PLACEHOLDER_FADE_DURATION = 87;
    private static final long PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;
    @Nullable
    private MaterialShapeDrawable boxBackground;
    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    @Nullable
    private MaterialShapeDrawable boxUnderline;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    @Nullable
    private ColorStateList counterTextColor;
    @Nullable
    private TextView counterView;
    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    @ColorInt
    private int defaultStrokeColor;
    @ColorInt
    private int disabledColor;
    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;
    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    /* access modifiers changed from: private */
    @NonNull
    public final CheckableImageButton endIconView;
    @NonNull
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;
    @ColorInt
    private int focusedFilledBackgroundColor;
    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    @ColorInt
    private int hoveredFilledBackgroundColor;
    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxWidth;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    /* access modifiers changed from: private */
    public boolean placeholderEnabled;
    @Nullable
    private Fade placeholderFadeIn;
    @Nullable
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    @Nullable
    private CharSequence prefixText;
    @NonNull
    private final TextView prefixTextView;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    @NonNull
    private final CheckableImageButton startIconView;
    @NonNull
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;
    @Nullable
    private CharSequence suffixText;
    @NonNull
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Editable editable;
            boolean z11;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z12 = !TextUtils.isEmpty(editable);
            boolean z13 = !TextUtils.isEmpty(hint);
            boolean z14 = !this.layout.isHintExpanded();
            boolean z15 = !TextUtils.isEmpty(error);
            if (z15 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z13) {
                str = hint.toString();
            } else {
                str = "";
            }
            if (z12) {
                accessibilityNodeInfoCompat.setText(editable);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (z14 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (z12) {
                        str = editable + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z12);
            }
            if (editable == null || editable.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z11) {
                if (!z15) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        @Nullable
        CharSequence error;
        @Nullable
        CharSequence helperText;
        @Nullable
        CharSequence hintText;
        boolean isEndIconChecked;
        @Nullable
        CharSequence placeholderText;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            TextUtils.writeToParcel(this.error, parcel, i11);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i11);
            TextUtils.writeToParcel(this.helperText, parcel, i11);
            TextUtils.writeToParcel(this.placeholderText, parcel, i11);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText2 = this.editText;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText3 = this.editText;
                ViewCompat.setPaddingRelative(editText3, ViewCompat.getPaddingStart(editText3), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            if (canDrawOutlineStroke()) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            int calculateBoxBackgroundColor = calculateBoxBackgroundColor();
            this.boxBackgroundColor = calculateBoxBackgroundColor;
            this.boxBackground.setFillColor(ColorStateList.valueOf(calculateBoxBackgroundColor));
            if (this.endIconMode == 3) {
                this.editText.getBackground().invalidateSelf();
            }
            applyBoxUnderlineAttributes();
            invalidate();
        }
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline != null) {
            if (canDrawStroke()) {
                this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
    }

    private void applyCutoutPadding(@NonNull RectF rectF) {
        float f11 = rectF.left;
        int i11 = this.boxLabelCutoutPaddingPx;
        rectF.left = f11 - ((float) i11);
        rectF.right += (float) i11;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(@NonNull CheckableImageButton checkableImageButton, boolean z11, ColorStateList colorStateList, boolean z12, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z11 || z12)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z11) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z12) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int i11 = this.boxBackgroundMode;
        if (i11 == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
        } else if (i11 == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new MaterialShapeDrawable();
        } else if (i11 == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        } else {
            throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int calculateBoxBackgroundColor() {
        int i11 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) {
            return MaterialColors.layer(MaterialColors.getColor((View) this, R.attr.colorSurface, 0), this.boxBackgroundColor);
        }
        return i11;
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect rect) {
        boolean z11;
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            rect2.bottom = rect.bottom;
            int i11 = this.boxBackgroundMode;
            if (i11 == 1) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z11);
                rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z11);
                return rect2;
            } else if (i11 != 2) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z11);
                rect2.top = getPaddingTop();
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z11);
                return rect2;
            } else {
                rect2.left = rect.left + this.editText.getPaddingLeft();
                rect2.top = rect.top - calculateLabelMarginTop();
                rect2.right = rect.right - this.editText.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int calculateExpandedLabelBottom(@NonNull Rect rect, @NonNull Rect rect2, float f11) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect2.top) + f11);
        }
        return rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect rect, float f11) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect.centerY()) - (f11 / 2.0f));
        }
        return rect.top + this.editText.getCompoundPaddingTop();
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i11 = this.boxBackgroundMode;
        if (i11 == 0 || i11 == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else if (i11 != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z11) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z11 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private Fade createPlaceholderFadeTransition() {
        Fade fade = new Fade();
        fade.setDuration(PLACEHOLDER_FADE_DURATION);
        fade.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return fade;
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void dispatchOnEndIconChanged(int i11) {
        Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i11);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(@NonNull Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z11) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z11 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        if (endIconDelegate != null) {
            return endIconDelegate;
        }
        return this.endIconDelegates.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i11, boolean z11) {
        int compoundPaddingLeft = i11 + this.editText.getCompoundPaddingLeft();
        if (this.prefixText == null || z11) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i11, boolean z11) {
        int compoundPaddingRight = i11 - this.editText.getCompoundPaddingRight();
        if (this.prefixText == null || !z11) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
        }
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) {
            return false;
        }
        return true;
    }

    private int[] mergeIconState(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.boxStrokeWidthPx));
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private void recalculateCutout() {
        if (cutoutEnabled() && !this.hintExpanded) {
            closeCutout();
            openCutout();
        }
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup viewGroup, boolean z11) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            childAt.setEnabled(z11);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z11);
            }
        }
    }

    private void refreshIconDrawableState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(mergeIconState(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            setMinWidth(this.minWidth);
            setMaxWidth(this.maxWidth);
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & CallBack.OAID_TRACKING_OFF) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(@NonNull Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.counterEnabled) {
                        textInputLayout2.updateCounter(editable.length());
                    }
                    if (TextInputLayout.this.placeholderEnabled) {
                        TextInputLayout.this.updatePlaceholderText(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint2 = this.editText.getHint();
                    this.originalHint = hint2;
                    setHint(hint2);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            dispatchOnEditTextAttached();
            updatePrefixTextViewPadding();
            updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText2.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z11) {
        int i11;
        CheckableImageButton checkableImageButton = this.errorIconView;
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        checkableImageButton.setVisibility(i11);
        FrameLayout frameLayout = this.endIconFrame;
        if (z11) {
            i12 = 8;
        }
        frameLayout.setVisibility(i12);
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            updateDummyDrawables();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    private static void setIconClickable(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean z11;
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z12 = false;
        int i11 = 1;
        if (onLongClickListener != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (hasOnClickListeners || z11) {
            z12 = true;
        }
        checkableImageButton.setFocusable(z12);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z11);
        if (!z12) {
            i11 = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i11);
    }

    private static void setIconOnClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private void setPlaceholderTextEnabled(boolean z11) {
        if (this.placeholderEnabled != z11) {
            if (z11) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.placeholderTextView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_placeholder);
                Fade createPlaceholderFadeTransition = createPlaceholderFadeTransition();
                this.placeholderFadeIn = createPlaceholderFadeTransition;
                createPlaceholderFadeTransition.setStartDelay(PLACEHOLDER_START_DELAY);
                this.placeholderFadeOut = createPlaceholderFadeTransition();
                ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
                setPlaceholderTextAppearance(this.placeholderTextAppearance);
                setPlaceholderTextColor(this.placeholderTextColor);
                addPlaceholderTextView();
            } else {
                removePlaceholderTextView();
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z11;
        }
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if ((this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if ((getStartIconDrawable() != null || this.prefixText != null) && this.startLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText2 = this.editText;
        if (editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) {
            return false;
        }
        return true;
    }

    private void showPlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText(this.placeholderText);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    private void tintEndIconOnError(boolean z11) {
        if (!z11 || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(mutate, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode != 1) {
            return;
        }
        if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void updateBoxUnderlineBounds(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            int i11 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i11 - this.boxStrokeWidthFocusedPx, rect.right, i11);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    private static void updateCounterContentDescription(@NonNull Context context, @NonNull TextView textView, int i11, int i12, boolean z11) {
        int i13;
        if (z11) {
            i13 = R.string.character_counter_overflowed_content_description;
        } else {
            i13 = R.string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i13, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    private void updateCounterTextAppearanceAndColor() {
        int i11;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            if (this.counterOverflowed) {
                i11 = this.counterOverflowTextAppearance;
            } else {
                i11 = this.counterTextAppearance;
            }
            setTextAppearanceCompatWithErrorFallback(textView, i11);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateDummyDrawables() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.editText
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.shouldUpdateStartDummyDrawable()
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            if (r0 == 0) goto L_0x0049
            android.widget.LinearLayout r0 = r10.startLayout
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.startDummyDrawable
            if (r6 == 0) goto L_0x0025
            int r6 = r10.startDummyDrawableWidth
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.startDummyDrawable = r6
            r10.startDummyDrawableWidth = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.startDummyDrawable
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.editText
            r8 = r0[r5]
            r9 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.startDummyDrawable
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            android.widget.EditText r6 = r10.editText
            r7 = r0[r5]
            r8 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r2, r7, r8, r0)
            r10.startDummyDrawable = r2
        L_0x0060:
            r0 = r5
            goto L_0x0063
        L_0x0062:
            r0 = r1
        L_0x0063:
            boolean r6 = r10.shouldUpdateEndDummyDrawable()
            if (r6 == 0) goto L_0x00d1
            android.widget.TextView r2 = r10.suffixTextView
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x008c
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.view.MarginLayoutParamsCompat.getMarginStart(r6)
            int r2 = r2 + r6
        L_0x008c:
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r7 == 0) goto L_0x00ad
            int r8 = r10.endDummyDrawableWidth
            if (r8 == r2) goto L_0x00ad
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r3, r4)
            goto L_0x00f2
        L_0x00ad:
            if (r7 != 0) goto L_0x00bb
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.endDummyDrawable = r7
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00bb:
            r2 = r6[r3]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            if (r2 == r3) goto L_0x00cf
            r10.originalEditTextEndDrawable = r2
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r3, r4)
            goto L_0x00f2
        L_0x00cf:
            r5 = r0
            goto L_0x00f2
        L_0x00d1:
            android.graphics.drawable.Drawable r6 = r10.endDummyDrawable
            if (r6 == 0) goto L_0x00f3
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            r3 = r6[r3]
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r3 != r7) goto L_0x00ef
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.originalEditTextEndDrawable
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r3, r7, r4)
            goto L_0x00f0
        L_0x00ef:
            r5 = r0
        L_0x00f0:
            r10.endDummyDrawable = r2
        L_0x00f2:
            r0 = r5
        L_0x00f3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText2;
        if (this.placeholderTextView != null && (editText2 = this.editText) != null) {
            this.placeholderTextView.setGravity(editText2.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
    }

    private void updatePlaceholderText() {
        EditText editText2 = this.editText;
        updatePlaceholderText(editText2 == null ? 0 : editText2.getText().length());
    }

    private void updatePrefixTextViewPadding() {
        int i11;
        if (this.editText != null) {
            if (isStartIconVisible()) {
                i11 = 0;
            } else {
                i11 = ViewCompat.getPaddingStart(this.editText);
            }
            ViewCompat.setPaddingRelative(this.prefixTextView, i11, this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
        }
    }

    private void updatePrefixTextVisibility() {
        int i11;
        TextView textView = this.prefixTextView;
        if (this.prefixText == null || isHintExpanded()) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        textView.setVisibility(i11);
        updateDummyDrawables();
    }

    private void updateStrokeErrorColor(boolean z11, boolean z12) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z11) {
            this.boxStrokeColor = colorForState2;
        } else if (z12) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void updateSuffixTextViewPadding() {
        int i11;
        if (this.editText != null) {
            if (isEndIconVisible() || isErrorIconVisible()) {
                i11 = 0;
            } else {
                i11 = ViewCompat.getPaddingEnd(this.editText);
            }
            ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), i11, this.editText.getPaddingBottom());
        }
    }

    private void updateSuffixTextVisibility() {
        boolean z11;
        int visibility = this.suffixTextView.getVisibility();
        int i11 = 0;
        if (this.suffixText == null || isHintExpanded()) {
            z11 = false;
        } else {
            z11 = true;
        }
        TextView textView = this.suffixTextView;
        if (!z11) {
            i11 = 8;
        }
        textView.setVisibility(i11);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z11);
        }
        updateDummyDrawables();
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    public void addView(@NonNull View view, int i11, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & CallBack.OAID_TRACKING_OFF) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i11, layoutParams);
    }

    @VisibleForTesting
    public void animateToExpansionFraction(float f11) {
        if (this.collapsingTextHelper.getExpansionFraction() != f11) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f11});
            this.animator.start();
        }
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @VisibleForTesting
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout();
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i11) {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i11);
            return;
        }
        if (this.originalHint != null) {
            boolean z11 = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint2 = editText2.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i11);
            } finally {
                this.editText.setHint(hint2);
                this.isProvidingHint = z11;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i11);
            onProvideAutofillVirtualStructure(viewStructure, i11);
            viewStructure.setChildCount(this.inputFrame.getChildCount());
            for (int i12 = 0; i12 < this.inputFrame.getChildCount(); i12++) {
                View childAt = this.inputFrame.getChildAt(i12);
                ViewStructure newChild = viewStructure.newChild(i12);
                childAt.dispatchProvideAutofillStructure(newChild, i11);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    public void drawableStateChanged() {
        boolean z11;
        if (!this.inDrawableStateChanged) {
            boolean z12 = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2 != null) {
                z11 = collapsingTextHelper2.setState(drawableState) | false;
            } else {
                z11 = false;
            }
            if (this.editText != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z12 = false;
                }
                updateLabelState(z12);
            }
            updateEditTextBackground();
            updateTextInputBoxState();
            if (z11) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            return editText2.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i11 = this.boxBackgroundMode;
        if (i11 == 1 || i11 == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @VisibleForTesting
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & CallBack.OAID_TRACKING_OFF) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateDummyDrawables = updateDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
            this.editText.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.endIconView.performClick();
                    TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        boolean z11;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        if (!hasEndIcon() || !this.endIconView.isChecked()) {
            z11 = false;
        } else {
            z11 = true;
        }
        savedState.isEndIconChecked = z11;
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z11) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z11) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i11) {
        if (this.boxBackgroundColor != i11) {
            this.boxBackgroundColor = i11;
            this.defaultFilledBackgroundColor = i11;
            this.focusedFilledBackgroundColor = i11;
            this.hoveredFilledBackgroundColor = i11;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i11) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i11) {
        if (i11 != this.boxBackgroundMode) {
            this.boxBackgroundMode = i11;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i11) {
        this.boxCollapsedPaddingTopPx = i11;
    }

    public void setBoxCornerRadii(float f11, float f12, float f13, float f14) {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f11 || this.boxBackground.getTopRightCornerResolvedSize() != f12 || this.boxBackground.getBottomRightCornerResolvedSize() != f14 || this.boxBackground.getBottomLeftCornerResolvedSize() != f13) {
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f11).setTopRightCornerSize(f12).setBottomRightCornerSize(f14).setBottomLeftCornerSize(f13).build();
            applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i11, @DimenRes int i12, @DimenRes int i13, @DimenRes int i14) {
        setBoxCornerRadii(getContext().getResources().getDimension(i11), getContext().getResources().getDimension(i12), getContext().getResources().getDimension(i14), getContext().getResources().getDimension(i13));
    }

    public void setBoxStrokeColor(@ColorInt int i11) {
        if (this.focusedStrokeColor != i11) {
            this.focusedStrokeColor = i11;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i11) {
        this.boxStrokeWidthDefaultPx = i11;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i11) {
        this.boxStrokeWidthFocusedPx = i11;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i11) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i11));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i11) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i11));
    }

    public void setCounterEnabled(boolean z11) {
        if (this.counterEnabled != z11) {
            if (z11) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z11;
        }
    }

    public void setCounterMaxLength(int i11) {
        if (this.counterMaxLength != i11) {
            if (i11 > 0) {
                this.counterMaxLength = i11;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i11) {
        if (this.counterOverflowTextAppearance != i11) {
            this.counterOverflowTextAppearance = i11;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i11) {
        if (this.counterTextAppearance != i11) {
            this.counterTextAppearance = i11;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public void setEnabled(boolean z11) {
        recursiveSetEnabled(this, z11);
        super.setEnabled(z11);
    }

    public void setEndIconActivated(boolean z11) {
        this.endIconView.setActivated(z11);
    }

    public void setEndIconCheckable(boolean z11) {
        this.endIconView.setCheckable(z11);
    }

    public void setEndIconContentDescription(@StringRes int i11) {
        setEndIconContentDescription(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i11) {
        setEndIconDrawable(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }

    public void setEndIconMode(int i11) {
        boolean z11;
        int i12 = this.endIconMode;
        this.endIconMode = i11;
        dispatchOnEndIconChanged(i12);
        if (i11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        setEndIconVisible(z11);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i11);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z11) {
        int i11;
        if (isEndIconVisible() != z11) {
            CheckableImageButton checkableImageButton = this.endIconView;
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            checkableImageButton.setVisibility(i11);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.indicatorViewController.setErrorContentDescription(charSequence);
    }

    public void setErrorEnabled(boolean z11) {
        this.indicatorViewController.setErrorEnabled(z11);
    }

    public void setErrorIconDrawable(@DrawableRes int i11) {
        setErrorIconDrawable(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i11) {
        this.indicatorViewController.setErrorTextAppearance(i11);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z11) {
        if (this.expandedHintEnabled != z11) {
            this.expandedHintEnabled = z11;
            updateLabelState(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z11) {
        this.indicatorViewController.setHelperTextEnabled(z11);
    }

    public void setHelperTextTextAppearance(@StyleRes int i11) {
        this.indicatorViewController.setHelperTextAppearance(i11);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z11) {
        this.hintAnimationEnabled = z11;
    }

    public void setHintEnabled(boolean z11) {
        if (z11 != this.hintEnabled) {
            this.hintEnabled = z11;
            if (!z11) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i11) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i11);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public void setMaxWidth(@Px int i11) {
        this.maxWidth = i11;
        EditText editText2 = this.editText;
        if (editText2 != null && i11 != -1) {
            editText2.setMaxWidth(i11);
        }
    }

    public void setMaxWidthResource(@DimenRes int i11) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    public void setMinWidth(@Px int i11) {
        this.minWidth = i11;
        EditText editText2 = this.editText;
        if (editText2 != null && i11 != -1) {
            editText2.setMinWidth(i11);
        }
    }

    public void setMinWidthResource(@DimenRes int i11) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i11) {
        setPasswordVisibilityToggleContentDescription(i11 != 0 ? getResources().getText(i11) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i11) {
        setPasswordVisibilityToggleDrawable(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z11) {
        if (z11 && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z11) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (!this.placeholderEnabled || !TextUtils.isEmpty(charSequence)) {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i11) {
        this.placeholderTextAppearance = i11;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i11);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.prefixText = charSequence2;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public void setPrefixTextAppearance(@StyleRes int i11) {
        TextViewCompat.setTextAppearance(this.prefixTextView, i11);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z11) {
        this.startIconView.setCheckable(z11);
    }

    public void setStartIconContentDescription(@StringRes int i11) {
        setStartIconContentDescription(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i11) {
        setStartIconDrawable(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z11) {
        int i11;
        if (isStartIconVisible() != z11) {
            CheckableImageButton checkableImageButton = this.startIconView;
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            checkableImageButton.setVisibility(i11);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.suffixText = charSequence2;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(@StyleRes int i11) {
        TextViewCompat.setTextAppearance(this.suffixTextView, i11);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView textView, @StyleRes int i11) {
        boolean z11 = true;
        try {
            TextViewCompat.setTextAppearance(textView, i11);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z11 = false;
            }
        } catch (Exception unused) {
        }
        if (z11) {
            TextViewCompat.setTextAppearance(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            ViewCompat.setAccessibilityDelegate(editText2, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.setTypefaces(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.indicatorViewController.errorShouldBeShown()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                DrawableCompat.clearColorFilter(background);
                this.editText.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public void updateLabelState(boolean z11) {
        updateLabelState(z11, false);
    }

    public void updateTextInputBoxState() {
        boolean z11;
        boolean z12;
        TextView textView;
        EditText editText2;
        EditText editText3;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z13 = false;
            if (isFocused() || ((editText3 = this.editText) != null && editText3.hasFocus())) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (isHovered() || ((editText2 = this.editText) != null && editText2.isHovered())) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.errorShouldBeShown()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z11, z12);
                } else {
                    this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
                }
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                if (z11) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z12) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
            } else if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z11, z12);
            } else {
                this.boxStrokeColor = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null && this.indicatorViewController.isErrorEnabled() && this.indicatorViewController.errorShouldBeShown()) {
                z13 = true;
            }
            setErrorIconVisible(z13);
            refreshErrorIconDrawableState();
            refreshStartIconDrawableState();
            refreshEndIconDrawableState();
            if (getEndIconDelegate().shouldTintIconOnError()) {
                tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
            }
            int i11 = this.boxStrokeWidthPx;
            if (!z11 || !isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            }
            if (this.boxStrokeWidthPx != i11 && this.boxBackgroundMode == 2) {
                recalculateCutout();
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z12 && !z11) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z11) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z11, boolean z12) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z13 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        boolean z14 = editText3 != null && editText3.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z14 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z13 || !this.expandedHintEnabled || (isEnabled() && z14)) {
            if (z12 || this.hintExpanded) {
                collapseHint(z11);
            }
        } else if (z12 || !this.hintExpanded) {
            expandHint(z11);
        }
    }

    /* access modifiers changed from: private */
    public void updatePlaceholderText(int i11) {
        if (i11 != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        if (drawable != null) {
            applyEndIconTint();
            refreshEndIconDrawableState();
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            applyStartIconTint();
            setStartIconVisible(true);
            refreshStartIconDrawableState();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r27, @androidx.annotation.Nullable android.util.AttributeSet r28, int r29) {
        /*
            r26 = this;
            r0 = r26
            r7 = r28
            r8 = r29
            int r9 = DEF_STYLE_RES
            r1 = r27
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.minWidth = r10
            r0.maxWidth = r10
            com.google.android.material.textfield.IndicatorViewController r1 = new com.google.android.material.textfield.IndicatorViewController
            r1.<init>(r0)
            r0.indicatorViewController = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpRect = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpBoundsRect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.tmpRectF = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.editTextAttachedListeners = r1
            r11 = 0
            r0.endIconMode = r11
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            r0.endIconDelegates = r12
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.endIconChangedListeners = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.collapsingTextHelper = r1
            android.content.Context r13 = r26.getContext()
            r14 = 1
            r0.setOrientation(r14)
            r0.setWillNotDraw(r11)
            r0.setAddStatesFromChildren(r14)
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            r2.<init>(r13)
            r0.inputFrame = r2
            r2.setAddStatesFromChildren(r14)
            r0.addView(r2)
            android.widget.LinearLayout r15 = new android.widget.LinearLayout
            r15.<init>(r13)
            r0.startLayout = r15
            r15.setOrientation(r11)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r6 = -2
            r3.<init>(r6, r10, r4)
            r15.setLayoutParams(r3)
            r2.addView(r15)
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r5.<init>(r13)
            r0.endLayout = r5
            r5.setOrientation(r11)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = 8388613(0x800005, float:1.175495E-38)
            r3.<init>(r6, r10, r4)
            r5.setLayoutParams(r3)
            r2.addView(r5)
            android.widget.FrameLayout r4 = new android.widget.FrameLayout
            r4.<init>(r13)
            r0.endIconFrame = r4
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r6, r10)
            r4.setLayoutParams(r2)
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.setTextSizeInterpolator(r2)
            r1.setPositionInterpolator(r2)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.setCollapsedTextGravity(r2)
            int[] r3 = com.google.android.material.R.styleable.TextInputLayout
            r1 = 5
            int[] r2 = new int[r1]
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r2[r11] = r1
            int r11 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            r2[r14] = r11
            int r10 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            r14 = 2
            r2[r14] = r10
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            r16 = r12
            r12 = 3
            r2[r12] = r14
            int r12 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r17 = 4
            r2[r17] = r12
            r17 = r15
            r15 = r1
            r1 = r13
            r18 = r2
            r2 = r28
            r19 = r4
            r4 = r29
            r20 = r11
            r11 = r5
            r5 = r9
            r6 = r18
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintEnabled
            r3 = 1
            boolean r2 = r1.getBoolean(r2, r3)
            r0.hintEnabled = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setHint((java.lang.CharSequence) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r2 = r1.getBoolean(r2, r3)
            r0.hintAnimationEnabled = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_expandedHintEnabled
            boolean r2 = r1.getBoolean(r2, r3)
            r0.expandedHintEnabled = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0122
            r3 = -1
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.setMinWidth(r2)
            goto L_0x0123
        L_0x0122:
            r3 = -1
        L_0x0123:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            boolean r4 = r1.hasValue(r2)
            if (r4 == 0) goto L_0x0132
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.setMaxWidth(r2)
        L_0x0132:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r13, (android.util.AttributeSet) r7, (int) r8, (int) r9)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            r0.shapeAppearanceModel = r2
            android.content.res.Resources r2 = r13.getResources()
            int r3 = com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.boxLabelCutoutPaddingPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop
            r3 = 0
            int r2 = r1.getDimensionPixelOffset(r2, r3)
            r0.boxCollapsedPaddingTopPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.boxStrokeWidthDefaultPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.boxStrokeWidthFocusedPx = r2
            int r2 = r0.boxStrokeWidthDefaultPx
            r0.boxStrokeWidthPx = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r1.getDimension(r2, r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r4 = r1.getDimension(r4, r3)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r5 = r1.getDimension(r5, r3)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r3 = r1.getDimension(r6, r3)
            com.google.android.material.shape.ShapeAppearanceModel r6 = r0.shapeAppearanceModel
            com.google.android.material.shape.ShapeAppearanceModel$Builder r6 = r6.toBuilder()
            r7 = 0
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x01a1
            r6.setTopLeftCornerSize((float) r2)
        L_0x01a1:
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01a8
            r6.setTopRightCornerSize((float) r4)
        L_0x01a8:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01af
            r6.setBottomRightCornerSize((float) r5)
        L_0x01af:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01b6
            r6.setBottomLeftCornerSize((float) r3)
        L_0x01b6:
            com.google.android.material.shape.ShapeAppearanceModel r2 = r6.build()
            r0.shapeAppearanceModel = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            if (r2 == 0) goto L_0x021f
            int r3 = r2.getDefaultColor()
            r0.defaultFilledBackgroundColor = r3
            r0.boxBackgroundColor = r3
            boolean r3 = r2.isStateful()
            r4 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r3 == 0) goto L_0x01fa
            r3 = 1
            int[] r5 = new int[r3]
            r3 = 0
            r5[r3] = r4
            r3 = -1
            int r4 = r2.getColorForState(r5, r3)
            r0.disabledFilledBackgroundColor = r4
            r4 = 2
            int[] r5 = new int[r4]
            r5 = {16842908, 16842910} // fill-array
            int r5 = r2.getColorForState(r5, r3)
            r0.focusedFilledBackgroundColor = r5
            int[] r5 = new int[r4]
            r5 = {16843623, 16842910} // fill-array
            int r2 = r2.getColorForState(r5, r3)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x022a
        L_0x01fa:
            r3 = -1
            int r2 = r0.defaultFilledBackgroundColor
            r0.focusedFilledBackgroundColor = r2
            int r2 = com.google.android.material.R.color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r13, r2)
            r5 = 1
            int[] r6 = new int[r5]
            r7 = 0
            r6[r7] = r4
            int r4 = r2.getColorForState(r6, r3)
            r0.disabledFilledBackgroundColor = r4
            int[] r4 = new int[r5]
            r5 = 16843623(0x1010367, float:2.3696E-38)
            r4[r7] = r5
            int r2 = r2.getColorForState(r4, r3)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x022a
        L_0x021f:
            r7 = 0
            r0.boxBackgroundColor = r7
            r0.defaultFilledBackgroundColor = r7
            r0.disabledFilledBackgroundColor = r7
            r0.focusedFilledBackgroundColor = r7
            r0.hoveredFilledBackgroundColor = r7
        L_0x022a:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x023a
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.focusedTextColor = r2
            r0.defaultHintTextColor = r2
        L_0x023a:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r4 = 0
            int r2 = r1.getColor(r2, r4)
            r0.focusedStrokeColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color
            int r2 = androidx.core.content.ContextCompat.getColor(r13, r2)
            r0.defaultStrokeColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_disabled_color
            int r2 = androidx.core.content.ContextCompat.getColor(r13, r2)
            r0.disabledColor = r2
            int r2 = com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color
            int r2 = androidx.core.content.ContextCompat.getColor(r13, r2)
            r0.hoveredStrokeColor = r2
            if (r3 == 0) goto L_0x0264
            r0.setBoxStrokeColorStateList(r3)
        L_0x0264:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0273
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.setBoxStrokeErrorColor(r2)
        L_0x0273:
            r2 = -1
            int r3 = r1.getResourceId(r12, r2)
            if (r3 == r2) goto L_0x0283
            r2 = 0
            int r3 = r1.getResourceId(r12, r2)
            r0.setHintTextAppearance(r3)
            goto L_0x0284
        L_0x0283:
            r2 = 0
        L_0x0284:
            int r3 = r1.getResourceId(r10, r2)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r4 = r1.getText(r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorEnabled
            boolean r5 = r1.getBoolean(r5, r2)
            android.content.Context r6 = r26.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r7 = com.google.android.material.R.layout.design_text_input_end_icon
            android.view.View r6 = r6.inflate(r7, r11, r2)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.errorIconView = r6
            int r8 = com.google.android.material.R.id.text_input_error_icon
            r6.setId(r8)
            r8 = 8
            r6.setVisibility(r8)
            boolean r9 = com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(r13)
            if (r9 == 0) goto L_0x02bf
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart(r9, r2)
        L_0x02bf:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            boolean r9 = r1.hasValue(r2)
            if (r9 == 0) goto L_0x02ce
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
            r0.setErrorIconDrawable((android.graphics.drawable.Drawable) r2)
        L_0x02ce:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            boolean r9 = r1.hasValue(r2)
            if (r9 == 0) goto L_0x02dd
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.setErrorIconTintList(r2)
        L_0x02dd:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            boolean r9 = r1.hasValue(r2)
            r10 = 0
            if (r9 == 0) goto L_0x02f2
            r9 = -1
            int r2 = r1.getInt(r2, r9)
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r10)
            r0.setErrorIconTintMode(r2)
        L_0x02f2:
            android.content.res.Resources r2 = r26.getResources()
            int r9 = com.google.android.material.R.string.error_icon_content_description
            java.lang.CharSequence r2 = r2.getText(r9)
            r6.setContentDescription(r2)
            r2 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r2)
            r2 = 0
            r6.setClickable(r2)
            r6.setPressable(r2)
            r6.setFocusable(r2)
            int r9 = r1.getResourceId(r14, r2)
            int r12 = com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled
            boolean r12 = r1.getBoolean(r12, r2)
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r14 = r1.getText(r14)
            int r10 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance
            int r10 = r1.getResourceId(r10, r2)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r8 = r1.getText(r8)
            r18 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_prefixTextAppearance
            int r10 = r1.getResourceId(r10, r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixText
            java.lang.CharSequence r2 = r1.getText(r2)
            r21 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_suffixTextAppearance
            r22 = r2
            r2 = 0
            int r10 = r1.getResourceId(r10, r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixText
            java.lang.CharSequence r2 = r1.getText(r2)
            r23 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_counterEnabled
            r24 = r2
            r2 = 0
            boolean r10 = r1.getBoolean(r10, r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterMaxLength
            r25 = r10
            r10 = -1
            int r2 = r1.getInt(r2, r10)
            r0.setCounterMaxLength(r2)
            r2 = 0
            int r10 = r1.getResourceId(r15, r2)
            r0.counterTextAppearance = r10
            r10 = r20
            int r10 = r1.getResourceId(r10, r2)
            r0.counterOverflowTextAppearance = r10
            android.content.Context r10 = r26.getContext()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
            int r15 = com.google.android.material.R.layout.design_text_input_start_icon
            r20 = r8
            r8 = r17
            android.view.View r10 = r10.inflate(r15, r8, r2)
            com.google.android.material.internal.CheckableImageButton r10 = (com.google.android.material.internal.CheckableImageButton) r10
            r0.startIconView = r10
            r15 = 8
            r10.setVisibility(r15)
            boolean r15 = com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(r13)
            if (r15 == 0) goto L_0x0398
            android.view.ViewGroup$LayoutParams r15 = r10.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r15 = (android.view.ViewGroup.MarginLayoutParams) r15
            androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r15, r2)
        L_0x0398:
            r2 = 0
            r0.setStartIconOnClickListener(r2)
            r0.setStartIconOnLongClickListener(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable
            boolean r15 = r1.hasValue(r2)
            if (r15 == 0) goto L_0x03c7
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
            r0.setStartIconDrawable((android.graphics.drawable.Drawable) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription
            boolean r15 = r1.hasValue(r2)
            if (r15 == 0) goto L_0x03bd
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setStartIconContentDescription((java.lang.CharSequence) r2)
        L_0x03bd:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_startIconCheckable
            r15 = 1
            boolean r2 = r1.getBoolean(r2, r15)
            r0.setStartIconCheckable(r2)
        L_0x03c7:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_startIconTint
            boolean r15 = r1.hasValue(r2)
            if (r15 == 0) goto L_0x03d6
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.setStartIconTintList(r2)
        L_0x03d6:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode
            boolean r15 = r1.hasValue(r2)
            if (r15 == 0) goto L_0x03eb
            r15 = -1
            int r2 = r1.getInt(r2, r15)
            r15 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r15)
            r0.setStartIconTintMode(r2)
        L_0x03eb:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode
            r15 = 0
            int r2 = r1.getInt(r2, r15)
            r0.setBoxBackgroundMode(r2)
            android.content.Context r2 = r26.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r17 = r4
            r4 = r19
            android.view.View r2 = r2.inflate(r7, r4, r15)
            com.google.android.material.internal.CheckableImageButton r2 = (com.google.android.material.internal.CheckableImageButton) r2
            r0.endIconView = r2
            r4.addView(r2)
            r7 = 8
            r2.setVisibility(r7)
            boolean r7 = com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(r13)
            if (r7 == 0) goto L_0x0420
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart(r2, r15)
        L_0x0420:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            int r2 = r1.getResourceId(r2, r15)
            com.google.android.material.textfield.CustomEndIconDelegate r7 = new com.google.android.material.textfield.CustomEndIconDelegate
            r7.<init>(r0, r2)
            r29 = r3
            r15 = r16
            r3 = -1
            r15.append(r3, r7)
            com.google.android.material.textfield.NoEndIconDelegate r3 = new com.google.android.material.textfield.NoEndIconDelegate
            r3.<init>(r0)
            r7 = 0
            r15.append(r7, r3)
            com.google.android.material.textfield.PasswordToggleEndIconDelegate r3 = new com.google.android.material.textfield.PasswordToggleEndIconDelegate
            if (r2 != 0) goto L_0x0449
            r16 = r5
            int r5 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleDrawable
            int r5 = r1.getResourceId(r5, r7)
            goto L_0x044c
        L_0x0449:
            r16 = r5
            r5 = r2
        L_0x044c:
            r3.<init>(r0, r5)
            r5 = 1
            r15.append(r5, r3)
            com.google.android.material.textfield.ClearTextEndIconDelegate r3 = new com.google.android.material.textfield.ClearTextEndIconDelegate
            r3.<init>(r0, r2)
            r5 = 2
            r15.append(r5, r3)
            com.google.android.material.textfield.DropdownMenuEndIconDelegate r3 = new com.google.android.material.textfield.DropdownMenuEndIconDelegate
            r3.<init>(r0, r2)
            r2 = 3
            r15.append(r2, r3)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x048f
            r3 = 0
            int r2 = r1.getInt(r2, r3)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0484
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
        L_0x0484:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconCheckable
            r3 = 1
            boolean r2 = r1.getBoolean(r2, r3)
            r0.setEndIconCheckable(r2)
            goto L_0x04cc
        L_0x048f:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x04cc
            r3 = 0
            boolean r2 = r1.getBoolean(r2, r3)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x04b7
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x04b7:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x04cc
            r3 = -1
            int r2 = r1.getInt(r2, r3)
            r3 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r3)
            r0.setEndIconTintMode(r2)
        L_0x04cc:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.hasValue(r2)
            if (r2 != 0) goto L_0x04f8
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x04e3
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x04e3:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x04f8
            r3 = -1
            int r2 = r1.getInt(r2, r3)
            r3 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r3)
            r0.setEndIconTintMode(r2)
        L_0x04f8:
            androidx.appcompat.widget.AppCompatTextView r2 = new androidx.appcompat.widget.AppCompatTextView
            r2.<init>(r13)
            r0.prefixTextView = r2
            int r3 = com.google.android.material.R.id.textinput_prefix_text
            r2.setId(r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r5 = -2
            r3.<init>(r5, r5)
            r2.setLayoutParams(r3)
            r3 = 1
            androidx.core.view.ViewCompat.setAccessibilityLiveRegion(r2, r3)
            r8.addView(r10)
            r8.addView(r2)
            androidx.appcompat.widget.AppCompatTextView r2 = new androidx.appcompat.widget.AppCompatTextView
            r2.<init>(r13)
            r0.suffixTextView = r2
            int r3 = com.google.android.material.R.id.textinput_suffix_text
            r2.setId(r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r7 = 80
            r3.<init>(r5, r5, r7)
            r2.setLayoutParams(r3)
            r3 = 1
            androidx.core.view.ViewCompat.setAccessibilityLiveRegion(r2, r3)
            r11.addView(r2)
            r11.addView(r6)
            r11.addView(r4)
            r0.setHelperTextEnabled(r12)
            r0.setHelperText(r14)
            r0.setHelperTextTextAppearance(r9)
            r2 = r16
            r0.setErrorEnabled(r2)
            r2 = r29
            r0.setErrorTextAppearance(r2)
            r2 = r17
            r0.setErrorContentDescription(r2)
            int r2 = r0.counterTextAppearance
            r0.setCounterTextAppearance(r2)
            int r2 = r0.counterOverflowTextAppearance
            r0.setCounterOverflowTextAppearance(r2)
            r2 = r20
            r0.setPlaceholderText(r2)
            r2 = r18
            r0.setPlaceholderTextAppearance(r2)
            r2 = r22
            r0.setPrefixText(r2)
            r2 = r21
            r0.setPrefixTextAppearance(r2)
            r2 = r24
            r0.setSuffixText(r2)
            r2 = r23
            r0.setSuffixTextAppearance(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0589
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setErrorTextColor(r2)
        L_0x0589:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0598
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHelperTextColor(r2)
        L_0x0598:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05a7
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHintTextColor(r2)
        L_0x05a7:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05b6
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterTextColor(r2)
        L_0x05b6:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05c5
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x05c5:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05d4
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setPlaceholderTextColor(r2)
        L_0x05d4:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05e3
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setPrefixTextColor(r2)
        L_0x05e3:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x05f2
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setSuffixTextColor(r2)
        L_0x05f2:
            r2 = r25
            r0.setCounterEnabled(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_enabled
            r3 = 1
            boolean r2 = r1.getBoolean(r2, r3)
            r0.setEnabled(r2)
            r1.recycle()
            r1 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0611
            androidx.core.view.ViewCompat.setImportantForAutofill(r0, r3)
        L_0x0611:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void updateCounter(int i11) {
        boolean z11 = this.counterOverflowed;
        int i12 = this.counterMaxLength;
        if (i12 == -1) {
            this.counterView.setText(String.valueOf(i11));
            this.counterView.setContentDescription((CharSequence) null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i11 > i12;
            updateCounterContentDescription(getContext(), this.counterView, i11, this.counterMaxLength, this.counterOverflowed);
            if (z11 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i11), Integer.valueOf(this.counterMaxLength)})));
        }
        if (this.editText != null && z11 != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public void setHint(@StringRes int i11) {
        setHint(i11 != 0 ? getResources().getText(i11) : null);
    }
}
