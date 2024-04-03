package com.deliveryhero.performance.core.appstartup;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import r5.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/performance/core/appstartup/AppStartUpDetectorImpl;", "", "application", "Landroid/app/Application;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "traces", "", "", "(Landroid/app/Application;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;Ljava/util/List;)V", "firstPostEnqueued", "", "cancelTraces", "", "isForegroundProcess", "start", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppStartUpDetectorImpl {
    /* access modifiers changed from: private */
    @NotNull
    public final Application application;
    /* access modifiers changed from: private */
    public boolean firstPostEnqueued = true;
    @NotNull
    private final PerformanceTrackingManager performanceTrackingManager;
    @NotNull
    private final List<String> traces;

    public AppStartUpDetectorImpl(@NotNull Application application2, @NotNull PerformanceTrackingManager performanceTrackingManager2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(list, "traces");
        this.application = application2;
        this.performanceTrackingManager = performanceTrackingManager2;
        this.traces = list;
    }

    /* access modifiers changed from: private */
    public final void cancelTraces() {
        for (String cancelTrace : this.traces) {
            this.performanceTrackingManager.cancelTrace(cancelTrace);
        }
    }

    private final boolean isForegroundProcess() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        if (runningAppProcessInfo.importance == 100) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-1  reason: not valid java name */
    public static final void m8236start$lambda1(AppStartUpDetectorImpl appStartUpDetectorImpl) {
        Intrinsics.checkNotNullParameter(appStartUpDetectorImpl, "this$0");
        appStartUpDetectorImpl.firstPostEnqueued = false;
    }

    @MainThread
    public final void start() {
        if (isForegroundProcess()) {
            for (String startTrace : this.traces) {
                this.performanceTrackingManager.startTrace(startTrace);
            }
            new Handler(Looper.getMainLooper()).post(new a(this));
            this.application.registerActivityLifecycleCallbacks(new AppStartUpDetectorImpl$start$3(this));
        }
    }
}
