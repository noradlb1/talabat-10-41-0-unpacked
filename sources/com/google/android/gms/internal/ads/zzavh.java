package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zzavh {
    protected final zzavc zza;
    protected final int[] zzb;
    private final zzapg[] zzc = new zzapg[1];
    private int zzd;

    public zzavh(zzavc zzavc, int... iArr) {
        zzavc.getClass();
        this.zza = zzavc;
        for (int i11 = 0; i11 <= 0; i11++) {
            this.zzc[i11] = zzavc.zzb(iArr[i11]);
        }
        Arrays.sort(this.zzc, new zzavg((zzavf) null));
        this.zzb = new int[1];
        for (int i12 = 0; i12 <= 0; i12++) {
            this.zzb[i12] = zzavc.zza(this.zzc[i12]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzavh zzavh = (zzavh) obj;
            if (this.zza != zzavh.zza || !Arrays.equals(this.zzb, zzavh.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzb);
        this.zzd = identityHashCode;
        return identityHashCode;
    }

    public final int zza(int i11) {
        return this.zzb[0];
    }

    public final int zzb() {
        int length = this.zzb.length;
        return 1;
    }

    public final zzapg zzc(int i11) {
        return this.zzc[i11];
    }

    public final zzavc zzd() {
        return this.zza;
    }
}
