package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzsn implements Comparable<zzsn> {
    public final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final boolean zzi;

    public zzsn(zzab zzab, zzsi zzsi, int i11, @Nullable String str) {
        boolean z11;
        boolean z12;
        zzfss<String> zzfss;
        int i12;
        boolean z13;
        boolean z14 = false;
        this.zzb = zzsp.zzh(i11, false);
        int i13 = zzab.zze;
        int i14 = zzsi.zzE;
        if (1 != (i13 & 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.zzc = z11;
        if ((i13 & 2) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.zzd = z12;
        if (zzsi.zzu.isEmpty()) {
            zzfss = zzfss.zzp("");
        } else {
            zzfss = zzsi.zzu;
        }
        int i15 = 0;
        while (true) {
            if (i15 >= zzfss.size()) {
                i15 = Integer.MAX_VALUE;
                i12 = 0;
                break;
            }
            i12 = zzsp.zza(zzab, zzfss.get(i15), false);
            if (i12 > 0) {
                break;
            }
            i15++;
        }
        this.zze = i15;
        this.zzf = i12;
        int bitCount = Integer.bitCount(0);
        this.zzg = bitCount;
        this.zzi = false;
        if (zzsp.zzf(str) == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        int zza2 = zzsp.zza(zzab, str, z13);
        this.zzh = zza2;
        if (i12 > 0 || ((zzsi.zzu.isEmpty() && bitCount > 0) || this.zzc || (this.zzd && zza2 > 0))) {
            z14 = true;
        }
        this.zza = z14;
    }

    /* renamed from: zza */
    public final int compareTo(zzsn zzsn) {
        zzfuf zzfuf;
        zzfsh zzd2 = zzfsh.zzj().zzd(this.zzb, zzsn.zzb).zzc(Integer.valueOf(this.zze), Integer.valueOf(zzsn.zze), zzfuf.zzc().zza()).zzb(this.zzf, zzsn.zzf).zzb(this.zzg, zzsn.zzg).zzd(this.zzc, zzsn.zzc);
        Boolean valueOf = Boolean.valueOf(this.zzd);
        Boolean valueOf2 = Boolean.valueOf(zzsn.zzd);
        if (this.zzf == 0) {
            zzfuf = zzfuf.zzc();
        } else {
            zzfuf = zzfuf.zzc().zza();
        }
        zzfsh zzb2 = zzd2.zzc(valueOf, valueOf2, zzfuf).zzb(this.zzh, zzsn.zzh);
        if (this.zzg == 0) {
            zzb2 = zzb2.zze(false, false);
        }
        return zzb2.zza();
    }
}
