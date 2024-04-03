package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;

final class zzadz {
    private final zzxt zza;
    private final SparseArray<zzet> zzb = new SparseArray<>();
    private final SparseArray<zzes> zzc = new SparseArray<>();
    private final zzfe zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private final zzady zzi = new zzady((zzadx) null);
    private final zzady zzj = new zzady((zzadx) null);
    private boolean zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;

    public zzadz(zzxt zzxt, boolean z11, boolean z12) {
        this.zza = zzxt;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzfe(bArr, 0, 0);
        this.zzk = false;
    }

    public final void zza(zzes zzes) {
        this.zzc.append(zzes.zza, zzes);
    }

    public final void zzb(zzet zzet) {
        this.zzb.append(zzet.zzd, zzet);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j11, int i11, long j12) {
        this.zzf = i11;
        this.zzh = j12;
        this.zzg = j11;
    }

    public final boolean zze(long j11, int i11, boolean z11, boolean z12) {
        boolean z13 = false;
        if (this.zzf == 9) {
            if (z11 && this.zzk) {
                long j12 = this.zzg;
                int i12 = i11 + ((int) (j11 - j12));
                long j13 = this.zzm;
                if (j13 != C.TIME_UNSET) {
                    this.zza.zzs(j13, this.zzn ? 1 : 0, (int) (j12 - this.zzl), i12, (zzxs) null);
                }
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z14 = this.zzn;
        int i13 = this.zzf;
        if (i13 == 5 || (z12 && i13 == 1)) {
            z13 = true;
        }
        boolean z15 = z14 | z13;
        this.zzn = z15;
        return z15;
    }
}
