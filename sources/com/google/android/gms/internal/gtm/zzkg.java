package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzkg extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa zzoa;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            zzoa = (zzoa) Preconditions.checkNotNull(zzoaArr[0]);
        } else {
            zzoa = zzog.zzaum;
        }
        try {
            return new zzom(zzkf.decode(zzha.zzd(zzoa), ""));
        } catch (UnsupportedEncodingException unused) {
            return zzog.zzaum;
        }
    }
}
