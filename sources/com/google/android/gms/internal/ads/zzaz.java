package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzaz {
    public static final zzaz zza = new zzaf().zzc();
    public static final zzj<zzaz> zzb = zzad.zza;
    public final String zzc;
    @Nullable
    public final zzau zzd;
    @Deprecated
    @Nullable
    public final zzaw zze;
    public final zzas zzf;
    public final zzbe zzg;
    public final zzaj zzh;
    @Deprecated
    public final zzal zzi;

    public /* synthetic */ zzaz(String str, zzal zzal, zzaw zzaw, zzas zzas, zzbe zzbe, zzay zzay) {
        this.zzc = str;
        this.zzd = zzaw;
        this.zze = zzaw;
        this.zzf = zzas;
        this.zzg = zzbe;
        this.zzh = zzal;
        this.zzi = zzal;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaz)) {
            return false;
        }
        zzaz zzaz = (zzaz) obj;
        if (!zzfn.zzP(this.zzc, zzaz.zzc) || !this.zzh.equals(zzaz.zzh) || !zzfn.zzP(this.zzd, zzaz.zzd) || !zzfn.zzP(this.zzf, zzaz.zzf) || !zzfn.zzP(this.zzg, zzaz.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.zzc.hashCode() * 31;
        zzau zzau = this.zzd;
        if (zzau != null) {
            i11 = zzau.hashCode();
        } else {
            i11 = 0;
        }
        return ((((((hashCode + i11) * 31) + this.zzf.hashCode()) * 31) + this.zzh.hashCode()) * 31) + this.zzg.hashCode();
    }
}
