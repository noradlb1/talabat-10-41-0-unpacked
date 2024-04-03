package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;

final class zzia implements zzqj, zznf {
    final /* synthetic */ zzie zza;
    private final zzic zzb;
    private zzqi zzc;
    private zzne zzd;

    public zzia(zzie zzie, zzic zzic) {
        this.zza = zzie;
        this.zzc = zzie.zze;
        this.zzd = zzie.zzf;
        this.zzb = zzic;
    }

    private final boolean zzf(int i11, @Nullable zzpz zzpz) {
        zzpz zzpz2 = null;
        if (zzpz != null) {
            zzic zzic = this.zzb;
            int i12 = 0;
            while (true) {
                if (i12 >= zzic.zzc.size()) {
                    break;
                } else if (zzic.zzc.get(i12).zzd == zzpz.zzd) {
                    zzpz2 = zzpz.zzc(Pair.create(zzic.zzb, zzpz.zza));
                    break;
                } else {
                    i12++;
                }
            }
            if (zzpz2 == null) {
                return false;
            }
        }
        int i13 = i11 + this.zzb.zzd;
        zzqi zzqi = this.zzc;
        if (zzqi.zza != i13 || !zzfn.zzP(zzqi.zzb, zzpz2)) {
            this.zzc = this.zza.zze.zza(i13, zzpz2, 0);
        }
        zzne zzne = this.zzd;
        if (zzne.zza == i13 && zzfn.zzP(zzne.zzb, zzpz2)) {
            return true;
        }
        this.zzd = this.zza.zzf.zza(i13, zzpz2);
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
