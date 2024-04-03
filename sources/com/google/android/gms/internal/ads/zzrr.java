package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzrr extends zzcd {
    private static final Object zzc = new Object();
    private static final zzaz zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    @Nullable
    private final zzaz zzh;
    @Nullable
    private final zzas zzi;

    static {
        zzaf zzaf = new zzaf();
        zzaf.zza("SinglePeriodTimeline");
        zzaf.zzb(Uri.EMPTY);
        zzd = zzaf.zzc();
    }

    public zzrr(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, @Nullable Object obj, zzaz zzaz, @Nullable zzas zzas) {
        this.zze = j14;
        this.zzf = j15;
        this.zzg = z11;
        this.zzh = zzaz;
        this.zzi = zzas;
    }

    public final int zza(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzca zzd(int i11, zzca zzca, boolean z11) {
        Object obj;
        zzdy.zza(i11, 0, 1);
        if (z11) {
            obj = zzc;
        } else {
            obj = null;
        }
        zzca.zzj((Object) null, obj, 0, this.zze, 0, zzd.zza, false);
        return zzca;
    }

    public final zzcc zze(int i11, zzcc zzcc, long j11) {
        zzdy.zza(i11, 0, 1);
        zzcc.zza(zzcc.zza, this.zzh, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.zzg, false, this.zzi, 0, this.zzf, 0, 0, 0);
        return zzcc;
    }

    public final Object zzf(int i11) {
        zzdy.zza(i11, 0, 1);
        return zzc;
    }
}
