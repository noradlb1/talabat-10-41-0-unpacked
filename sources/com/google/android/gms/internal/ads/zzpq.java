package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzpq implements zzdi {
    private final zzdi zza;
    private final int zzb;
    private final zzpp zzc;
    private final byte[] zzd;
    private int zze;

    public zzpq(zzdi zzdi, int i11, zzpp zzpp) {
        zzdy.zzd(i11 > 0);
        this.zza = zzdi;
        this.zzb = i11;
        this.zzc = zzpp;
        this.zzd = new byte[1];
        this.zze = i11;
    }

    public final Map<String, List<String>> zza() {
        return this.zza.zza();
    }

    public final void zzb(zzdx zzdx) {
        zzdx.getClass();
        this.zza.zzb(zzdx);
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.zze;
        if (i13 == 0) {
            int i14 = 0;
            if (this.zza.zzg(this.zzd, 0, 1) != -1) {
                int i15 = (this.zzd[0] & 255) << 4;
                if (i15 != 0) {
                    byte[] bArr2 = new byte[i15];
                    int i16 = i15;
                    while (i16 > 0) {
                        int zzg = this.zza.zzg(bArr2, i14, i16);
                        if (zzg != -1) {
                            i14 += zzg;
                            i16 -= zzg;
                        }
                    }
                    while (i15 > 0) {
                        int i17 = i15 - 1;
                        if (bArr2[i17] != 0) {
                            break;
                        }
                        i15 = i17;
                    }
                    if (i15 > 0) {
                        this.zzc.zza(new zzfd(bArr2, i15));
                    }
                }
                i13 = this.zzb;
                this.zze = i13;
            }
            return -1;
        }
        int zzg2 = this.zza.zzg(bArr, i11, Math.min(i13, i12));
        if (zzg2 != -1) {
            this.zze -= zzg2;
        }
        return zzg2;
    }

    public final long zzh(zzdm zzdm) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public final Uri zzi() {
        return this.zza.zzi();
    }

    public final void zzj() {
        throw new UnsupportedOperationException();
    }
}
