package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzamf implements zzamh {
    final /* synthetic */ Activity zza;
    final /* synthetic */ Bundle zzb;

    public zzamf(zzami zzami, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.zza, this.zzb);
    }
}
