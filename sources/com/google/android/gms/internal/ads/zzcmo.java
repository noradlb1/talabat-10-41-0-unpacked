package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzcmo implements zzavw {
    private final zzavw zza;
    private final long zzb;
    private final zzavw zzc;
    private long zzd;
    private Uri zze;

    public zzcmo(zzavw zzavw, int i11, zzavw zzavw2) {
        this.zza = zzavw;
        this.zzb = (long) i11;
        this.zzc = zzavw2;
    }

    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        long j11 = this.zzd;
        long j12 = this.zzb;
        if (j11 < j12) {
            int zza2 = this.zza.zza(bArr, i11, (int) Math.min((long) i12, j12 - j11));
            long j13 = this.zzd + ((long) zza2);
            this.zzd = j13;
            i13 = zza2;
            j11 = j13;
        } else {
            i13 = 0;
        }
        if (j11 < this.zzb) {
            return i13;
        }
        int zza3 = this.zzc.zza(bArr, i11 + i13, i12 - i13);
        this.zzd += (long) zza3;
        return i13 + zza3;
    }

    public final long zzb(zzavy zzavy) throws IOException {
        zzavy zzavy2;
        long j11;
        long j12;
        long j13;
        zzavy zzavy3 = zzavy;
        this.zze = zzavy3.zza;
        long j14 = zzavy3.zzc;
        long j15 = this.zzb;
        zzavy zzavy4 = null;
        if (j14 >= j15) {
            zzavy2 = null;
        } else {
            long j16 = zzavy3.zzd;
            if (j16 != -1) {
                j13 = Math.min(j16, j15 - j14);
            } else {
                j13 = j15 - j14;
            }
            zzavy2 = new zzavy(zzavy3.zza, (byte[]) null, j14, j14, j13, (String) null, 0);
        }
        long j17 = zzavy3.zzd;
        if (j17 == -1 || zzavy3.zzc + j17 > this.zzb) {
            long max = Math.max(this.zzb, zzavy3.zzc);
            long j18 = zzavy3.zzd;
            if (j18 != -1) {
                j12 = Math.min(j18, (zzavy3.zzc + j18) - this.zzb);
            } else {
                j12 = -1;
            }
            zzavy4 = new zzavy(zzavy3.zza, (byte[]) null, max, max, j12, (String) null, 0);
        }
        long j19 = 0;
        if (zzavy2 != null) {
            j11 = this.zza.zzb(zzavy2);
        } else {
            j11 = 0;
        }
        if (zzavy4 != null) {
            j19 = this.zzc.zzb(zzavy4);
        }
        this.zzd = zzavy3.zzc;
        if (j19 == -1) {
            return -1;
        }
        return j11 + j19;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }
}
