package com.deliveryhero.performance.core.screentracker;

import android.app.Application;
import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/performance/core/screentracker/ScreenPerfTrackerActivityLifecycleProvider;", "", "()V", "getActivityLifecycleInstance", "Landroid/app/Application$ActivityLifecycleCallbacks;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenPerfTrackerActivityLifecycleProvider {
    @NotNull
    public static final ScreenPerfTrackerActivityLifecycleProvider INSTANCE = new ScreenPerfTrackerActivityLifecycleProvider();

    private ScreenPerfTrackerActivityLifecycleProvider() {
    }

    @NotNull
    public final Application.ActivityLifecycleCallbacks getActivityLifecycleInstance() {
        if (Build.VERSION.SDK_INT >= 29) {
            return new ActivityLifecyclePerformanceTrackerApi29();
        }
        return new ActivityLifecyclePerformanceTracker();
    }
}
