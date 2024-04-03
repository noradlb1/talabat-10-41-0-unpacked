package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzamg implements zzamh {
    final /* synthetic */ Activity zza;

    public zzamg(zzami zzami, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.zza);
    }
}
