package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.IOException;

public class zzwg {
    protected final zzwa zza;
    protected final zzwf zzb;
    @Nullable
    protected zzwc zzc;
    private final int zzd;

    public zzwg(zzwd zzwd, zzwf zzwf, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.zzb = zzwf;
        this.zzd = i11;
        this.zza = new zzwa(zzwd, j11, 0, j13, j14, j15, j16);
    }

    public static final int zzf(zzwq zzwq, long j11, zzxm zzxm) {
        if (j11 == zzwq.zze()) {
            return 0;
        }
        zzxm.zza = j11;
        return 1;
    }

    public static final boolean zzg(zzwq zzwq, long j11) throws IOException {
        long zze = j11 - zzwq.zze();
        if (zze < 0 || zze > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzwk) zzwq).zzo((int) zze, false);
        return true;
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        while (true) {
            zzwc zzwc = this.zzc;
            zzdy.zzb(zzwc);
            long zzb2 = zzwc.zzf;
            long zza2 = zzwc.zzg;
            long zzc2 = zzwc.zzh;
            if (zza2 - zzb2 <= ((long) this.zzd)) {
                zzc(false, zzb2);
                return zzf(zzwq, zzb2, zzxm);
            } else if (!zzg(zzwq, zzc2)) {
                return zzf(zzwq, zzc2, zzxm);
            } else {
                zzwq.zzj();
                zzwe zza3 = this.zzb.zza(zzwq, zzwc.zzb);
                int zza4 = zza3.zzb;
                if (zza4 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzwq, zzc2, zzxm);
                } else if (zza4 == -2) {
                    zzwc.zzh(zzwc, zza3.zzc, zza3.zzd);
                } else if (zza4 != -1) {
                    zzg(zzwq, zza3.zzd);
                    zzc(true, zza3.zzd);
                    return zzf(zzwq, zza3.zzd, zzxm);
                } else {
                    zzwc.zzg(zzwc, zza3.zzc, zza3.zzd);
                }
            }
        }
    }

    public final zzxp zzb() {
        return this.zza;
    }

    public final void zzc(boolean z11, long j11) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j11) {
        long j12 = j11;
        zzwc zzwc = this.zzc;
        if (zzwc == null || zzwc.zza != j12) {
            zzwc zzwc2 = r1;
            zzwc zzwc3 = new zzwc(j11, this.zza.zzf(j12), 0, this.zza.zzc, this.zza.zzd, this.zza.zze, this.zza.zzf);
            this.zzc = zzwc2;
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
