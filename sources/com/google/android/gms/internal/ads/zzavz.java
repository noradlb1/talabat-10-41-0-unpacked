package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzavz {
    private final zzavt[] zza = new zzavt[1];
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzavt[] zze = new zzavt[100];

    public zzavz(boolean z11, int i11) {
    }

    public final synchronized int zza() {
        return this.zzc * 65536;
    }

    public final synchronized zzavt zzb() {
        zzavt zzavt;
        this.zzc++;
        int i11 = this.zzd;
        if (i11 > 0) {
            zzavt[] zzavtArr = this.zze;
            int i12 = i11 - 1;
            this.zzd = i12;
            zzavt = zzavtArr[i12];
            zzavtArr[i12] = null;
        } else {
            zzavt = new zzavt(new byte[65536], 0);
        }
        return zzavt;
    }

    public final synchronized void zzc(zzavt zzavt) {
        zzavt[] zzavtArr = this.zza;
        zzavtArr[0] = zzavt;
        zzd(zzavtArr);
    }

    public final synchronized void zzd(zzavt[] zzavtArr) {
        int i11 = this.zzd;
        int i12 = i11 + r1;
        zzavt[] zzavtArr2 = this.zze;
        int length = zzavtArr2.length;
        if (i12 >= length) {
            this.zze = (zzavt[]) Arrays.copyOf(zzavtArr2, Math.max(length + length, i12));
        }
        for (zzavt zzavt : zzavtArr) {
            byte[] bArr = zzavt.zza;
            zzavt[] zzavtArr3 = this.zze;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            zzavtArr3[i13] = zzavt;
        }
        this.zzc -= zzavtArr.length;
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
        int max = Math.max(0, zzaxb.zzd(this.zzb, 65536) - this.zzc);
        int i11 = this.zzd;
        if (max < i11) {
            Arrays.fill(this.zze, max, i11, (Object) null);
            this.zzd = max;
        }
    }
}
