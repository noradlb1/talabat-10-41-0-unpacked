package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class zzacu implements zzwp {
    public static final zzww zza = zzact.zza;
    private zzws zzb;
    private zzadc zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zze(zzwq zzwq) throws IOException {
        zzacw zzacw = new zzacw();
        if (zzacw.zzb(zzwq, true) && (zzacw.zza & 2) == 2) {
            int min = Math.min(zzacw.zze, 8);
            zzfd zzfd = new zzfd(min);
            ((zzwk) zzwq).zzm(zzfd.zzH(), 0, min, false);
            zzfd.zzF(0);
            if (zzfd.zza() >= 5 && zzfd.zzk() == 127 && zzfd.zzs() == 1179402563) {
                this.zzc = new zzacs();
            } else {
                zzfd.zzF(0);
                try {
                    if (zzxy.zzc(1, zzfd, true)) {
                        this.zzc = new zzade();
                    }
                } catch (zzbj unused) {
                }
                zzfd.zzF(0);
                if (zzacy.zzd(zzfd)) {
                    this.zzc = new zzacy();
                }
            }
            return true;
        }
        return false;
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        zzdy.zzb(this.zzb);
        if (this.zzc == null) {
            if (zze(zzwq)) {
                zzwq.zzj();
            } else {
                throw zzbj.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zzxt zzv = this.zzb.zzv(0, 1);
            this.zzb.zzB();
            this.zzc.zzh(this.zzb, zzv);
            this.zzd = true;
        }
        return this.zzc.zze(zzwq, zzxm);
    }

    public final void zzb(zzws zzws) {
        this.zzb = zzws;
    }

    public final void zzc(long j11, long j12) {
        zzadc zzadc = this.zzc;
        if (zzadc != null) {
            zzadc.zzj(j11, j12);
        }
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        try {
            return zze(zzwq);
        } catch (zzbj unused) {
            return false;
        }
    }
}
