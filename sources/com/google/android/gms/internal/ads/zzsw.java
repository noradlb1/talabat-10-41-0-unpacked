package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzsw {
    public final int zza;
    public final zzin[] zzb;
    public final zzcr zzc;
    @Nullable
    public final Object zzd;
    public final zzsb[] zze;

    public zzsw(zzin[] zzinArr, zzsb[] zzsbArr, zzcr zzcr, @Nullable Object obj, byte[] bArr) {
        this.zzb = zzinArr;
        this.zze = (zzsb[]) zzsbArr.clone();
        this.zzc = zzcr;
        this.zzd = obj;
        this.zza = zzinArr.length;
    }

    public final boolean zza(@Nullable zzsw zzsw, int i11) {
        if (zzsw != null && zzfn.zzP(this.zzb[i11], zzsw.zzb[i11]) && zzfn.zzP(this.zze[i11], zzsw.zze[i11])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i11) {
        return this.zzb[i11] != null;
    }
}
