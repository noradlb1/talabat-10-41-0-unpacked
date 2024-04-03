package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

public final class zzn extends ActionCodeMultiFactorInfo {
    private final MultiFactorInfo zza;

    public zzn(String str, MultiFactorInfo multiFactorInfo) {
        this.email = Preconditions.checkNotEmpty(str);
        this.zza = (MultiFactorInfo) Preconditions.checkNotNull(multiFactorInfo);
    }

    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }
}
