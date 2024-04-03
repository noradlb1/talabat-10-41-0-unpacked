package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

public final class zztf extends zzdf {
    private final byte[] zza;
    @Nullable
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zztf(byte[] bArr) {
        super(false);
        boolean z11 = false;
        bArr.getClass();
        zzdy.zzd(bArr.length > 0 ? true : z11);
        this.zza = bArr;
    }

    public final int zzg(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.zzd;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(this.zza, this.zzc, bArr, i11, min);
        this.zzc += min;
        this.zzd -= min;
        zzc(min);
        return min;
    }

    public final long zzh(zzdm zzdm) throws IOException {
        this.zzb = zzdm.zza;
        zze(zzdm);
        long j11 = zzdm.zzf;
        int length = this.zza.length;
        if (j11 <= ((long) length)) {
            int i11 = (int) j11;
            this.zzc = i11;
            int i12 = length - i11;
            this.zzd = i12;
            long j12 = zzdm.zzg;
            if (j12 != -1) {
                this.zzd = (int) Math.min((long) i12, j12);
            }
            this.zze = true;
            zzf(zzdm);
            long j13 = zzdm.zzg;
            if (j13 != -1) {
                return j13;
            }
            return (long) this.zzd;
        }
        throw new zzdj(2008);
    }

    @Nullable
    public final Uri zzi() {
        return this.zzb;
    }

    public final void zzj() {
        if (this.zze) {
            this.zze = false;
            zzd();
        }
        this.zzb = null;
    }
}
