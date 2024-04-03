package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zzbu implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ zzbv zza;

    public zzbu(zzbv zzbv) {
        this.zza = zzbv;
    }

    public final void onBackgroundStateChanged(boolean z11) {
        if (z11) {
            this.zza.zzc = true;
            this.zza.zzc();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzg()) {
            this.zza.zzb.zzc();
        }
    }
}
