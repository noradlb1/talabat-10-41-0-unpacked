package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
final class zzays implements Application.ActivityLifecycleCallbacks {
    @Nullable
    private Activity zza;
    private Context zzb;
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public boolean zzd = true;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final List<zzayt> zzf = new ArrayList();
    @GuardedBy("lock")
    private final List<zzazh> zzg = new ArrayList();
    private Runnable zzh;
    private boolean zzi = false;
    private long zzj;

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator<zzazh> it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza()) {
                            it.remove();
                        }
                    } catch (Exception e11) {
                        zzt.zzo().zzs(e11, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzciz.zzh("", e11);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzazh zzb2 : this.zzg) {
                try {
                    zzb2.zzb();
                } catch (Exception e11) {
                    zzt.zzo().zzs(e11, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzciz.zzh("", e11);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(runnable);
        }
        zzfpj zzfpj = com.google.android.gms.ads.internal.util.zzt.zza;
        zzayr zzayr = new zzayr(this);
        this.zzh = zzayr;
        zzfpj.postDelayed(zzayr, this.zzj);
    }

    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z11 = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            for (zzazh zzc2 : this.zzg) {
                try {
                    zzc2.zzc();
                } catch (Exception e11) {
                    zzt.zzo().zzs(e11, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzciz.zzh("", e11);
                }
            }
            if (z11) {
                for (zzayt zza2 : this.zzf) {
                    try {
                        zza2.zza(true);
                    } catch (Exception e12) {
                        zzciz.zzh("", e12);
                    }
                }
            } else {
                zzciz.zze("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    @Nullable
    public final Activity zza() {
        return this.zza;
    }

    @Nullable
    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzayt zzayt) {
        synchronized (this.zzc) {
            this.zzf.add(zzayt);
        }
    }

    public final void zzg(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) zzbgq.zzc().zzb(zzblj.zzaG)).longValue();
            this.zzi = true;
        }
    }

    public final void zzh(zzayt zzayt) {
        synchronized (this.zzc) {
            this.zzf.remove(zzayt);
        }
    }
}
