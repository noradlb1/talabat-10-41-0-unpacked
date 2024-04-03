package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzdn implements zzdh {
    private final zzdu zza = new zzdu();
    @Nullable
    private zzdx zzb;
    @Nullable
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzdn zzb(boolean z11) {
        this.zzf = true;
        return this;
    }

    public final zzdn zzc(int i11) {
        this.zzd = i11;
        return this;
    }

    public final zzdn zzd(int i11) {
        this.zze = i11;
        return this;
    }

    public final zzdn zze(@Nullable zzdx zzdx) {
        this.zzb = zzdx;
        return this;
    }

    public final zzdn zzf(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzdp zza() {
        zzdp zzdp = new zzdp(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfqh) null, false, (zzdo) null);
        zzdx zzdx = this.zzb;
        if (zzdx != null) {
            zzdp.zzb(zzdx);
        }
        return zzdp;
    }
}
