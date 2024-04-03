package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;

public final class zzadj implements zzwp {
    public static final zzww zza = zzadi.zza;
    private final zzadk zzb = new zzadk((String) null);
    private final zzfd zzc = new zzfd(16384);
    private boolean zzd;

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        int zzg = zzwq.zzg(this.zzc.zzH(), 0, 16384);
        if (zzg == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zzg);
        if (!this.zzd) {
            this.zzb.zzd(0, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final void zzb(zzws zzws) {
        this.zzb.zzb(zzws, new zzafd(Integer.MIN_VALUE, 0, 1));
        zzws.zzB();
        zzws.zzL(new zzxo(C.TIME_UNSET, 0));
    }

    public final void zzc(long j11, long j12) {
        this.zzd = false;
        this.zzb.zze();
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        int i11;
        zzfd zzfd = new zzfd(10);
        int i12 = 0;
        while (true) {
            zzwk zzwk = (zzwk) zzwq;
            zzwk.zzm(zzfd.zzH(), 0, 10, false);
            zzfd.zzF(0);
            if (zzfd.zzm() != 4801587) {
                break;
            }
            zzfd.zzG(3);
            int zzj = zzfd.zzj();
            i12 += zzj + 10;
            zzwk.zzl(zzj, false);
        }
        zzwq.zzj();
        zzwk zzwk2 = (zzwk) zzwq;
        zzwk2.zzl(i12, false);
        int i13 = 0;
        int i14 = i12;
        while (true) {
            int i15 = 7;
            zzwk2.zzm(zzfd.zzH(), 0, 7, false);
            zzfd.zzF(0);
            int zzo = zzfd.zzo();
            if (zzo == 44096 || zzo == 44097) {
                i13++;
                if (i13 >= 4) {
                    return true;
                }
                byte[] zzH = zzfd.zzH();
                int i16 = zzvy.zza;
                if (zzH.length < 7) {
                    i11 = -1;
                } else {
                    byte b11 = ((zzH[2] & 255) << 8) | (zzH[3] & 255);
                    if (b11 == 65535) {
                        b11 = ((zzH[4] & 255) << Ascii.DLE) | ((zzH[5] & 255) << 8) | (zzH[6] & 255);
                    } else {
                        i15 = 4;
                    }
                    if (zzo == 44097) {
                        i15 += 2;
                    }
                    i11 = b11 + i15;
                }
                if (i11 == -1) {
                    return false;
                }
                zzwk2.zzl(i11 - 7, false);
            } else {
                zzwq.zzj();
                i14++;
                if (i14 - i12 >= 8192) {
                    return false;
                }
                zzwk2.zzl(i14, false);
                i13 = 0;
            }
        }
    }
}
