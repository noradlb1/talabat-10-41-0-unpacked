package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zzaxi {
    public final List<byte[]> zza;
    public final int zzb;

    private zzaxi(List<byte[]> list, int i11) {
        this.zza = list;
        this.zzb = i11;
    }

    public static zzaxi zza(zzawu zzawu) throws zzapj {
        List list;
        try {
            zzawu.zzw(21);
            int zzg = zzawu.zzg() & 3;
            int zzg2 = zzawu.zzg();
            int zzc = zzawu.zzc();
            int i11 = 0;
            for (int i12 = 0; i12 < zzg2; i12++) {
                zzawu.zzw(1);
                int zzj = zzawu.zzj();
                for (int i13 = 0; i13 < zzj; i13++) {
                    int zzj2 = zzawu.zzj();
                    i11 += zzj2 + 4;
                    zzawu.zzw(zzj2);
                }
            }
            zzawu.zzv(zzc);
            byte[] bArr = new byte[i11];
            int i14 = 0;
            for (int i15 = 0; i15 < zzg2; i15++) {
                zzawu.zzw(1);
                int zzj3 = zzawu.zzj();
                for (int i16 = 0; i16 < zzj3; i16++) {
                    int zzj4 = zzawu.zzj();
                    System.arraycopy(zzaws.zza, 0, bArr, i14, 4);
                    int i17 = i14 + 4;
                    System.arraycopy(zzawu.zza, zzawu.zzc(), bArr, i17, zzj4);
                    i14 = i17 + zzj4;
                    zzawu.zzw(zzj4);
                }
            }
            if (i11 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzaxi(list, zzg + 1);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new zzapj("Error parsing HEVC config", e11);
        }
    }
}
