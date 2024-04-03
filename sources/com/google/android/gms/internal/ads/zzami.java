package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzami implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    private boolean zzc = false;

    public zzami(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzama(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzamg(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzamd(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzamc(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzamf(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzamb(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzame(this, activity));
    }

    public final void zza(zzamh zzamh) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzamh.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
