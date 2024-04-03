package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzama implements zzamh {
    final /* synthetic */ Activity zza;
    final /* synthetic */ Bundle zzb;

    public zzama(zzami zzami, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.zza, this.zzb);
    }
}
