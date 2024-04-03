package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

public final class zzxh {
    private final zzfd zza = new zzfd(10);

    @Nullable
    public final zzdd zza(zzwq zzwq, @Nullable zzzr zzzr) throws IOException {
        zzdd zzdd = null;
        int i11 = 0;
        while (true) {
            try {
                ((zzwk) zzwq).zzm(this.zza.zzH(), 0, 10, false);
                this.zza.zzF(0);
                if (this.zza.zzm() != 4801587) {
                    break;
                }
                this.zza.zzG(3);
                int zzj = this.zza.zzj();
                int i12 = zzj + 10;
                if (zzdd == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.zza.zzH(), 0, bArr, 0, 10);
                    ((zzwk) zzwq).zzm(bArr, 10, zzj, false);
                    zzdd = zzzt.zza(bArr, i12, zzzr, new zzde());
                } else {
                    ((zzwk) zzwq).zzl(zzj, false);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        zzwq.zzj();
        ((zzwk) zzwq).zzl(i11, false);
        return zzdd;
    }
}
