package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzgir {
    public static int zza(byte[] bArr, int i11, zzgiq zzgiq) throws zzgkx {
        int zzj = zzj(bArr, i11, zzgiq);
        int i12 = zzgiq.zza;
        if (i12 < 0) {
            throw zzgkx.zzf();
        } else if (i12 > bArr.length - zzj) {
            throw zzgkx.zzj();
        } else if (i12 == 0) {
            zzgiq.zzc = zzgjf.zzb;
            return zzj;
        } else {
            zzgiq.zzc = zzgjf.zzw(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    public static int zzc(zzgmo zzgmo, byte[] bArr, int i11, int i12, int i13, zzgiq zzgiq) throws IOException {
        zzgly zzgly = (zzgly) zzgmo;
        Object zze = zzgly.zze();
        int zzc = zzgly.zzc(zze, bArr, i11, i12, i13, zzgiq);
        zzgly.zzf(zze);
        zzgiq.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzd(com.google.android.gms.internal.ads.zzgmo r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzgiq r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zze()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzi(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzgkx r6 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgir.zzd(com.google.android.gms.internal.ads.zzgmo, byte[], int, int, com.google.android.gms.internal.ads.zzgiq):int");
    }

    public static int zze(zzgmo<?> zzgmo, int i11, byte[] bArr, int i12, int i13, zzgku<?> zzgku, zzgiq zzgiq) throws IOException {
        int zzd = zzd(zzgmo, bArr, i12, i13, zzgiq);
        zzgku.add(zzgiq.zzc);
        while (zzd < i13) {
            int zzj = zzj(bArr, zzd, zzgiq);
            if (i11 != zzgiq.zza) {
                break;
            }
            zzd = zzd(zzgmo, bArr, zzj, i13, zzgiq);
            zzgku.add(zzgiq.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzgku<?> zzgku, zzgiq zzgiq) throws IOException {
        zzgkm zzgkm = (zzgkm) zzgku;
        int zzj = zzj(bArr, i11, zzgiq);
        int i12 = zzgiq.zza + zzj;
        while (zzj < i12) {
            zzj = zzj(bArr, zzj, zzgiq);
            zzgkm.zzh(zzgiq.zza);
        }
        if (zzj == i12) {
            return zzj;
        }
        throw zzgkx.zzj();
    }

    public static int zzg(byte[] bArr, int i11, zzgiq zzgiq) throws zzgkx {
        int zzj = zzj(bArr, i11, zzgiq);
        int i12 = zzgiq.zza;
        if (i12 < 0) {
            throw zzgkx.zzf();
        } else if (i12 == 0) {
            zzgiq.zzc = "";
            return zzj;
        } else {
            zzgiq.zzc = new String(bArr, zzj, i12, zzgkv.zzb);
            return zzj + i12;
        }
    }

    public static int zzh(byte[] bArr, int i11, zzgiq zzgiq) throws zzgkx {
        int zzj = zzj(bArr, i11, zzgiq);
        int i12 = zzgiq.zza;
        if (i12 < 0) {
            throw zzgkx.zzf();
        } else if (i12 == 0) {
            zzgiq.zzc = "";
            return zzj;
        } else {
            zzgiq.zzc = zzgnu.zzh(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzi(int i11, byte[] bArr, int i12, int i13, zzgng zzgng, zzgiq zzgiq) throws zzgkx {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzm = zzm(bArr, i12, zzgiq);
                zzgng.zzh(i11, Long.valueOf(zzgiq.zzb));
                return zzm;
            } else if (i14 == 1) {
                zzgng.zzh(i11, Long.valueOf(zzn(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzj = zzj(bArr, i12, zzgiq);
                int i15 = zzgiq.zza;
                if (i15 < 0) {
                    throw zzgkx.zzf();
                } else if (i15 <= bArr.length - zzj) {
                    if (i15 == 0) {
                        zzgng.zzh(i11, zzgjf.zzb);
                    } else {
                        zzgng.zzh(i11, zzgjf.zzw(bArr, zzj, i15));
                    }
                    return zzj + i15;
                } else {
                    throw zzgkx.zzj();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zzgng zze = zzgng.zze();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i12, zzgiq);
                    int i18 = zzgiq.zza;
                    if (i18 == i16) {
                        i17 = i18;
                        i12 = zzj2;
                        break;
                    }
                    i17 = i18;
                    i12 = zzi(i18, bArr, zzj2, i13, zze, zzgiq);
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzgkx.zzg();
                }
                zzgng.zzh(i11, zze);
                return i12;
            } else if (i14 == 5) {
                zzgng.zzh(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzgkx.zzc();
            }
        } else {
            throw zzgkx.zzc();
        }
    }

    public static int zzj(byte[] bArr, int i11, zzgiq zzgiq) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzgiq);
        }
        zzgiq.zza = b11;
        return i12;
    }

    public static int zzk(int i11, byte[] bArr, int i12, zzgiq zzgiq) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzgiq.zza = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzgiq.zza = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzgiq.zza = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzgiq.zza = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzgiq.zza = i22;
                return i23;
            }
        }
    }

    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzgku<?> zzgku, zzgiq zzgiq) {
        zzgkm zzgkm = (zzgkm) zzgku;
        int zzj = zzj(bArr, i12, zzgiq);
        zzgkm.zzh(zzgiq.zza);
        while (zzj < i13) {
            int zzj2 = zzj(bArr, zzj, zzgiq);
            if (i11 != zzgiq.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzgiq);
            zzgkm.zzh(zzgiq.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i11, zzgiq zzgiq) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 < 0) {
            int i13 = i12 + 1;
            byte b11 = bArr[i12];
            long j12 = (j11 & 127) | (((long) (b11 & Byte.MAX_VALUE)) << 7);
            int i14 = 7;
            while (b11 < 0) {
                int i15 = i13 + 1;
                byte b12 = bArr[i13];
                i14 += 7;
                j12 |= ((long) (b12 & Byte.MAX_VALUE)) << i14;
                int i16 = i15;
                b11 = b12;
                i13 = i16;
            }
            zzgiq.zzb = j12;
            return i13;
        }
        zzgiq.zzb = j11;
        return i12;
    }

    public static long zzn(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }
}
