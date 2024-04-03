package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

public final class zzrq {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzrq(int i11) {
        this(0, new Random());
    }

    public final int zza() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final int zzb() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int zzc() {
        return this.zzb.length;
    }

    public final int zzd(int i11) {
        int i12 = this.zzc[i11] + 1;
        int[] iArr = this.zzb;
        if (i12 < iArr.length) {
            return iArr[i12];
        }
        return -1;
    }

    public final int zze(int i11) {
        int i12 = this.zzc[i11] - 1;
        if (i12 >= 0) {
            return this.zzb[i12];
        }
        return -1;
    }

    public final zzrq zzf() {
        return new zzrq(0, new Random(this.zza.nextLong()));
    }

    public final zzrq zzg(int i11, int i12) {
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        int i13 = 0;
        int i14 = 0;
        while (i14 < i12) {
            iArr[i14] = this.zza.nextInt(this.zzb.length + 1);
            int i15 = i14 + 1;
            int nextInt = this.zza.nextInt(i15);
            iArr2[i14] = iArr2[nextInt];
            iArr2[nextInt] = i14;
            i14 = i15;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[(this.zzb.length + i12)];
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int[] iArr4 = this.zzb;
            if (i13 >= iArr4.length + i12) {
                return new zzrq(iArr3, new Random(this.zza.nextLong()));
            }
            if (i16 >= i12 || i17 != iArr[i16]) {
                int i18 = i17 + 1;
                int i19 = iArr4[i17];
                iArr3[i13] = i19;
                if (i19 >= 0) {
                    iArr3[i13] = i19 + i12;
                }
                i17 = i18;
            } else {
                iArr3[i13] = iArr2[i16];
                i16++;
            }
            i13++;
        }
    }

    public final zzrq zzh(int i11, int i12) {
        int[] iArr = new int[(this.zzb.length - i12)];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr2 = this.zzb;
            if (i13 >= iArr2.length) {
                return new zzrq(iArr, new Random(this.zza.nextLong()));
            }
            int i15 = iArr2[i13];
            if (i15 < 0 || i15 >= i12) {
                int i16 = i13 - i14;
                if (i15 >= 0) {
                    i15 -= i12;
                }
                iArr[i16] = i15;
            } else {
                i14++;
            }
            i13++;
        }
    }

    private zzrq(int i11, Random random) {
        this(new int[0], random);
    }

    private zzrq(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.zzc[iArr[i11]] = i11;
        }
    }
}
