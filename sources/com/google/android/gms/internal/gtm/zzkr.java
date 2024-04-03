package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkr extends zzhb {
    private final zzfj zzarn;
    private final Context zzrm;

    public zzkr(Context context, zzfj zzfj) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzarn = zzfj;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzog zzog;
        zzog zzog2;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 0 || zzoaArr[0] == (zzog = zzog.zzaum)) {
            return new zzom("");
        }
        Object obj = this.zzarn.zzkt().zzib().get("_ldl");
        if (obj == null) {
            return new zzom("");
        }
        zzoa<?> zzq = zzoo.zzq(obj);
        if (!(zzq instanceof zzom)) {
            return new zzom("");
        }
        String str = (String) ((zzom) zzq).value();
        if (!zzeu.zze(str, "conv").equals(zzha.zzd(zzoaArr[0]))) {
            return new zzom("");
        }
        String str2 = null;
        if (zzoaArr.length > 1 && (zzog2 = zzoaArr[1]) != zzog) {
            str2 = zzha.zzd(zzog2);
        }
        String zze = zzeu.zze(str, str2);
        if (zze != null) {
            return new zzom(zze);
        }
        return new zzom("");
    }
}
