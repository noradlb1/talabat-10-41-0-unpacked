package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

public final class zzxa {
    @Nullable
    public static zzdd zza(zzwq zzwq, boolean z11) throws IOException {
        zzzr zzzr;
        if (z11) {
            zzzr = null;
        } else {
            zzzr = zzzt.zza;
        }
        zzdd zza = new zzxh().zza(zzwq, zzzr);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zzxc zzb(zzfd zzfd) {
        zzfd.zzG(1);
        int zzm = zzfd.zzm();
        long zzc = ((long) zzfd.zzc()) + ((long) zzm);
        int i11 = zzm / 18;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            long zzr = zzfd.zzr();
            if (zzr == -1) {
                jArr = Arrays.copyOf(jArr, i12);
                jArr2 = Arrays.copyOf(jArr2, i12);
                break;
            }
            jArr[i12] = zzr;
            jArr2[i12] = zzfd.zzr();
            zzfd.zzG(2);
            i12++;
        }
        zzfd.zzG((int) (zzc - ((long) zzfd.zzc())));
        return new zzxc(jArr, jArr2);
    }
}
