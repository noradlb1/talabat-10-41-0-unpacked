package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
    Context context;
    @DrawableRes
    final int customEndIcon;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    public EndIconDelegate(@NonNull TextInputLayout textInputLayout2, @DrawableRes int i11) {
        this.textInputLayout = textInputLayout2;
        this.context = textInputLayout2.getContext();
        this.endIconView = textInputLayout2.getEndIconView();
        this.customEndIcon = i11;
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int i11) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean z11) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
