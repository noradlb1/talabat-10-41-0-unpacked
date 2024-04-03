package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class zzdmt extends zzdkb<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzb;

    public zzdmt(Set<zzdlw<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void zza() {
        zzo(zzdmp.zza);
    }

    public final void zzb() {
        zzo(zzdmq.zza);
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzo(zzdms.zza);
            this.zzb = true;
        }
        zzo(zzdmr.zza);
    }

    public final synchronized void zzd() {
        zzo(zzdms.zza);
        this.zzb = true;
    }
}
