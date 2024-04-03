package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzayn implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    private boolean zzc = false;

    public zzayn(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzayf(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzayl(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzayi(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzayh(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzayk(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzayg(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzayj(this, activity));
    }

    public final void zza(zzaym zzaym) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzaym.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e11) {
            zzciz.zzh("Error while dispatching lifecycle callback.", e11);
        }
    }
}
