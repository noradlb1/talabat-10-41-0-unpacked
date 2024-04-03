package com.google.android.gms.internal.places;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzs {
    public static int zzb(byte[] bArr, int i11, zzr zzr) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzb((int) b11, bArr, i12, zzr);
        }
        zzr.zzdz = b11;
        return i12;
    }

    public static int zzc(byte[] bArr, int i11, zzr zzr) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 >= 0) {
            zzr.zzea = j11;
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
        zzr.zzea = j12;
        return i13;
    }

    public static double zzd(byte[] bArr, int i11) {
        return Double.longBitsToDouble(zzc(bArr, i11));
    }

    public static float zze(byte[] bArr, int i11) {
        return Float.intBitsToFloat(zzb(bArr, i11));
    }

    public static int zzf(byte[] bArr, int i11, zzr zzr) throws zzbk {
        int zzb = zzb(bArr, i11, zzr);
        int i12 = zzr.zzdz;
        if (i12 < 0) {
            throw zzbk.zzbq();
        } else if (i12 > bArr.length - zzb) {
            throw zzbk.zzbp();
        } else if (i12 == 0) {
            zzr.zzeb = zzw.zzeg;
            return zzb;
        } else {
            zzr.zzeb = zzw.zzc(bArr, zzb, i12);
            return zzb + i12;
        }
    }

    public static int zzd(byte[] bArr, int i11, zzr zzr) throws zzbk {
        int zzb = zzb(bArr, i11, zzr);
        int i12 = zzr.zzdz;
        if (i12 < 0) {
            throw zzbk.zzbq();
        } else if (i12 == 0) {
            zzr.zzeb = "";
            return zzb;
        } else {
            zzr.zzeb = new String(bArr, zzb, i12, zzbd.UTF_8);
            return zzb + i12;
        }
    }

    public static int zze(byte[] bArr, int i11, zzr zzr) throws zzbk {
        int zzb = zzb(bArr, i11, zzr);
        int i12 = zzr.zzdz;
        if (i12 < 0) {
            throw zzbk.zzbq();
        } else if (i12 == 0) {
            zzr.zzeb = "";
            return zzb;
        } else {
            zzr.zzeb = zzea.zzh(bArr, zzb, i12);
            return zzb + i12;
        }
    }

    public static int zzb(int i11, byte[] bArr, int i12, zzr zzr) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzr.zzdz = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzr.zzdz = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzr.zzdz = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzr.zzdz = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] >= 0) {
                zzr.zzdz = i22;
                return i23;
            }
            i21 = i23;
        }
    }

    public static long zzc(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static int zzb(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(com.google.android.gms.internal.places.zzda r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.places.zzr r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzb((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.places.zzr) r10)
            int r8 = r10.zzdz
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
            r0.zzb(r1, r2, r3, r4, r5)
            r6.zzd(r9)
            r10.zzeb = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.places.zzbk r6 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzs.zzb(com.google.android.gms.internal.places.zzda, byte[], int, int, com.google.android.gms.internal.places.zzr):int");
    }

    public static int zzb(zzda zzda, byte[] bArr, int i11, int i12, int i13, zzr zzr) throws IOException {
        zzco zzco = (zzco) zzda;
        Object newInstance = zzco.newInstance();
        int zzb = zzco.zzb(newInstance, bArr, i11, i12, i13, zzr);
        zzco.zzd(newInstance);
        zzr.zzeb = newInstance;
        return zzb;
    }

    public static int zzb(int i11, byte[] bArr, int i12, int i13, zzbh<?> zzbh, zzr zzr) {
        zzbe zzbe = (zzbe) zzbh;
        int zzb = zzb(bArr, i12, zzr);
        zzbe.zzac(zzr.zzdz);
        while (zzb < i13) {
            int zzb2 = zzb(bArr, zzb, zzr);
            if (i11 != zzr.zzdz) {
                break;
            }
            zzb = zzb(bArr, zzb2, zzr);
            zzbe.zzac(zzr.zzdz);
        }
        return zzb;
    }

    public static int zzb(byte[] bArr, int i11, zzbh<?> zzbh, zzr zzr) throws IOException {
        zzbe zzbe = (zzbe) zzbh;
        int zzb = zzb(bArr, i11, zzr);
        int i12 = zzr.zzdz + zzb;
        while (zzb < i12) {
            zzb = zzb(bArr, zzb, zzr);
            zzbe.zzac(zzr.zzdz);
        }
        if (zzb == i12) {
            return zzb;
        }
        throw zzbk.zzbp();
    }

    public static int zzb(zzda<?> zzda, int i11, byte[] bArr, int i12, int i13, zzbh<?> zzbh, zzr zzr) throws IOException {
        int zzb = zzb((zzda) zzda, bArr, i12, i13, zzr);
        zzbh.add(zzr.zzeb);
        while (zzb < i13) {
            int zzb2 = zzb(bArr, zzb, zzr);
            if (i11 != zzr.zzdz) {
                break;
            }
            zzb = zzb((zzda) zzda, bArr, zzb2, i13, zzr);
            zzbh.add(zzr.zzeb);
        }
        return zzb;
    }

    public static int zzb(int i11, byte[] bArr, int i12, int i13, zzdr zzdr, zzr zzr) throws zzbk {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzc = zzc(bArr, i12, zzr);
                zzdr.zzc(i11, Long.valueOf(zzr.zzea));
                return zzc;
            } else if (i14 == 1) {
                zzdr.zzc(i11, Long.valueOf(zzc(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzb = zzb(bArr, i12, zzr);
                int i15 = zzr.zzdz;
                if (i15 < 0) {
                    throw zzbk.zzbq();
                } else if (i15 <= bArr.length - zzb) {
                    if (i15 == 0) {
                        zzdr.zzc(i11, zzw.zzeg);
                    } else {
                        zzdr.zzc(i11, zzw.zzc(bArr, zzb, i15));
                    }
                    return zzb + i15;
                } else {
                    throw zzbk.zzbp();
                }
            } else if (i14 == 3) {
                zzdr zzdi = zzdr.zzdi();
                int i16 = (i11 & -8) | 4;
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzb2 = zzb(bArr, i12, zzr);
                    int i18 = zzr.zzdz;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zzb2;
                        break;
                    }
                    int zzb3 = zzb(i17, bArr, zzb2, i13, zzdi, zzr);
                    i17 = i18;
                    i12 = zzb3;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzbk.zzbt();
                }
                zzdr.zzc(i11, zzdi);
                return i12;
            } else if (i14 == 5) {
                zzdr.zzc(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzbk.zzbr();
            }
        } else {
            throw zzbk.zzbr();
        }
    }

    public static int zzb(int i11, byte[] bArr, int i12, int i13, zzr zzr) throws zzbk {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                return zzc(bArr, i12, zzr);
            }
            if (i14 == 1) {
                return i12 + 8;
            }
            if (i14 == 2) {
                return zzb(bArr, i12, zzr) + zzr.zzdz;
            }
            if (i14 == 3) {
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (i12 < i13) {
                    i12 = zzb(bArr, i12, zzr);
                    i16 = zzr.zzdz;
                    if (i16 == i15) {
                        break;
                    }
                    i12 = zzb(i16, bArr, i12, i13, zzr);
                }
                if (i12 <= i13 && i16 == i15) {
                    return i12;
                }
                throw zzbk.zzbt();
            } else if (i14 == 5) {
                return i12 + 4;
            } else {
                throw zzbk.zzbr();
            }
        } else {
            throw zzbk.zzbr();
        }
    }
}
