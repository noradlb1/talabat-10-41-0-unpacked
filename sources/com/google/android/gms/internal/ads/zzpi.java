package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

final class zzpi implements zzqj, zznf {
    final /* synthetic */ zzpk zza;
    private final Object zzb;
    private zzqi zzc;
    private zzne zzd;

    public zzpi(zzpk zzpk, Object obj) {
        this.zza = zzpk;
        this.zzc = zzpk.zzd((zzpz) null);
        this.zzd = zzpk.zzb((zzpz) null);
        this.zzb = obj;
    }

    private final boolean zzf(int i11, @Nullable zzpz zzpz) {
        zzpz zzpz2;
        if (zzpz != null) {
            zzpz2 = this.zza.zzu(this.zzb, zzpz);
            if (zzpz2 == null) {
                return false;
            }
        } else {
            zzpz2 = null;
        }
        zzqi zzqi = this.zzc;
        if (zzqi.zza != i11 || !zzfn.zzP(zzqi.zzb, zzpz2)) {
            this.zzc = this.zza.zze(i11, zzpz2, 0);
        }
        zzne zzne = this.zzd;
        if (zzne.zza == i11 && zzfn.zzP(zzne.zzb, zzpz2)) {
            return true;
        }
        this.zzd = this.zza.zzc(i11, zzpz2);
        return true;
    }

    public final void zzbe(int i11, @Nullable zzpz zzpz, zzpw zzpw) {
        if (zzf(i11, zzpz)) {
            this.zzc.zzc(zzpw);
        }
    }

    public final void zzbf(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        if (zzf(i11, zzpz)) {
            this.zzc.zze(zzpr, zzpw);
        }
    }

    public final void zzbg(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        if (zzf(i11, zzpz)) {
            this.zzc.zzg(zzpr, zzpw);
        }
    }

    public final void zzd(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw, IOException iOException, boolean z11) {
        if (zzf(i11, zzpz)) {
            this.zzc.zzi(zzpr, zzpw, iOException, z11);
        }
    }

    public final void zze(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        if (zzf(i11, zzpz)) {
            this.zzc.zzk(zzpr, zzpw);
        }
    }
}
