package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private static final int[] TINT_ATTRS = {16843126};
    @NonNull
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatMultiAutoCompleteTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = getKeyListener();
        if (appCompatEmojiEditTextHelper.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a11 = appCompatEmojiEditTextHelper.a(keyListener);
            if (a11 != keyListener) {
                super.setKeyListener(a11);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
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

    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mAppCompatEmojiEditTextHelper.e(AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
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

    public void setDropDownBackgroundResource(@DrawableRes int i11) {
        setDropDownBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i11));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        this.mAppCompatEmojiEditTextHelper.f(z11);
    }

    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
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

    public AppCompatMultiAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(TintContextWrapper.wrap(context), attributeSet, i11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, TINT_ATTRS, i11, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.d(attributeSet, i11);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.k(attributeSet, i11);
        appCompatTextHelper.a();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.d(attributeSet, i11);
        a(appCompatEmojiEditTextHelper);
    }
}
