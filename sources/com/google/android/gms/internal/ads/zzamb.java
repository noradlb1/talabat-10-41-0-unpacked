package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzamb implements zzamh {
    final /* synthetic */ Activity zza;

    public zzamb(zzami zzami, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}
