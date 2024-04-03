package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzcc {
    public static final Object zza = new Object();
    public static final zzj<zzcc> zzb = zzcb.zza;
    private static final Object zzq = new Object();
    private static final zzaz zzr;
    public Object zzc = zza;
    public zzaz zzd = zzr;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    @Deprecated
    public boolean zzj;
    @Nullable
    public zzas zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public int zzo;
    public int zzp;

    static {
        zzaf zzaf = new zzaf();
        zzaf.zza("androidx.media3.common.Timeline");
        zzaf.zzb(Uri.EMPTY);
        zzr = zzaf.zzc();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcc.class.equals(obj.getClass())) {
            zzcc zzcc = (zzcc) obj;
            if (zzfn.zzP(this.zzc, zzcc.zzc) && zzfn.zzP(this.zzd, zzcc.zzd) && zzfn.zzP((Object) null, (Object) null) && zzfn.zzP(this.zzk, zzcc.zzk) && this.zze == zzcc.zze && this.zzf == zzcc.zzf && this.zzg == zzcc.zzg && this.zzh == zzcc.zzh && this.zzi == zzcc.zzi && this.zzl == zzcc.zzl && this.zzn == zzcc.zzn && this.zzo == zzcc.zzo && this.zzp == zzcc.zzp) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (((this.zzc.hashCode() + 217) * 31) + this.zzd.hashCode()) * 961;
        zzas zzas = this.zzk;
        if (zzas == null) {
            i11 = 0;
        } else {
            i11 = zzas.hashCode();
        }
        long j11 = this.zze;
        long j12 = this.zzf;
        long j13 = this.zzg;
        boolean z11 = this.zzh;
        boolean z12 = this.zzi;
        boolean z13 = this.zzl;
        long j14 = this.zzn;
        return (((((((((((((((((((hashCode + i11) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) ((j12 >>> 32) ^ j12))) * 31) + ((int) ((j13 >>> 32) ^ j13))) * 31) + (z11 ? 1 : 0)) * 31) + (z12 ? 1 : 0)) * 31) + (z13 ? 1 : 0)) * 961) + ((int) ((j14 >>> 32) ^ j14))) * 31) + this.zzo) * 31) + this.zzp) * 31;
    }

    public final zzcc zza(Object obj, @Nullable zzaz zzaz, @Nullable Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, @Nullable zzas zzas, long j14, long j15, int i11, int i12, long j16) {
        zzas zzas2 = zzas;
        this.zzc = obj;
        this.zzd = zzaz != null ? zzaz : zzr;
        this.zze = C.TIME_UNSET;
        this.zzf = C.TIME_UNSET;
        this.zzg = C.TIME_UNSET;
        this.zzh = z11;
        this.zzi = z12;
        this.zzj = zzas2 != null;
        this.zzk = zzas2;
        this.zzm = 0;
        this.zzn = j15;
        this.zzo = 0;
        this.zzp = 0;
        this.zzl = false;
        return this;
    }

    public final boolean zzb() {
        zzdy.zzf(this.zzj == (this.zzk != null));
        return this.zzk != null;
    }
}
