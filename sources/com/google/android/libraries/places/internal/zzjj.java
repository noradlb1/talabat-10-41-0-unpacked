package com.google.android.libraries.places.internal;

import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

final class zzjj {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    /* access modifiers changed from: private */
    public final char[] zzf;
    private final byte[] zzg;

    public zzjj(String str, char[] cArr) {
        String str2;
        boolean z11;
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb2 = zzze.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb2;
            int min = Math.min(8, Integer.lowestOneBit(zzb2));
            try {
                this.zzc = 8 / min;
                this.zzd = zzb2 / min;
                this.zza = length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                int i11 = 0;
                while (true) {
                    boolean z12 = true;
                    if (i11 >= cArr.length) {
                        break;
                    }
                    char c11 = cArr[i11];
                    if (c11 < 128) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzfm.zzf(z11, "Non-ASCII character: %s", c11);
                    if (bArr[c11] != -1) {
                        z12 = false;
                    }
                    zzfm.zzf(z12, "Duplicate character: %s", c11);
                    bArr[c11] = (byte) i11;
                    i11++;
                }
                this.zzg = bArr;
                boolean[] zArr = new boolean[this.zzc];
                for (int i12 = 0; i12 < this.zzd; i12++) {
                    zArr[zzze.zza(i12 * 8, this.zzb, RoundingMode.CEILING)] = true;
                }
            } catch (ArithmeticException e11) {
                String str3 = new String(cArr);
                if (str3.length() != 0) {
                    str2 = "Illegal alphabet ".concat(str3);
                } else {
                    str2 = new String("Illegal alphabet ");
                }
                throw new IllegalArgumentException(str2, e11);
            }
        } catch (ArithmeticException e12) {
            int length2 = cArr.length;
            StringBuilder sb2 = new StringBuilder(35);
            sb2.append("Illegal alphabet length ");
            sb2.append(length2);
            throw new IllegalArgumentException(sb2.toString(), e12);
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzjj) {
            return Arrays.equals(this.zzf, ((zzjj) obj).zzf);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf);
    }

    public final String toString() {
        return this.zze;
    }

    public final char zza(int i11) {
        return this.zzf[i11];
    }

    public final boolean zzb(char c11) {
        return c11 < 128 && this.zzg[c11] != -1;
    }
}
