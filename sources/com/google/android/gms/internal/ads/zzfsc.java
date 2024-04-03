package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

final class zzfsc {
    public static int zza(int i11) {
        return (i11 < 32 ? 4 : 2) * (i11 + 1);
    }

    public static int zzb(@CheckForNull Object obj, @CheckForNull Object obj2, int i11, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i12;
        int i13;
        int zzb = zzfsk.zzb(obj);
        int i14 = zzb & i11;
        int zzc = zzc(obj3, i14);
        if (zzc != 0) {
            int i15 = ~i11;
            int i16 = zzb & i15;
            int i17 = -1;
            while (true) {
                i12 = zzc - 1;
                i13 = iArr[i12];
                if ((i13 & i15) != i16 || !zzfqc.zza(obj, objArr[i12]) || (objArr2 != null && !zzfqc.zza(obj2, objArr2[i12]))) {
                    int i18 = i13 & i11;
                    if (i18 == 0) {
                        break;
                    }
                    int i19 = i18;
                    i17 = i12;
                    zzc = i19;
                }
            }
            int i21 = i13 & i11;
            if (i17 == -1) {
                zze(obj3, i14, i21);
            } else {
                iArr[i17] = (i21 & i11) | (iArr[i17] & i15);
            }
            return i12;
        }
        return -1;
    }

    public static int zzc(Object obj, int i11) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i11] & 255;
        }
        if (obj instanceof short[]) {
            return (char) ((short[]) obj)[i11];
        }
        return ((int[]) obj)[i11];
    }

    public static Object zzd(int i11) {
        if (i11 < 2 || i11 > 1073741824 || Integer.highestOneBit(i11) != i11) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("must be power of 2 between 2^1 and 2^30: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i11 <= 256) {
            return new byte[i11];
        } else {
            if (i11 <= 65536) {
                return new short[i11];
            }
            return new int[i11];
        }
    }

    public static void zze(Object obj, int i11, int i12) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i11] = (byte) i12;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i11] = (short) i12;
        } else {
            ((int[]) obj)[i11] = i12;
        }
    }
}
