package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzcnu implements zzdi {
    private final zzdi zza;
    private final long zzb;
    private final zzdi zzc;
    private long zzd;
    private Uri zze;

    public zzcnu(zzdi zzdi, int i11, zzdi zzdi2) {
        this.zza = zzdi;
        this.zzb = (long) i11;
        this.zzc = zzdi2;
    }

    public final Map<String, List<String>> zza() {
        return zzfsw.zzd();
    }

    public final void zzb(zzdx zzdx) {
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        long j11 = this.zzd;
        long j12 = this.zzb;
        if (j11 < j12) {
            int zzg = this.zza.zzg(bArr, i11, (int) Math.min((long) i12, j12 - j11));
            long j13 = this.zzd + ((long) zzg);
            this.zzd = j13;
            i13 = zzg;
            j11 = j13;
        } else {
            i13 = 0;
        }
        if (j11 < this.zzb) {
            return i13;
        }
        int zzg2 = this.zzc.zzg(bArr, i11 + i13, i12 - i13);
        this.zzd += (long) zzg2;
        return i13 + zzg2;
    }

    public final long zzh(zzdm zzdm) throws IOException {
        zzdm zzdm2;
        long j11;
        long j12;
        long j13;
        zzdm zzdm3 = zzdm;
        this.zze = zzdm3.zza;
        long j14 = zzdm3.zzf;
        long j15 = this.zzb;
        zzdm zzdm4 = null;
        if (j14 >= j15) {
            zzdm2 = null;
        } else {
            long j16 = zzdm3.zzg;
            if (j16 != -1) {
                j13 = Math.min(j16, j15 - j14);
            } else {
                j13 = j15 - j14;
            }
            zzdm2 = new zzdm(zzdm3.zza, (byte[]) null, j14, j14, j13, (String) null, 0);
        }
        long j17 = zzdm3.zzg;
        if (j17 == -1 || zzdm3.zzf + j17 > this.zzb) {
            long max = Math.max(this.zzb, zzdm3.zzf);
            long j18 = zzdm3.zzg;
            if (j18 != -1) {
                j12 = Math.min(j18, (zzdm3.zzf + j18) - this.zzb);
            } else {
                j12 = -1;
            }
            zzdm4 = new zzdm(zzdm3.zza, (byte[]) null, max, max, j12, (String) null, 0);
        }
        long j19 = 0;
        if (zzdm2 != null) {
            j11 = this.zza.zzh(zzdm2);
        } else {
            j11 = 0;
        }
        if (zzdm4 != null) {
            j19 = this.zzc.zzh(zzdm4);
        }
        this.zzd = zzdm3.zzf;
        if (j11 == -1 || j19 == -1) {
            return -1;
        }
        return j11 + j19;
    }

    public final Uri zzi() {
        return this.zze;
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
        this.zzc.zzj();
    }
}
