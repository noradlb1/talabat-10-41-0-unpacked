package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzamc implements zzamh {
    final /* synthetic */ Activity zza;

    public zzamc(zzami zzami, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.zza);
    }
}
