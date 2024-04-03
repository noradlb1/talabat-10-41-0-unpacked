package com.instabug.library.tracking;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.utils.memory.a;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.j;
import com.instabug.library.util.threading.PoolProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import md.b;

public class g implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f51924a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f51925b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Set f51926c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f51927d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Map f51928e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map f51929f = new HashMap();

    private void a(Activity activity) {
        if ((activity instanceof AppCompatActivity) && !(activity instanceof _InstabugActivity)) {
            h hVar = new h();
            ((AppCompatActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(hVar, true);
            this.f51928e.put(Integer.valueOf(activity.hashCode()), hVar);
        }
    }

    private void c(Activity activity) {
        Window window = activity.getWindow();
        Window.Callback callback = window.getCallback();
        if (!(callback instanceof o)) {
            window.setCallback(new o(callback));
        }
    }

    private void d(Activity activity) {
        Window.Callback a11;
        Window.Callback callback = activity.getWindow().getCallback();
        if ((callback instanceof o) && (a11 = ((o) callback).a()) != null) {
            activity.getWindow().setCallback(a11);
        }
    }

    private void e(Activity activity) {
        if (activity != null && InstabugCore.isFeatureAvailable(Feature.REPRO_STEPS)) {
            j jVar = (j) this.f51929f.get(Integer.valueOf(activity.hashCode()));
            if (jVar != null) {
                jVar.a();
            }
            this.f51929f.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    @VisibleForTesting
    public void h(Activity activity) {
        if (activity != null && InstabugCore.isFeatureAvailable(Feature.REPRO_STEPS)) {
            this.f51929f.put(Integer.valueOf(activity.hashCode()), new j(activity, new f(this)));
        }
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if (!(activity instanceof _InstabugActivity)) {
            Locale locale = Locale.getDefault();
            InstabugSDKLogger.d("IBG-Core", "Setting app locale to " + locale.toString());
            SettingsManager.getInstance().setAppLocale(locale);
        }
        this.f51926c.add(activity.getClass().getSimpleName());
        InstabugInternalTrackingDelegate.getInstance().a(activity);
        a(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f51926c.remove(activity.getClass().getSimpleName());
        if (this.f51926c.isEmpty()) {
            InstabugSDKLogger.v("IBG-Core", "app is getting terminated, clearing user event logs");
            InstabugUserEventLogger.getInstance().clearAll();
        }
        InstabugInternalTrackingDelegate.getInstance().b(activity);
        if ((activity instanceof AppCompatActivity) && !(activity instanceof _InstabugActivity)) {
            h hVar = (h) this.f51928e.get(Integer.valueOf(activity.hashCode()));
            if (hVar != null) {
                ((AppCompatActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(hVar);
            }
            this.f51928e.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public void onActivityPaused(@NonNull Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().c(activity);
        d(activity);
        e(activity);
    }

    public void onActivityResumed(@NonNull Activity activity) {
        c(activity);
        h(activity);
        PoolProvider.postIOTask(new e(this, activity));
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        InstabugSDKLogger.d("IBG-Core", activity.getClass().getSimpleName() + " SaveInstanceState");
    }

    public void onActivityStarted(@NonNull Activity activity) {
        CoreServiceLocator.getScreenOffHandler().c();
        InstabugInternalTrackingDelegate.getInstance().e(activity);
    }

    public void onActivityStopped(@NonNull Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().f(activity);
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.f51924a = true;
        InstabugInternalTrackingDelegate.getInstance().g(configuration);
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i11) {
        if (i11 == 10) {
            a.b();
        } else if (i11 == 20) {
            SettingsManager.getInstance().setInBackground(true);
            PoolProvider.postIOTask(new md.a());
            if (this.f51927d) {
                Instabug.resumeSdk();
                this.f51927d = false;
                return;
            }
            PoolProvider.postIOTask(new b());
        }
    }
}
