package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzby;
import com.google.android.gms.internal.gtm.zzcg;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcw;
import com.google.android.gms.internal.gtm.zzcy;
import com.google.android.gms.internal.gtm.zzda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@VisibleForTesting
public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzrp = new ArrayList();
    private boolean zzrq;
    private Set<zza> zzrr = new HashSet();
    private boolean zzrs;
    private boolean zzrt;
    private volatile boolean zzru;
    private boolean zzrv;

    public interface zza {
        void zzc(Activity activity);

        void zzd(Activity activity);
    }

    @TargetApi(14)
    public class zzb implements Application.ActivityLifecycleCallbacks {
        public zzb() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zza(activity);
        }

        public final void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzb(activity);
        }
    }

    @VisibleForTesting
    public GoogleAnalytics(zzap zzap) {
        super(zzap);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics getInstance(Context context) {
        return zzap.zzc(context).zzde();
    }

    public static void zzah() {
        synchronized (GoogleAnalytics.class) {
            List<Runnable> list = zzrp;
            if (list != null) {
                for (Runnable run : list) {
                    run.run();
                }
                zzrp = null;
            }
        }
    }

    public final void dispatchLocalHits() {
        zzab().zzcs().zzci();
    }

    @TargetApi(14)
    public final void enableAutoActivityReports(Application application) {
        if (!this.zzrs) {
            application.registerActivityLifecycleCallbacks(new zzb());
            this.zzrs = true;
        }
    }

    public final boolean getAppOptOut() {
        return this.zzru;
    }

    @Deprecated
    public final Logger getLogger() {
        return zzch.getLogger();
    }

    public final boolean isDryRunEnabled() {
        return this.zzrt;
    }

    public final boolean isInitialized() {
        return this.zzrq;
    }

    public final Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzab(), str, (zzcg) null);
            tracker.zzag();
        }
        return tracker;
    }

    public final void reportActivityStart(Activity activity) {
        if (!this.zzrs) {
            zza(activity);
        }
    }

    public final void reportActivityStop(Activity activity) {
        if (!this.zzrs) {
            zzb(activity);
        }
    }

    public final void setAppOptOut(boolean z11) {
        this.zzru = z11;
        if (this.zzru) {
            zzab().zzcs().zzch();
        }
    }

    public final void setDryRun(boolean z11) {
        this.zzrt = z11;
    }

    public final void setLocalDispatchPeriod(int i11) {
        zzab().zzcs().setLocalDispatchPeriod(i11);
    }

    @Deprecated
    public final void setLogger(Logger logger) {
        zzch.setLogger(logger);
        if (!this.zzrv) {
            String str = zzby.zzzb.get();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 112);
            sb2.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            sb2.append(str);
            sb2.append(" DEBUG");
            Log.i(zzby.zzzb.get(), sb2.toString());
            this.zzrv = true;
        }
    }

    @VisibleForTesting
    public final void zza(Activity activity) {
        for (zza zzc : this.zzrr) {
            zzc.zzc(activity);
        }
    }

    public final void zzag() {
        zzda zzcu = zzab().zzcu();
        zzcu.zzgh();
        if (zzcu.zzgi()) {
            setDryRun(zzcu.zzgj());
        }
        zzcu.zzgh();
        this.zzrq = true;
    }

    @VisibleForTesting
    public final void zzb(Activity activity) {
        for (zza zzd : this.zzrr) {
            zzd.zzd(activity);
        }
    }

    public final void zza(zza zza2) {
        this.zzrr.add(zza2);
        Context context = zzab().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    public final void zzb(zza zza2) {
        this.zzrr.remove(zza2);
    }

    public final Tracker newTracker(int i11) {
        Tracker tracker;
        zzcy zzcy;
        synchronized (this) {
            tracker = new Tracker(zzab(), (String) null, (zzcg) null);
            if (i11 > 0 && (zzcy = (zzcy) new zzcw(zzab()).zzq(i11)) != null) {
                tracker.zza(zzcy);
            }
            tracker.zzag();
        }
        return tracker;
    }
}
