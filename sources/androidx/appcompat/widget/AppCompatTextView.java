package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    @NonNull
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    @Nullable
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    @Nullable
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i11);

        void setAutoSizeTextTypeWithDefaults(int i11);

        void setFirstBaselineToTopHeight(@Px int i11);

        void setLastBaselineToBottomHeight(@Px int i11);

        void setTextClassifier(@Nullable TextClassifier textClassifier);
    }

    @RequiresApi(api = 26)
    public class SuperCallerApi26 implements SuperCaller {
        public SuperCallerApi26() {
        }

        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        public int getAutoSizeTextType() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        public TextClassifier getTextClassifier() {
            return AppCompatTextView.super.getTextClassifier();
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i11) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        public void setAutoSizeTextTypeWithDefaults(int i11) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i11);
        }

        public void setFirstBaselineToTopHeight(int i11) {
        }

        public void setLastBaselineToBottomHeight(int i11) {
        }

        public void setTextClassifier(@Nullable TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }
    }

    @RequiresApi(api = 28)
    public class SuperCallerApi28 extends SuperCallerApi26 {
        public SuperCallerApi28() {
            super();
        }

        public void setFirstBaselineToTopHeight(@Px int i11) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i11);
        }

        public void setLastBaselineToBottomHeight(@Px int i11) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i11);
        }
    }

    public AppCompatTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                TextViewCompat.setPrecomputedText(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mEmojiTextViewHelper;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f919a) {
            return getSuperCaller().getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.c();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f919a) {
            return getSuperCaller().getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.d();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f919a) {
            return getSuperCaller().getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f919a) {
            return getSuperCaller().getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (!ViewUtils.f919a) {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.g();
            }
            return 0;
        } else if (getSuperCaller().getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    public SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                this.mSuperCaller = new SuperCallerApi28();
            } else if (i11 >= 26) {
                this.mSuperCaller = new SuperCallerApi26();
            }
        }
        return this.mSuperCaller;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.h();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.i();
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @RequiresApi(api = 26)
    @NonNull
    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            return getSuperCaller().getTextClassifier();
        }
        return appCompatTextClassifierHelper.getTextClassifier();
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.p(this, onCreateInputConnection, editorInfo);
        return AppCompatHintHelper.a(onCreateInputConnection, editorInfo, this);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.m(z11, i11, i12, i13, i14);
        }
    }

    public void onMeasure(int i11, int i12) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i11, i12);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11;
        super.onTextChanged(charSequence, i11, i12, i13);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null || ViewUtils.f919a || !appCompatTextHelper.j()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.mTextHelper.b();
        }
    }

    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().c(z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (ViewUtils.f919a) {
            getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.r(i11, i12, i13, i14);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i11) throws IllegalArgumentException {
        if (ViewUtils.f919a) {
            getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.s(iArr, i11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i11) {
        if (ViewUtils.f919a) {
            getSuperCaller().setAutoSizeTextTypeWithDefaults(i11);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.t(i11);
        }
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i11) {
        super.setBackgroundResource(i11);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i11);
        }
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }

    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }

    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }

    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().d(z11);
    }

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(@Px @IntRange(from = 0) int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setFirstBaselineToTopHeight(i11);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight(this, i11);
        }
    }

    public void setLastBaselineToBottomHeight(@Px @IntRange(from = 0) int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setLastBaselineToBottomHeight(i11);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight(this, i11);
        }
    }

    public void setLineHeight(@Px @IntRange(from = 0) int i11) {
        TextViewCompat.setLineHeight(this, i11);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.mTextHelper.u(colorStateList);
        this.mTextHelper.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTextHelper.v(mode);
        this.mTextHelper.a();
    }

    public void setTextAppearance(Context context, int i11) {
        super.setTextAppearance(context, i11);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.o(context, i11);
        }
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            getSuperCaller().setTextClassifier(textClassifier);
        } else {
            appCompatTextClassifierHelper.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params params) {
        TextViewCompat.setTextMetricsParams(this, params);
    }

    public void setTextSize(int i11, float f11) {
        if (ViewUtils.f919a) {
            super.setTextSize(i11, f11);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.w(i11, f11);
        }
    }

    public void setTypeface(@Nullable Typeface typeface, int i11) {
        Typeface typeface2;
        if (!this.mIsSetTypefaceProcessing) {
            if (typeface == null || i11 <= 0) {
                typeface2 = null;
            } else {
                typeface2 = TypefaceCompat.create(getContext(), typeface, i11);
            }
            this.mIsSetTypefaceProcessing = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i11);
            } finally {
                this.mIsSetTypefaceProcessing = false;
            }
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(TintContextWrapper.wrap(context), attributeSet, i11);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i11);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.k(attributeSet, i11);
        appCompatTextHelper.a();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().b(attributeSet, i11);
    }

    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable drawable2 = i11 != 0 ? AppCompatResources.getDrawable(context, i11) : null;
        Drawable drawable3 = i12 != 0 ? AppCompatResources.getDrawable(context, i12) : null;
        Drawable drawable4 = i13 != 0 ? AppCompatResources.getDrawable(context, i13) : null;
        if (i14 != 0) {
            drawable = AppCompatResources.getDrawable(context, i14);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable drawable2 = i11 != 0 ? AppCompatResources.getDrawable(context, i11) : null;
        Drawable drawable3 = i12 != 0 ? AppCompatResources.getDrawable(context, i12) : null;
        Drawable drawable4 = i13 != 0 ? AppCompatResources.getDrawable(context, i13) : null;
        if (i14 != 0) {
            drawable = AppCompatResources.getDrawable(context, i14);
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.n();
        }
    }
}
