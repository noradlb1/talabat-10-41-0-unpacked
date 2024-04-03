package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

public final class zzbkp extends zzbjb {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzbkp(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    public final void zze() {
        this.zza.onVideoEnd();
    }

    public final void zzf(boolean z11) {
        this.zza.onVideoMute(z11);
    }

    public final void zzg() {
        this.zza.onVideoPause();
    }

    public final void zzh() {
        this.zza.onVideoPlay();
    }

    public final void zzi() {
        this.zza.onVideoStart();
    }
}
