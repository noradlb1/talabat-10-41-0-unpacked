package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzlc {
    public final long zza;
    public final zzcd zzb;
    public final int zzc;
    @Nullable
    public final zzpz zzd;
    public final long zze;
    public final zzcd zzf;
    public final int zzg;
    @Nullable
    public final zzpz zzh;
    public final long zzi;
    public final long zzj;

    public zzlc(long j11, zzcd zzcd, int i11, @Nullable zzpz zzpz, long j12, zzcd zzcd2, int i12, @Nullable zzpz zzpz2, long j13, long j14) {
        this.zza = j11;
        this.zzb = zzcd;
        this.zzc = i11;
        this.zzd = zzpz;
        this.zze = j12;
        this.zzf = zzcd2;
        this.zzg = i12;
        this.zzh = zzpz2;
        this.zzi = j13;
        this.zzj = j14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlc.class == obj.getClass()) {
            zzlc zzlc = (zzlc) obj;
            if (this.zza == zzlc.zza && this.zzc == zzlc.zzc && this.zze == zzlc.zze && this.zzg == zzlc.zzg && this.zzi == zzlc.zzi && this.zzj == zzlc.zzj && zzfqc.zza(this.zzb, zzlc.zzb) && zzfqc.zza(this.zzd, zzlc.zzd) && zzfqc.zza(this.zzf, zzlc.zzf) && zzfqc.zza(this.zzh, zzlc.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
