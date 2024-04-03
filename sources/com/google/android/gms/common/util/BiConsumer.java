package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface BiConsumer<T, U> {
    @KeepForSdk
    void accept(@NonNull T t11, @NonNull U u11);
}
