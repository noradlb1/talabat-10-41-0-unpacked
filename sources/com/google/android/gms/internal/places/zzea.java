package com.google.android.gms.internal.places;

final class zzea {
    private static final zzec zzni;

    static {
        boolean z11;
        zzec zzec;
        if (!zzdy.zzdl() || !zzdy.zzdm()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || zzp.zzy()) {
            zzec = new zzeb();
        } else {
            zzec = new zzed();
        }
        zzni = zzec;
    }

    /* access modifiers changed from: private */
    public static int zzao(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    public static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && charSequence.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt < 2048) {
                i13 += (127 - charAt) >>> 31;
                i12++;
            } else {
                int length2 = charSequence.length();
                while (i12 < length2) {
                    char charAt2 = charSequence.charAt(i12);
                    if (charAt2 < 2048) {
                        i11 += (127 - charAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i12) >= 65536) {
                                i12++;
                            } else {
                                throw new zzee(i12, length2);
                            }
                        }
                    }
                    i12++;
                }
                i13 += i11;
            }
        }
        if (i13 >= length) {
            return i13;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i13) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* access modifiers changed from: private */
    public static int zzd(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    public static boolean zze(byte[] bArr) {
        return zzni.zzf(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i11, int i12) {
        return zzni.zzf(bArr, i11, i12);
    }

    /* access modifiers changed from: private */
    public static int zzg(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return zzao(b11);
        }
        if (i13 == 1) {
            return zzs(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return zzd(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    public static String zzh(byte[] bArr, int i11, int i12) throws zzbk {
        return zzni.zzh(bArr, i11, i12);
    }

    /* access modifiers changed from: private */
    public static int zzs(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    public static int zzb(CharSequence charSequence, byte[] bArr, int i11, int i12) {
        return zzni.zzc(charSequence, bArr, i11, i12);
    }
}
