package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;

final class zzafo {
    @Nullable
    public static zzafm zza(zzwq zzwq) throws IOException {
        boolean z11;
        byte[] bArr;
        zzfd zzfd = new zzfd(16);
        if (zzafn.zza(zzwq, zzfd).zza != 1380533830) {
            return null;
        }
        zzwk zzwk = (zzwk) zzwq;
        zzwk.zzm(zzfd.zzH(), 0, 4, false);
        zzfd.zzF(0);
        int zze = zzfd.zze();
        if (zze != 1463899717) {
            StringBuilder sb2 = new StringBuilder(36);
            sb2.append("Unsupported RIFF format: ");
            sb2.append(zze);
            Log.e("WavHeaderReader", sb2.toString());
            return null;
        }
        zzafn zza = zzafn.zza(zzwq, zzfd);
        while (zza.zza != 1718449184) {
            zzwk.zzl((int) zza.zzb, false);
            zza = zzafn.zza(zzwq, zzfd);
        }
        if (zza.zzb >= 16) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        zzwk.zzm(zzfd.zzH(), 0, 16, false);
        zzfd.zzF(0);
        int zzi = zzfd.zzi();
        int zzi2 = zzfd.zzi();
        int zzh = zzfd.zzh();
        int zzh2 = zzfd.zzh();
        int zzi3 = zzfd.zzi();
        int zzi4 = zzfd.zzi();
        int i11 = ((int) zza.zzb) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            zzwk.zzm(bArr2, 0, i11, false);
            bArr = bArr2;
        } else {
            bArr = zzfn.zzf;
        }
        return new zzafm(zzi, zzi2, zzh, zzh2, zzi3, zzi4, bArr);
    }
}
