package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzez {
    public static int zza(byte[] bArr, int i11, zzfb zzfb) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zza((int) b11, bArr, i12, zzfb);
        }
        zzfb.zzro = b11;
        return i12;
    }

    public static int zzb(byte[] bArr, int i11, zzfb zzfb) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 >= 0) {
            zzfb.zzrp = j11;
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
            int i16 = i15;
            b11 = b12;
            i13 = i16;
        }
        zzfb.zzrp = j12;
        return i13;
    }

    public static double zzc(byte[] bArr, int i11) {
        return Double.longBitsToDouble(zzb(bArr, i11));
    }

    public static float zzd(byte[] bArr, int i11) {
        return Float.intBitsToFloat(zza(bArr, i11));
    }

    public static int zze(byte[] bArr, int i11, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro;
        if (i12 < 0) {
            throw zzhc.zzgn();
        } else if (i12 > bArr.length - zza) {
            throw zzhc.zzgm();
        } else if (i12 == 0) {
            zzfb.zzrq = zzfh.zzrx;
            return zza;
        } else {
            zzfb.zzrq = zzfh.zza(bArr, zza, i12);
            return zza + i12;
        }
    }

    public static int zzf(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgb zzgb = (zzgb) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zzgb.zzc(zzc(bArr, zza));
            zza += 8;
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzg(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        boolean z11;
        zzff zzff = (zzff) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zza = zzb(bArr, zza, zzfb);
            if (zzfb.zzrp != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzff.addBoolean(z11);
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzh(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zza = zza(bArr, zza, zzfb);
            zzgu.zzbl(zzft.zzau(zzfb.zzro));
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzi(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zza = zzb(bArr, zza, zzfb);
            zzhq.zzac(zzft.zzr(zzfb.zzrp));
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzc(byte[] bArr, int i11, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro;
        if (i12 < 0) {
            throw zzhc.zzgn();
        } else if (i12 == 0) {
            zzfb.zzrq = "";
            return zza;
        } else {
            zzfb.zzrq = new String(bArr, zza, i12, zzgt.UTF_8);
            return zza + i12;
        }
    }

    public static int zzd(byte[] bArr, int i11, zzfb zzfb) throws zzhc {
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro;
        if (i12 < 0) {
            throw zzhc.zzgn();
        } else if (i12 == 0) {
            zzfb.zzrq = "";
            return zza;
        } else {
            zzfb.zzrq = zzjs.zzh(bArr, zza, i12);
            return zza + i12;
        }
    }

    public static int zza(int i11, byte[] bArr, int i12, zzfb zzfb) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzfb.zzro = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzfb.zzro = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzfb.zzro = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzfb.zzro = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] >= 0) {
                zzfb.zzro = i22;
                return i23;
            }
            i21 = i23;
        }
    }

    public static long zzb(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static int zzb(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zza = zzb(bArr, zza, zzfb);
            zzhq.zzac(zzfb.zzrp);
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzc(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zzgu.zzbl(zza(bArr, zza));
            zza += 4;
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zzd(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzhq zzhq = (zzhq) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zzhq.zzac(zzb(bArr, zza));
            zza += 8;
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zze(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgo zzgo = (zzgo) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zzgo.zzu(zzd(bArr, zza));
            zza += 4;
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zza(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(com.google.android.gms.internal.vision.zzir r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.vision.zzfb r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.vision.zzfb) r10)
            int r8 = r10.zzro
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzg(r9)
            r10.zzrq = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.vision.zzhc r6 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzez.zza(com.google.android.gms.internal.vision.zzir, byte[], int, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    public static int zza(zzir zzir, byte[] bArr, int i11, int i12, int i13, zzfb zzfb) throws IOException {
        zzig zzig = (zzig) zzir;
        Object newInstance = zzig.newInstance();
        int zza = zzig.zza(newInstance, bArr, i11, i12, i13, zzfb);
        zzig.zzg(newInstance);
        zzfb.zzrq = newInstance;
        return zza;
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13, zzgz<?> zzgz, zzfb zzfb) {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i12, zzfb);
        zzgu.zzbl(zzfb.zzro);
        while (zza < i13) {
            int zza2 = zza(bArr, zza, zzfb);
            if (i11 != zzfb.zzro) {
                break;
            }
            zza = zza(bArr, zza2, zzfb);
            zzgu.zzbl(zzfb.zzro);
        }
        return zza;
    }

    public static int zza(byte[] bArr, int i11, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        zzgu zzgu = (zzgu) zzgz;
        int zza = zza(bArr, i11, zzfb);
        int i12 = zzfb.zzro + zza;
        while (zza < i12) {
            zza = zza(bArr, zza, zzfb);
            zzgu.zzbl(zzfb.zzro);
        }
        if (zza == i12) {
            return zza;
        }
        throw zzhc.zzgm();
    }

    public static int zza(zzir<?> zzir, int i11, byte[] bArr, int i12, int i13, zzgz<?> zzgz, zzfb zzfb) throws IOException {
        int zza = zza((zzir) zzir, bArr, i12, i13, zzfb);
        zzgz.add(zzfb.zzrq);
        while (zza < i13) {
            int zza2 = zza(bArr, zza, zzfb);
            if (i11 != zzfb.zzro) {
                break;
            }
            zza = zza((zzir) zzir, bArr, zza2, i13, zzfb);
            zzgz.add(zzfb.zzrq);
        }
        return zza;
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13, zzjm zzjm, zzfb zzfb) throws zzhc {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzb = zzb(bArr, i12, zzfb);
                zzjm.zzb(i11, Long.valueOf(zzfb.zzrp));
                return zzb;
            } else if (i14 == 1) {
                zzjm.zzb(i11, Long.valueOf(zzb(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zza = zza(bArr, i12, zzfb);
                int i15 = zzfb.zzro;
                if (i15 < 0) {
                    throw zzhc.zzgn();
                } else if (i15 <= bArr.length - zza) {
                    if (i15 == 0) {
                        zzjm.zzb(i11, zzfh.zzrx);
                    } else {
                        zzjm.zzb(i11, zzfh.zza(bArr, zza, i15));
                    }
                    return zza + i15;
                } else {
                    throw zzhc.zzgm();
                }
            } else if (i14 == 3) {
                zzjm zzih = zzjm.zzih();
                int i16 = (i11 & -8) | 4;
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zza2 = zza(bArr, i12, zzfb);
                    int i18 = zzfb.zzro;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zza2;
                        break;
                    }
                    int zza3 = zza(i17, bArr, zza2, i13, zzih, zzfb);
                    i17 = i18;
                    i12 = zza3;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzhc.zzgs();
                }
                zzjm.zzb(i11, zzih);
                return i12;
            } else if (i14 == 5) {
                zzjm.zzb(i11, Integer.valueOf(zza(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzhc.zzgp();
            }
        } else {
            throw zzhc.zzgp();
        }
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13, zzfb zzfb) throws zzhc {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                return zzb(bArr, i12, zzfb);
            }
            if (i14 == 1) {
                return i12 + 8;
            }
            if (i14 == 2) {
                return zza(bArr, i12, zzfb) + zzfb.zzro;
            }
            if (i14 == 3) {
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (i12 < i13) {
                    i12 = zza(bArr, i12, zzfb);
                    i16 = zzfb.zzro;
                    if (i16 == i15) {
                        break;
                    }
                    i12 = zza(i16, bArr, i12, i13, zzfb);
                }
                if (i12 <= i13 && i16 == i15) {
                    return i12;
                }
                throw zzhc.zzgs();
            } else if (i14 == 5) {
                return i12 + 4;
            } else {
                throw zzhc.zzgp();
            }
        } else {
            throw zzhc.zzgp();
        }
    }
}
