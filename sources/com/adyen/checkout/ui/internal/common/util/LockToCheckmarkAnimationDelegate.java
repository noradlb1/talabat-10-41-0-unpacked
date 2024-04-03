package com.adyen.checkout.ui.internal.common.util;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.adyen.checkout.ui.R;

public final class LockToCheckmarkAnimationDelegate {
    private final TextView mTextView;
    private boolean mValid;
    private final ValidationCallback mValidationCallback;

    public interface ValidationCallback {
        boolean isValid();
    }

    public LockToCheckmarkAnimationDelegate(@NonNull TextView textView, @NonNull ValidationCallback validationCallback) {
        this.mTextView = textView;
        this.mValidationCallback = validationCallback;
        setDrawableRight();
        performValidation();
    }

    private void performValidation() {
        boolean isValid = this.mValidationCallback.isValid();
        if (isValid != this.mValid) {
            setDrawableRight();
            this.mValid = isValid;
            Drawable drawable = this.mTextView.getCompoundDrawables()[2];
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }

    private void setDrawableRight() {
        Context context = this.mTextView.getContext();
        if (this.mValid) {
            Drawable mutate = AppCompatResources.getDrawable(context, R.drawable.ic_lock_to_checkmark_animated_reverse).mutate();
            ThemeUtil.setTintFromAttributeColor(context, mutate, R.attr.colorIconActive);
            TextViewUtil.setCompoundDrawableRight(this.mTextView, mutate);
            return;
        }
        Drawable mutate2 = AppCompatResources.getDrawable(context, R.drawable.ic_lock_to_checkmark_animated).mutate();
        ThemeUtil.setTintFromAttributeColor(context, mutate2, R.attr.colorIconActive);
        TextViewUtil.setCompoundDrawableRight(this.mTextView, mutate2);
    }

    public void onFocusChanged() {
        performValidation();
    }

    public void onTextChanged() {
        performValidation();
    }
}
