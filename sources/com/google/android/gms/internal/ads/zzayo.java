package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

public final class zzayo extends zzbhq {
    private final AppEventListener zza;

    public zzayo(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final AppEventListener zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
