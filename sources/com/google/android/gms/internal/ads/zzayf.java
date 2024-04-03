package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzayf implements zzaym {
    final /* synthetic */ Activity zza;
    final /* synthetic */ Bundle zzb;

    public zzayf(zzayn zzayn, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.zza, this.zzb);
    }
}
