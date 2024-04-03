package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zztk {
    private final zzsx[] zza = new zzsx[1];
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzsx[] zze = new zzsx[100];

    public zztk(boolean z11, int i11) {
    }

    public final synchronized int zza() {
        return this.zzc * 65536;
    }

    public final synchronized zzsx zzb() {
        zzsx zzsx;
        this.zzc++;
        int i11 = this.zzd;
        if (i11 > 0) {
            zzsx[] zzsxArr = this.zze;
            int i12 = i11 - 1;
            this.zzd = i12;
            zzsx = zzsxArr[i12];
            zzsx.getClass();
            zzsxArr[i12] = null;
        } else {
            zzsx = new zzsx(new byte[65536], 0);
        }
        return zzsx;
    }

    public final synchronized void zzc(zzsx zzsx) {
        zzsx[] zzsxArr = this.zza;
        zzsxArr[0] = zzsx;
        zzd(zzsxArr);
    }

    public final synchronized void zzd(zzsx[] zzsxArr) {
        int i11 = this.zzd;
        int i12 = i11 + r1;
        zzsx[] zzsxArr2 = this.zze;
        int length = zzsxArr2.length;
        if (i12 >= length) {
            this.zze = (zzsx[]) Arrays.copyOf(zzsxArr2, Math.max(length + length, i12));
        }
        for (zzsx zzsx : zzsxArr) {
            zzsx[] zzsxArr3 = this.zze;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            zzsxArr3[i13] = zzsx;
        }
        this.zzc -= zzsxArr.length;
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i11) {
        int i12 = this.zzb;
        this.zzb = i11;
        if (i11 < i12) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int max = Math.max(0, zzfn.zze(this.zzb, 65536) - this.zzc);
        int i11 = this.zzd;
        if (max < i11) {
            Arrays.fill(this.zze, max, i11, (Object) null);
            this.zzd = max;
        }
    }
}
