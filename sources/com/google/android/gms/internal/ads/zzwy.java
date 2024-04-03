package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzwy {
    public static int zza(zzfd zzfd, int i11) {
        switch (i11) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return zzfd.zzk() + 1;
            case 7:
                return zzfd.zzo() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzwq zzwq, zzxd zzxd) throws IOException {
        int i11;
        zzwq.zzj();
        zzwk zzwk = (zzwk) zzwq;
        boolean z11 = true;
        zzwk.zzl(1, false);
        byte[] bArr = new byte[1];
        zzwk.zzm(bArr, 0, 1, false);
        byte b11 = bArr[0] & 1;
        zzwk.zzl(2, false);
        if (1 != b11) {
            i11 = 6;
        } else {
            i11 = 7;
        }
        zzfd zzfd = new zzfd(i11);
        zzfd.zzE(zzwt.zza(zzwq, zzfd.zzH(), 0, i11));
        zzwq.zzj();
        zzwx zzwx = new zzwx();
        if (1 != b11) {
            z11 = false;
        }
        if (zzd(zzfd, zzxd, z11, zzwx)) {
            return zzwx.zza;
        }
        throw zzbj.zza((String) null, (Throwable) null);
    }

    public static boolean zzc(zzfd zzfd, zzxd zzxd, int i11, zzwx zzwx) {
        boolean z11;
        int zza;
        zzfd zzfd2 = zzfd;
        zzxd zzxd2 = zzxd;
        int zzc = zzfd.zzc();
        long zzs = zzfd.zzs();
        long j11 = zzs >>> 16;
        if (j11 != ((long) i11)) {
            return false;
        }
        if ((j11 & 1) == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = (int) ((zzs >> 12) & 15);
        int i13 = (int) ((zzs >> 8) & 15);
        int i14 = (int) (15 & (zzs >> 4));
        int i15 = (int) ((zzs >> 1) & 7);
        long j12 = zzs & 1;
        if (i14 <= 7) {
            if (i14 != zzxd2.zzg - 1) {
                return false;
            }
        } else if (i14 > 10 || zzxd2.zzg != 2) {
            return false;
        }
        if ((i15 != 0 && i15 != zzxd2.zzi) || j12 == 1 || !zzd(zzfd2, zzxd2, z11, zzwx) || (zza = zza(zzfd2, i12)) == -1 || zza > zzxd2.zzb) {
            return false;
        }
        int i16 = zzxd2.zze;
        if (i13 != 0) {
            if (i13 <= 11) {
                if (i13 != zzxd2.zzf) {
                    return false;
                }
            } else if (i13 == 12) {
                if (zzfd.zzk() * 1000 != i16) {
                    return false;
                }
            } else if (i13 > 14) {
                return false;
            } else {
                int zzo = zzfd.zzo();
                if (i13 == 14) {
                    zzo *= 10;
                }
                if (zzo != i16) {
                    return false;
                }
            }
        }
        if (zzfd.zzk() == zzfn.zzh(zzfd.zzH(), zzc, zzfd.zzc() - 1, 0)) {
            return true;
        }
        return false;
    }

    private static boolean zzd(zzfd zzfd, zzxd zzxd, boolean z11, zzwx zzwx) {
        try {
            long zzu = zzfd.zzu();
            if (!z11) {
                zzu *= (long) zzxd.zzb;
            }
            zzwx.zza = zzu;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
