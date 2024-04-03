package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

final class zzaeb {
    private final zzxt zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzaeb(zzxt zzxt) {
        this.zza = zzxt;
    }

    private final void zze(int i11) {
        long j11 = this.zzl;
        if (j11 != C.TIME_UNSET) {
            boolean z11 = this.zzm;
            long j12 = this.zzb;
            long j13 = this.zzk;
            this.zza.zzs(j11, z11 ? 1 : 0, (int) (j12 - j13), i11, (zzxs) null);
        }
    }

    public final void zza(long j11, int i11, boolean z11) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z11 && this.zzi) {
                zze(i11 + ((int) (j11 - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }

    public final void zzb(byte[] bArr, int i11, int i12) {
        if (this.zzf) {
            int i13 = this.zzd;
            int i14 = (i11 + 2) - i13;
            if (i14 < i12) {
                this.zzg = (bArr[i14] & 128) != 0;
                this.zzf = false;
                return;
            }
            this.zzd = i13 + (i12 - i11);
        }
    }

    public final void zzc() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzd(long j11, int i11, int i12, long j12, boolean z11) {
        boolean z12 = false;
        this.zzg = false;
        this.zzh = false;
        this.zze = j12;
        this.zzd = 0;
        this.zzb = j11;
        if (i12 >= 32 && i12 != 40) {
            if (this.zzi && !this.zzj) {
                if (z11) {
                    zze(i11);
                }
                this.zzi = false;
            }
            if (i12 <= 35 || i12 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z13 = i12 >= 16 && i12 <= 21;
        this.zzc = z13;
        if (z13 || i12 <= 9) {
            z12 = true;
        }
        this.zzf = z12;
    }
}
