package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafj  reason: invalid package */
final class zzafj {
    public static int zza(byte[] bArr, int i11, zzafi zzafi) throws zzahi {
        int zzh = zzh(bArr, i11, zzafi);
        int i12 = zzafi.zza;
        if (i12 < 0) {
            throw zzahi.zzf();
        } else if (i12 > bArr.length - zzh) {
            throw zzahi.zzj();
        } else if (i12 == 0) {
            zzafi.zzc = zzafv.zzb;
            return zzh;
        } else {
            zzafi.zzc = zzafv.zzn(bArr, zzh, i12);
            return zzh + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    public static int zzc(zzair zzair, byte[] bArr, int i11, int i12, int i13, zzafi zzafi) throws IOException {
        Object zze = zzair.zze();
        int zzl = zzl(zze, zzair, bArr, i11, i12, i13, zzafi);
        zzair.zzf(zze);
        zzafi.zzc = zze;
        return zzl;
    }

    public static int zzd(zzair zzair, byte[] bArr, int i11, int i12, zzafi zzafi) throws IOException {
        Object zze = zzair.zze();
        int zzm = zzm(zze, zzair, bArr, i11, i12, zzafi);
        zzair.zzf(zze);
        zzafi.zzc = zze;
        return zzm;
    }

    public static int zze(zzair zzair, int i11, byte[] bArr, int i12, int i13, zzahf zzahf, zzafi zzafi) throws IOException {
        int zzd = zzd(zzair, bArr, i12, i13, zzafi);
        zzahf.add(zzafi.zzc);
        while (zzd < i13) {
            int zzh = zzh(bArr, zzd, zzafi);
            if (i11 != zzafi.zza) {
                break;
            }
            zzd = zzd(zzair, bArr, zzh, i13, zzafi);
            zzahf.add(zzafi.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzahf zzahf, zzafi zzafi) throws IOException {
        zzahb zzahb = (zzahb) zzahf;
        int zzh = zzh(bArr, i11, zzafi);
        int i12 = zzafi.zza + zzh;
        while (zzh < i12) {
            zzh = zzh(bArr, zzh, zzafi);
            zzahb.zzf(zzafi.zza);
        }
        if (zzh == i12) {
            return zzh;
        }
        throw zzahi.zzj();
    }

    public static int zzg(int i11, byte[] bArr, int i12, int i13, zzajm zzajm, zzafi zzafi) throws zzahi {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzk = zzk(bArr, i12, zzafi);
                zzajm.zzj(i11, Long.valueOf(zzafi.zzb));
                return zzk;
            } else if (i14 == 1) {
                zzajm.zzj(i11, Long.valueOf(zzn(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzh = zzh(bArr, i12, zzafi);
                int i15 = zzafi.zza;
                if (i15 < 0) {
                    throw zzahi.zzf();
                } else if (i15 <= bArr.length - zzh) {
                    if (i15 == 0) {
                        zzajm.zzj(i11, zzafv.zzb);
                    } else {
                        zzajm.zzj(i11, zzafv.zzn(bArr, zzh, i15));
                    }
                    return zzh + i15;
                } else {
                    throw zzahi.zzj();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zzajm zzf = zzajm.zzf();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i12, zzafi);
                    int i18 = zzafi.zza;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zzh2;
                        break;
                    }
                    int zzg = zzg(i17, bArr, zzh2, i13, zzf, zzafi);
                    i17 = i18;
                    i12 = zzg;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzahi.zzg();
                }
                zzajm.zzj(i11, zzf);
                return i12;
            } else if (i14 == 5) {
                zzajm.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzahi.zzc();
            }
        } else {
            throw zzahi.zzc();
        }
    }

    public static int zzh(byte[] bArr, int i11, zzafi zzafi) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzi(b11, bArr, i12, zzafi);
        }
        zzafi.zza = b11;
        return i12;
    }

    public static int zzi(int i11, byte[] bArr, int i12, zzafi zzafi) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzafi.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i13 + 1;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzafi.zza = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzafi.zza = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzafi.zza = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzafi.zza = i22;
                return i23;
            }
        }
    }

    public static int zzj(int i11, byte[] bArr, int i12, int i13, zzahf zzahf, zzafi zzafi) {
        zzahb zzahb = (zzahb) zzahf;
        int zzh = zzh(bArr, i12, zzafi);
        zzahb.zzf(zzafi.zza);
        while (zzh < i13) {
            int zzh2 = zzh(bArr, zzh, zzafi);
            if (i11 != zzafi.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzafi);
            zzahb.zzf(zzafi.zza);
        }
        return zzh;
    }

    public static int zzk(byte[] bArr, int i11, zzafi zzafi) {
        long j11 = (long) bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzafi.zzb = j11;
            return i12;
        }
        int i13 = i12 + 1;
        byte b11 = bArr[i12];
        long j12 = (j11 & 127) | (((long) (b11 & Byte.MAX_VALUE)) << 7);
        int i14 = 7;
        while (b11 < 0) {
            int i15 = i13 + 1;
            byte b12 = bArr[i13];
            i14 += 7;
            j12 |= ((long) (b12 & Byte.MAX_VALUE)) << i14;
            byte b13 = b12;
            i13 = i15;
            b11 = b13;
        }
        zzafi.zzb = j12;
        return i13;
    }

    public static int zzl(Object obj, zzair zzair, byte[] bArr, int i11, int i12, int i13, zzafi zzafi) throws IOException {
        int zzc = ((zzaii) zzair).zzc(obj, bArr, i11, i12, i13, zzafi);
        zzafi.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzm(java.lang.Object r6, com.google.android.gms.internal.p002firebaseauthapi.zzair r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p002firebaseauthapi.zzafi r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.firebase-auth-api.zzahi r6 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzm(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzair, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzafi):int");
    }

    public static long zzn(byte[] bArr, int i11) {
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48) | ((((long) bArr[i11 + 7]) & 255) << 56);
    }
}
