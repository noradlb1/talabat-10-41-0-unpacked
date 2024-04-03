package com.deliveryhero.performance.core.appstartup;

import android.app.Application;
import androidx.annotation.MainThread;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/performance/core/appstartup/AppStartUpDetector;", "", "()V", "listenToAppStartUp", "", "application", "Landroid/app/Application;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "traces", "", "", "(Landroid/app/Application;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;[Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppStartUpDetector {
    @NotNull
    public static final AppStartUpDetector INSTANCE = new AppStartUpDetector();

    private AppStartUpDetector() {
    }

    @JvmStatic
    @MainThread
    public static final void listenToAppStartUp(@NotNull Application application, @NotNull PerformanceTrackingManager performanceTrackingManager, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(performanceTrackingManager, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(strArr, "traces");
        new AppStartUpDetectorImpl(application, performanceTrackingManager, ArraysKt___ArraysKt.toList((T[]) strArr)).start();
    }
}
