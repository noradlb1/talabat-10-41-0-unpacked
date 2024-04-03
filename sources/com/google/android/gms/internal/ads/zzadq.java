package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

public final class zzadq implements zzadr {
    private final List<zzafa> zza;
    private final zzxt[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = C.TIME_UNSET;

    public zzadq(List<zzafa> list) {
        this.zza = list;
        this.zzb = new zzxt[list.size()];
    }

    private final boolean zzf(zzfd zzfd, int i11) {
        if (zzfd.zza() == 0) {
            return false;
        }
        if (zzfd.zzk() != i11) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzfd zzfd) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzfd, 32)) {
            if (this.zzd != 1 || zzf(zzfd, 0)) {
                int zzc2 = zzfd.zzc();
                int zza2 = zzfd.zza();
                for (zzxt zzq : this.zzb) {
                    zzfd.zzF(zzc2);
                    zzq.zzq(zzfd, zza2);
                }
                this.zze += zza2;
            }
        }
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        for (int i11 = 0; i11 < this.zzb.length; i11++) {
            zzafa zzafa = this.zza.get(i11);
            zzafd.zzc();
            zzxt zzv = zzws.zzv(zzafd.zza(), 3);
            zzz zzz = new zzz();
            zzz.zzH(zzafd.zzb());
            zzz.zzS(MimeTypes.APPLICATION_DVBSUBS);
            zzz.zzI(Collections.singletonList(zzafa.zzb));
            zzz.zzK(zzafa.zza);
            zzv.zzk(zzz.zzY());
            this.zzb[i11] = zzv;
        }
    }

    public final void zzc() {
        if (this.zzc) {
            if (this.zzf != C.TIME_UNSET) {
                for (zzxt zzs : this.zzb) {
                    zzs.zzs(this.zzf, 1, this.zze, 0, (zzxs) null);
                }
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j11, int i11) {
        if ((i11 & 4) != 0) {
            this.zzc = true;
            if (j11 != C.TIME_UNSET) {
                this.zzf = j11;
            }
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = C.TIME_UNSET;
    }
}
