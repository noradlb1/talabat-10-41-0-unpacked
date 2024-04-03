package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
public class HashAccumulator {
    private int zaa = 1;

    @NonNull
    @KeepForSdk
    @CanIgnoreReturnValue
    public HashAccumulator addObject(@Nullable Object obj) {
        this.zaa = (this.zaa * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zaa;
    }

    @NonNull
    @CanIgnoreReturnValue
    public final HashAccumulator zaa(boolean z11) {
        this.zaa = (this.zaa * 31) + (z11 ? 1 : 0);
        return this;
    }
}
