package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzse implements Comparable<zzse> {
    public final boolean zza;
    @Nullable
    private final String zzb;
    private final zzsi zzc;
    private final boolean zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final boolean zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;

    public zzse(zzab zzab, zzsi zzsi, int i11) {
        int i12;
        int i13;
        boolean z11;
        int i14;
        this.zzc = zzsi;
        this.zzb = zzsp.zzf(zzab.zzd);
        int i15 = 0;
        this.zzd = zzsp.zzh(i11, false);
        int i16 = 0;
        while (true) {
            i12 = Integer.MAX_VALUE;
            if (i16 >= zzsi.zzp.size()) {
                i13 = 0;
                i16 = Integer.MAX_VALUE;
                break;
            }
            i13 = zzsp.zza(zzab, zzsi.zzp.get(i16), false);
            if (i13 > 0) {
                break;
            }
            i16++;
        }
        this.zzf = i16;
        this.zze = i13;
        this.zzg = Integer.bitCount(0);
        if (1 != (zzab.zze & 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.zzj = z11;
        this.zzk = zzab.zzz;
        this.zzl = zzab.zzA;
        this.zzm = zzab.zzi;
        this.zza = true;
        String[] zzab2 = zzfn.zzab();
        int i17 = 0;
        while (true) {
            if (i17 >= zzab2.length) {
                i14 = 0;
                i17 = Integer.MAX_VALUE;
                break;
            }
            i14 = zzsp.zza(zzab, zzab2[i17], false);
            if (i14 > 0) {
                break;
            }
            i17++;
        }
        this.zzh = i17;
        this.zzi = i14;
        while (true) {
            if (i15 < zzsi.zzt.size()) {
                String str = zzab.zzm;
                if (str != null && str.equals(zzsi.zzt.get(i15))) {
                    i12 = i15;
                    break;
                }
                i15++;
            } else {
                break;
            }
        }
        this.zzn = i12;
    }

    /* renamed from: zza */
    public final int compareTo(zzse zzse) {
        zzfuf zzfuf;
        if (this.zzd) {
            zzfuf = zzsp.zzb;
        } else {
            zzfuf = zzsp.zzb.zza();
        }
        zzfsh zzc2 = zzfsh.zzj().zzd(this.zzd, zzse.zzd).zzc(Integer.valueOf(this.zzf), Integer.valueOf(zzse.zzf), zzfuf.zzc().zza()).zzb(this.zze, zzse.zze).zzb(this.zzg, zzse.zzg).zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzse.zzn), zzfuf.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzm);
        Integer valueOf2 = Integer.valueOf(zzse.zzm);
        boolean z11 = this.zzc.zzx;
        zzfsh zzc3 = zzc2.zzc(valueOf, valueOf2, zzsp.zzc).zzd(this.zzj, zzse.zzj).zzc(Integer.valueOf(this.zzh), Integer.valueOf(zzse.zzh), zzfuf.zzc().zza()).zzb(this.zzi, zzse.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzse.zzk), zzfuf).zzc(Integer.valueOf(this.zzl), Integer.valueOf(zzse.zzl), zzfuf);
        Integer valueOf3 = Integer.valueOf(this.zzm);
        Integer valueOf4 = Integer.valueOf(zzse.zzm);
        if (!zzfn.zzP(this.zzb, zzse.zzb)) {
            zzfuf = zzsp.zzc;
        }
        return zzc3.zzc(valueOf3, valueOf4, zzfuf).zza();
    }
}
