package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzew {
    public static int zza(byte[] bArr, int i11, zzev zzev) throws zzhp {
        int zzj = zzj(bArr, i11, zzev);
        int i12 = zzev.zza;
        if (i12 < 0) {
            throw zzhp.zzf();
        } else if (i12 > bArr.length - zzj) {
            throw zzhp.zzj();
        } else if (i12 == 0) {
            zzev.zzc = zzfi.zzb;
            return zzj;
        } else {
            zzev.zzc = zzfi.zzm(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    public static int zzc(zzjc zzjc, byte[] bArr, int i11, int i12, int i13, zzev zzev) throws IOException {
        Object zze = zzjc.zze();
        int zzn = zzn(zze, zzjc, bArr, i11, i12, i13, zzev);
        zzjc.zzf(zze);
        zzev.zzc = zze;
        return zzn;
    }

    public static int zzd(zzjc zzjc, byte[] bArr, int i11, int i12, zzev zzev) throws IOException {
        Object zze = zzjc.zze();
        int zzo = zzo(zze, zzjc, bArr, i11, i12, zzev);
        zzjc.zzf(zze);
        zzev.zzc = zze;
        return zzo;
    }

    public static int zze(zzjc zzjc, int i11, byte[] bArr, int i12, int i13, zzhm zzhm, zzev zzev) throws IOException {
        int zzd = zzd(zzjc, bArr, i12, i13, zzev);
        zzhm.add(zzev.zzc);
        while (zzd < i13) {
            int zzj = zzj(bArr, zzd, zzev);
            if (i11 != zzev.zza) {
                break;
            }
            zzd = zzd(zzjc, bArr, zzj, i13, zzev);
            zzhm.add(zzev.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzhm zzhm, zzev zzev) throws IOException {
        zzhg zzhg = (zzhg) zzhm;
        int zzj = zzj(bArr, i11, zzev);
        int i12 = zzev.zza + zzj;
        while (zzj < i12) {
            zzj = zzj(bArr, zzj, zzev);
            zzhg.zzg(zzev.zza);
        }
        if (zzj == i12) {
            return zzj;
        }
        throw zzhp.zzj();
    }

    public static int zzg(byte[] bArr, int i11, zzev zzev) throws zzhp {
        int zzj = zzj(bArr, i11, zzev);
        int i12 = zzev.zza;
        if (i12 < 0) {
            throw zzhp.zzf();
        } else if (i12 == 0) {
            zzev.zzc = "";
            return zzj;
        } else {
            zzev.zzc = new String(bArr, zzj, i12, zzhn.zzb);
            return zzj + i12;
        }
    }

    public static int zzh(byte[] bArr, int i11, zzev zzev) throws zzhp {
        int zzj = zzj(bArr, i11, zzev);
        int i12 = zzev.zza;
        if (i12 < 0) {
            throw zzhp.zzf();
        } else if (i12 == 0) {
            zzev.zzc = "";
            return zzj;
        } else {
            zzev.zzc = zzkl.zzd(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzi(int i11, byte[] bArr, int i12, int i13, zzjx zzjx, zzev zzev) throws zzhp {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzm = zzm(bArr, i12, zzev);
                zzjx.zzj(i11, Long.valueOf(zzev.zzb));
                return zzm;
            } else if (i14 == 1) {
                zzjx.zzj(i11, Long.valueOf(zzq(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzj = zzj(bArr, i12, zzev);
                int i15 = zzev.zza;
                if (i15 < 0) {
                    throw zzhp.zzf();
                } else if (i15 <= bArr.length - zzj) {
                    if (i15 == 0) {
                        zzjx.zzj(i11, zzfi.zzb);
                    } else {
                        zzjx.zzj(i11, zzfi.zzm(bArr, zzj, i15));
                    }
                    return zzj + i15;
                } else {
                    throw zzhp.zzj();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zzjx zzf = zzjx.zzf();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i12, zzev);
                    int i18 = zzev.zza;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zzj2;
                        break;
                    }
                    int zzi = zzi(i17, bArr, zzj2, i13, zzf, zzev);
                    i17 = i18;
                    i12 = zzi;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzhp.zzg();
                }
                zzjx.zzj(i11, zzf);
                return i12;
            } else if (i14 == 5) {
                zzjx.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzhp.zzc();
            }
        } else {
            throw zzhp.zzc();
        }
    }

    public static int zzj(byte[] bArr, int i11, zzev zzev) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzev);
        }
        zzev.zza = b11;
        return i12;
    }

    public static int zzk(int i11, byte[] bArr, int i12, zzev zzev) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzev.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i13 + 1;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzev.zza = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzev.zza = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzev.zza = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzev.zza = i22;
                return i23;
            }
        }
    }

    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzhm zzhm, zzev zzev) {
        zzhg zzhg = (zzhg) zzhm;
        int zzj = zzj(bArr, i12, zzev);
        zzhg.zzg(zzev.zza);
        while (zzj < i13) {
            int zzj2 = zzj(bArr, zzj, zzev);
            if (i11 != zzev.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzev);
            zzhg.zzg(zzev.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i11, zzev zzev) {
        long j11 = (long) bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzev.zzb = j11;
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
        zzev.zzb = j12;
        return i13;
    }

    public static int zzn(Object obj, zzjc zzjc, byte[] bArr, int i11, int i12, int i13, zzev zzev) throws IOException {
        int zzc = ((zzis) zzjc).zzc(obj, bArr, i11, i12, i13, zzev);
        zzev.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzo(java.lang.Object r6, com.google.android.recaptcha.internal.zzjc r7, byte[] r8, int r9, int r10, com.google.android.recaptcha.internal.zzev r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
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
            com.google.android.recaptcha.internal.zzhp r6 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzew.zzo(java.lang.Object, com.google.android.recaptcha.internal.zzjc, byte[], int, int, com.google.android.recaptcha.internal.zzev):int");
    }

    public static int zzp(int i11, byte[] bArr, int i12, int i13, zzev zzev) throws zzhp {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                return zzm(bArr, i12, zzev);
            }
            if (i14 == 1) {
                return i12 + 8;
            }
            if (i14 == 2) {
                return zzj(bArr, i12, zzev) + zzev.zza;
            }
            if (i14 == 3) {
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (i12 < i13) {
                    i12 = zzj(bArr, i12, zzev);
                    i16 = zzev.zza;
                    if (i16 == i15) {
                        break;
                    }
                    i12 = zzp(i16, bArr, i12, i13, zzev);
                }
                if (i12 <= i13 && i16 == i15) {
                    return i12;
                }
                throw zzhp.zzg();
            } else if (i14 == 5) {
                return i12 + 4;
            } else {
                throw zzhp.zzc();
            }
        } else {
            throw zzhp.zzc();
        }
    }

    public static long zzq(byte[] bArr, int i11) {
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48) | ((((long) bArr[i11 + 7]) & 255) << 56);
    }
}
