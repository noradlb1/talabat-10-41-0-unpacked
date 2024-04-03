package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzpt extends zzpo {
    public static final Object zzd = new Object();
    @Nullable
    private final Object zze;
    /* access modifiers changed from: private */
    @Nullable
    public final Object zzf;

    private zzpt(zzcd zzcd, @Nullable Object obj, @Nullable Object obj2) {
        super(zzcd);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzpt zzq(zzaz zzaz) {
        return new zzpt(new zzpu(zzaz), zzcc.zza, zzd);
    }

    public static zzpt zzr(zzcd zzcd, @Nullable Object obj, @Nullable Object obj2) {
        return new zzpt(zzcd, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        zzcd zzcd = this.zzc;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return zzcd.zza(obj);
    }

    public final zzca zzd(int i11, zzca zzca, boolean z11) {
        this.zzc.zzd(i11, zzca, z11);
        if (zzfn.zzP(zzca.zzc, this.zzf) && z11) {
            zzca.zzc = zzd;
        }
        return zzca;
    }

    public final zzcc zze(int i11, zzcc zzcc, long j11) {
        this.zzc.zze(i11, zzcc, j11);
        if (zzfn.zzP(zzcc.zzc, this.zze)) {
            zzcc.zzc = zzcc.zza;
        }
        return zzcc;
    }

    public final Object zzf(int i11) {
        Object zzf2 = this.zzc.zzf(i11);
        if (zzfn.zzP(zzf2, this.zzf)) {
            return zzd;
        }
        return zzf2;
    }

    public final zzpt zzp(zzcd zzcd) {
        return new zzpt(zzcd, this.zze, this.zzf);
    }
}
