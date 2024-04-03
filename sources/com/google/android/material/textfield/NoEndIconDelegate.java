package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

class NoEndIconDelegate extends EndIconDelegate {
    public NoEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener((View.OnClickListener) null);
        this.textInputLayout.setEndIconDrawable((Drawable) null);
        this.textInputLayout.setEndIconContentDescription((CharSequence) null);
    }
}
