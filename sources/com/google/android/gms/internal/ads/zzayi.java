package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzayi implements zzaym {
    final /* synthetic */ Activity zza;

    public zzayi(zzayn zzayn, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.zza);
    }
}
