package com.materialedittext.validation;

import androidx.annotation.NonNull;

public abstract class METValidator {

    /* renamed from: a  reason: collision with root package name */
    public String f52754a;

    public METValidator(@NonNull String str) {
        this.f52754a = str;
    }

    @NonNull
    public String getErrorMessage() {
        return this.f52754a;
    }

    public abstract boolean isValid(@NonNull CharSequence charSequence, boolean z11);

    public void setErrorMessage(@NonNull String str) {
        this.f52754a = str;
    }
}
