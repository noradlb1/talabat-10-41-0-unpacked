package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public abstract class zzdf implements zzdi {
    private final boolean zza;
    private final ArrayList<zzdx> zzb = new ArrayList<>(1);
    private int zzc;
    @Nullable
    private zzdm zzd;

    public zzdf(boolean z11) {
        this.zza = z11;
    }

    public /* synthetic */ Map zza() {
        return Collections.emptyMap();
    }

    public final void zzb(zzdx zzdx) {
        zzdx.getClass();
        if (!this.zzb.contains(zzdx)) {
            this.zzb.add(zzdx);
            this.zzc++;
        }
    }

    public final void zzc(int i11) {
        zzdm zzdm = this.zzd;
        int i12 = zzfn.zza;
        for (int i13 = 0; i13 < this.zzc; i13++) {
            this.zzb.get(i13).zza(this, zzdm, this.zza, i11);
        }
    }

    public final void zzd() {
        zzdm zzdm = this.zzd;
        int i11 = zzfn.zza;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            this.zzb.get(i12).zzb(this, zzdm, this.zza);
        }
        this.zzd = null;
    }

    public final void zze(zzdm zzdm) {
        for (int i11 = 0; i11 < this.zzc; i11++) {
            this.zzb.get(i11).zzc(this, zzdm, this.zza);
        }
    }

    public final void zzf(zzdm zzdm) {
        this.zzd = zzdm;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            this.zzb.get(i11).zzd(this, zzdm, this.zza);
        }
    }
}
