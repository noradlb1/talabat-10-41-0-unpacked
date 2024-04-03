package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzayj implements zzaym {
    final /* synthetic */ Activity zza;

    public zzayj(zzayn zzayn, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.zza);
    }
}
