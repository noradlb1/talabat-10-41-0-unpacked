package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlj implements zzgz {
    private Context zzrm;

    public zzlj(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        zzog zzog;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length <= 0 || (zzog = zzoaArr[0]) == zzog.zzaum) {
            str = null;
        } else {
            str = zzha.zzd(zzoo.zza(zzfl, (zzoa) zzog));
        }
        String zze = zzeu.zze(this.zzrm, str);
        if (zze != null) {
            return new zzom(zze);
        }
        return zzog.zzaum;
    }
}
