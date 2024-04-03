package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;

@VisibleForTesting
public final class zzpu extends zzcd {
    private final zzaz zzc;

    public zzpu(zzaz zzaz) {
        this.zzc = zzaz;
    }

    public final int zza(Object obj) {
        return obj == zzpt.zzd ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzca zzd(int i11, zzca zzca, boolean z11) {
        Integer num;
        Object obj = null;
        if (z11) {
            num = 0;
        } else {
            num = null;
        }
        if (z11) {
            obj = zzpt.zzd;
        }
        zzca.zzj(num, obj, 0, C.TIME_UNSET, 0, zzd.zza, true);
        return zzca;
    }

    public final zzcc zze(int i11, zzcc zzcc, long j11) {
        zzcc zzcc2 = zzcc;
        zzcc.zza(zzcc.zza, this.zzc, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, (zzas) null, 0, C.TIME_UNSET, 0, 0, 0);
        zzcc zzcc3 = zzcc;
        zzcc3.zzl = true;
        return zzcc3;
    }

    public final Object zzf(int i11) {
        return zzpt.zzd;
    }
}
