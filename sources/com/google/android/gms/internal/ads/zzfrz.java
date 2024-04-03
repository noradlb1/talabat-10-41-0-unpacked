package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzfrz extends zzfrn {
    final /* synthetic */ zzfsb zza;
    private final Object zzb;
    private int zzc;

    public zzfrz(zzfsb zzfsb, int i11) {
        this.zza = zzfsb;
        this.zzb = zzfsb.zzg(zzfsb, i11);
        this.zzc = i11;
    }

    private final void zza() {
        int i11 = this.zzc;
        if (i11 == -1 || i11 >= this.zza.size() || !zzfqc.zza(this.zzb, zzfsb.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i11 = this.zzc;
        if (i11 == -1) {
            return null;
        }
        return zzfsb.zzj(this.zza, i11);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i11 = this.zzc;
        if (i11 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object zzj = zzfsb.zzj(this.zza, i11);
        zzfsb.zzn(this.zza, this.zzc, obj);
        return zzj;
    }
}
