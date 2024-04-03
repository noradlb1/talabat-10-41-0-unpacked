package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzki extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa zzoa;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            zzoa = (zzoa) Preconditions.checkNotNull(zzoaArr[0]);
        } else {
            zzoa = zzog.zzaum;
        }
        try {
            return new zzom(zzkh.encode(zzha.zzd(zzoa), "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()"));
        } catch (UnsupportedEncodingException unused) {
            return zzog.zzaum;
        }
    }
}
