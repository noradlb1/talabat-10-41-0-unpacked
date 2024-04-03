package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzax {
    public static int zza(int i11, byte[] bArr, int i12, int i13, zzay zzay) throws zzco {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                return zzb(bArr, i12, zzay);
            }
            if (i14 == 1) {
                return i12 + 8;
            }
            if (i14 == 2) {
                return zza(bArr, i12, zzay) + zzay.zzfd;
            }
            if (i14 == 3) {
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (i12 < i13) {
                    i12 = zza(bArr, i12, zzay);
                    i16 = zzay.zzfd;
                    if (i16 == i15) {
                        break;
                    }
                    i12 = zza(i16, bArr, i12, i13, zzay);
                }
                if (i12 <= i13 && i16 == i15) {
                    return i12;
                }
                throw zzco.zzbo();
            } else if (i14 == 5) {
                return i12 + 4;
            } else {
                throw zzco.zzbm();
            }
        } else {
            throw zzco.zzbm();
        }
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13, zzcn<?> zzcn, zzay zzay) {
        zzch zzch = (zzch) zzcn;
        int zza = zza(bArr, i12, zzay);
        while (true) {
            zzch.zzac(zzay.zzfd);
            if (zza >= i13) {
                break;
            }
            int zza2 = zza(bArr, zza, zzay);
            if (i11 != zzay.zzfd) {
                break;
            }
            zza = zza(bArr, zza2, zzay);
        }
        return zza;
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13, zzey zzey, zzay zzay) throws IOException {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzb = zzb(bArr, i12, zzay);
                zzey.zzb(i11, Long.valueOf(zzay.zzfe));
                return zzb;
            } else if (i14 == 1) {
                zzey.zzb(i11, Long.valueOf(zzd(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zza = zza(bArr, i12, zzay);
                int i15 = zzay.zzfd;
                zzey.zzb(i11, i15 == 0 ? zzbb.zzfi : zzbb.zzb(bArr, zza, i15));
                return zza + i15;
            } else if (i14 == 3) {
                zzey zzeb = zzey.zzeb();
                int i16 = (i11 & -8) | 4;
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zza2 = zza(bArr, i12, zzay);
                    int i18 = zzay.zzfd;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zza2;
                        break;
                    }
                    int zza3 = zza(i17, bArr, zza2, i13, zzeb, zzay);
                    i17 = i18;
                    i12 = zza3;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzco.zzbo();
                }
                zzey.zzb(i11, zzeb);
                return i12;
            } else if (i14 == 5) {
                zzey.zzb(i11, Integer.valueOf(zzc(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzco.zzbm();
            }
        } else {
            throw zzco.zzbm();
        }
    }

    public static int zza(int i11, byte[] bArr, int i12, zzay zzay) {
        int i13;
        int i14;
        int i15 = i11 & 127;
        int i16 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            i14 = b11 << 7;
        } else {
            int i17 = i15 | ((b11 & Byte.MAX_VALUE) << 7);
            int i18 = i16 + 1;
            byte b12 = bArr[i16];
            if (b12 >= 0) {
                i13 = b12 << Ascii.SO;
            } else {
                i15 = i17 | ((b12 & Byte.MAX_VALUE) << Ascii.SO);
                i16 = i18 + 1;
                byte b13 = bArr[i18];
                if (b13 >= 0) {
                    i14 = b13 << Ascii.NAK;
                } else {
                    i17 = i15 | ((b13 & Byte.MAX_VALUE) << Ascii.NAK);
                    i18 = i16 + 1;
                    byte b14 = bArr[i16];
                    if (b14 >= 0) {
                        i13 = b14 << Ascii.FS;
                    } else {
                        int i19 = i17 | ((b14 & Byte.MAX_VALUE) << Ascii.FS);
                        while (true) {
                            int i21 = i18 + 1;
                            if (bArr[i18] >= 0) {
                                zzay.zzfd = i19;
                                return i21;
                            }
                            i18 = i21;
                        }
                    }
                }
            }
            zzay.zzfd = i17 | i13;
            return i18;
        }
        zzay.zzfd = i15 | i14;
        return i16;
    }

    public static int zza(byte[] bArr, int i11, zzay zzay) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zza((int) b11, bArr, i12, zzay);
        }
        zzay.zzfd = b11;
        return i12;
    }

    public static int zza(byte[] bArr, int i11, zzcn<?> zzcn, zzay zzay) throws IOException {
        zzch zzch = (zzch) zzcn;
        int zza = zza(bArr, i11, zzay);
        int i12 = zzay.zzfd + zza;
        while (zza < i12) {
            zza = zza(bArr, zza, zzay);
            zzch.zzac(zzay.zzfd);
        }
        if (zza == i12) {
            return zza;
        }
        throw zzco.zzbl();
    }

    public static int zzb(byte[] bArr, int i11, zzay zzay) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 >= 0) {
            zzay.zzfe = j11;
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
        zzay.zzfe = j12;
        return i13;
    }

    public static int zzc(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    public static int zzc(byte[] bArr, int i11, zzay zzay) {
        int zza = zza(bArr, i11, zzay);
        int i12 = zzay.zzfd;
        if (i12 == 0) {
            zzay.zzff = "";
            return zza;
        }
        zzay.zzff = new String(bArr, zza, i12, zzci.UTF_8);
        return zza + i12;
    }

    public static int zzd(byte[] bArr, int i11, zzay zzay) throws IOException {
        int zza = zza(bArr, i11, zzay);
        int i12 = zzay.zzfd;
        if (i12 == 0) {
            zzay.zzff = "";
            return zza;
        }
        int i13 = zza + i12;
        if (zzff.zze(bArr, zza, i13)) {
            zzay.zzff = new String(bArr, zza, i12, zzci.UTF_8);
            return i13;
        }
        throw zzco.zzbp();
    }

    public static long zzd(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static double zze(byte[] bArr, int i11) {
        return Double.longBitsToDouble(zzd(bArr, i11));
    }

    public static int zze(byte[] bArr, int i11, zzay zzay) {
        int zza = zza(bArr, i11, zzay);
        int i12 = zzay.zzfd;
        if (i12 == 0) {
            zzay.zzff = zzbb.zzfi;
            return zza;
        }
        zzay.zzff = zzbb.zzb(bArr, zza, i12);
        return zza + i12;
    }

    public static float zzf(byte[] bArr, int i11) {
        return Float.intBitsToFloat(zzc(bArr, i11));
    }
}
