package com.google.android.gms.internal.ads;

public final class zzxy {
    public static int zza(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    public static zzxv zzb(zzfd zzfd, boolean z11, boolean z12) throws zzbj {
        if (z11) {
            zzc(3, zzfd, false);
        }
        String zzx = zzfd.zzx((int) zzfd.zzq(), zzfpt.zzc);
        long zzq = zzfd.zzq();
        String[] strArr = new String[((int) zzq)];
        int length = zzx.length() + 15;
        for (int i11 = 0; ((long) i11) < zzq; i11++) {
            String zzx2 = zzfd.zzx((int) zzfd.zzq(), zzfpt.zzc);
            strArr[i11] = zzx2;
            length = length + 4 + zzx2.length();
        }
        if (!z12 || (zzfd.zzk() & 1) != 0) {
            return new zzxv(zzx, strArr, length + 1);
        }
        throw zzbj.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzc(int i11, zzfd zzfd, boolean z11) throws zzbj {
        String str;
        if (zzfd.zza() < 7) {
            if (z11) {
                return false;
            }
            int zza = zzfd.zza();
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("too short header: ");
            sb2.append(zza);
            throw zzbj.zza(sb2.toString(), (Throwable) null);
        } else if (zzfd.zzk() != i11) {
            if (z11) {
                return false;
            }
            String valueOf = String.valueOf(Integer.toHexString(i11));
            if (valueOf.length() != 0) {
                str = "expected header type ".concat(valueOf);
            } else {
                str = new String("expected header type ");
            }
            throw zzbj.zza(str, (Throwable) null);
        } else if (zzfd.zzk() == 118 && zzfd.zzk() == 111 && zzfd.zzk() == 114 && zzfd.zzk() == 98 && zzfd.zzk() == 105 && zzfd.zzk() == 115) {
            return true;
        } else {
            if (z11) {
                return false;
            }
            throw zzbj.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
