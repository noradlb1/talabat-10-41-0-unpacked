package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface BaseOnChangeListener<S> {
    void onValueChange(@NonNull S s11, float f11, boolean z11);
}
