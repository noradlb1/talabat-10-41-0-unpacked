package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

public final class zzfeo {
    private final zzfdn zza;
    private final zzfdq zzb;
    private final zzehh zzc;
    private final zzfjs zzd;

    @VisibleForTesting
    public zzfeo(zzehh zzehh, zzfjs zzfjs, zzfdn zzfdn, zzfdq zzfdq) {
        this.zza = zzfdn;
        this.zzb = zzfdq;
        this.zzc = zzehh;
        this.zzd = zzfjs;
    }

    public final void zza(List<String> list) {
        for (String zzb2 : list) {
            zzb(zzb2, 2);
        }
    }

    public final void zzb(String str, int i11) {
        if (!this.zza.zzag) {
            this.zzd.zzb(str);
            return;
        }
        this.zzc.zzd(new zzehj(zzt.zzA().currentTimeMillis(), this.zzb.zzb, str, i11));
    }

    public final void zzc(List<String> list, int i11) {
        for (String zzb2 : list) {
            zzb(zzb2, i11);
        }
    }
}
