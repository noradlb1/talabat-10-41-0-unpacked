package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

public final class zzadg implements zzwp {
    public static final zzww zza = zzadf.zza;
    private final zzadh zzb = new zzadh((String) null);
    private final zzfd zzc = new zzfd(2786);
    private boolean zzd;

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        int zzg = zzwq.zzg(this.zzc.zzH(), 0, 2786);
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
        zzfd zzfd = new zzfd(10);
        int i11 = 0;
        while (true) {
            zzwk zzwk = (zzwk) zzwq;
            zzwk.zzm(zzfd.zzH(), 0, 10, false);
            zzfd.zzF(0);
            if (zzfd.zzm() != 4801587) {
                break;
            }
            zzfd.zzG(3);
            int zzj = zzfd.zzj();
            i11 += zzj + 10;
            zzwk.zzl(zzj, false);
        }
        zzwq.zzj();
        zzwk zzwk2 = (zzwk) zzwq;
        zzwk2.zzl(i11, false);
        int i12 = 0;
        int i13 = i11;
        while (true) {
            zzwk2.zzm(zzfd.zzH(), 0, 6, false);
            zzfd.zzF(0);
            if (zzfd.zzo() != 2935) {
                zzwq.zzj();
                i13++;
                if (i13 - i11 >= 8192) {
                    return false;
                }
                zzwk2.zzl(i13, false);
                i12 = 0;
            } else {
                i12++;
                if (i12 >= 4) {
                    return true;
                }
                int zza2 = zzvv.zza(zzfd.zzH());
                if (zza2 == -1) {
                    return false;
                }
                zzwk2.zzl(zza2 - 6, false);
            }
        }
    }
}
