package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;

public final class zzwh {
    public static void zza(long j11, zzfd zzfd, zzxt[] zzxtArr) {
        int i11;
        boolean z11;
        while (true) {
            boolean z12 = true;
            if (zzfd.zza() > 1) {
                int zzc = zzc(zzfd);
                int zzc2 = zzc(zzfd);
                int zzc3 = zzfd.zzc() + zzc2;
                if (zzc2 == -1 || zzc2 > zzfd.zza()) {
                    Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzc3 = zzfd.zzd();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzk = zzfd.zzk();
                    int zzo = zzfd.zzo();
                    if (zzo == 49) {
                        i11 = zzfd.zze();
                        zzo = 49;
                    } else {
                        i11 = 0;
                    }
                    int zzk2 = zzfd.zzk();
                    if (zzo == 47) {
                        zzfd.zzG(1);
                        zzo = 47;
                    }
                    if (zzk == 181 && ((zzo == 49 || zzo == 47) && zzk2 == 3)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (zzo == 49) {
                        if (i11 != 1195456820) {
                            z12 = false;
                        }
                        z11 &= z12;
                    }
                    if (z11) {
                        zzb(j11, zzfd, zzxtArr);
                    }
                }
                zzfd.zzF(zzc3);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j11, zzfd zzfd, zzxt[] zzxtArr) {
        int zzk = zzfd.zzk();
        if ((zzk & 64) != 0) {
            zzfd.zzG(1);
            int i11 = (zzk & 31) * 3;
            int zzc = zzfd.zzc();
            for (zzxt zzxt : zzxtArr) {
                zzfd.zzF(zzc);
                zzxt.zzq(zzfd, i11);
                if (j11 != C.TIME_UNSET) {
                    zzxt.zzs(j11, 1, i11, 0, (zzxs) null);
                }
            }
        }
    }

    private static int zzc(zzfd zzfd) {
        int i11 = 0;
        while (zzfd.zza() != 0) {
            int zzk = zzfd.zzk();
            i11 += zzk;
            if (zzk != 255) {
                return i11;
            }
        }
        return -1;
    }
}
