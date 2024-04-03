package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzayg implements zzaym {
    final /* synthetic */ Activity zza;

    public zzayg(zzayn zzayn, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
