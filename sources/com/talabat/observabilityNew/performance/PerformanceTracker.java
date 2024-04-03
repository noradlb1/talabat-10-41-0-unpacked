package com.talabat.observabilityNew.performance;

import android.app.Application;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.appstartup.AppStartUpDetector;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J!\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0013\"\u00020\fH\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/observabilityNew/performance/PerformanceTracker;", "Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "application", "Landroid/app/Application;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "performanceTrackingInitializer", "Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;", "(Landroid/app/Application;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;)V", "addAppFlowTraceAttribute", "", "traceName", "", "attrValue", "addTraceCounter", "traceCounterName", "initialize", "listenToAppStartUp", "traces", "", "([Ljava/lang/String;)V", "startTrace", "stopTrace", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerformanceTracker implements IPerformanceTracker {
    @NotNull
    private final Application application;
    @NotNull
    private final PerformanceTrackingInitializer performanceTrackingInitializer;
    @NotNull
    private final PerformanceTrackingManager performanceTrackingManager;

    @Inject
    public PerformanceTracker(@NotNull Application application2, @NotNull PerformanceTrackingManager performanceTrackingManager2, @NotNull PerformanceTrackingInitializer performanceTrackingInitializer2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(performanceTrackingInitializer2, "performanceTrackingInitializer");
        this.application = application2;
        this.performanceTrackingManager = performanceTrackingManager2;
        this.performanceTrackingInitializer = performanceTrackingInitializer2;
    }

    public void addAppFlowTraceAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "attrValue");
        this.performanceTrackingManager.addTraceAttribute(str, AppStartFlow.INSTANCE.getName(), str2);
    }

    public void addTraceCounter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "traceCounterName");
        this.performanceTrackingManager.addTraceCounter(str, str2);
    }

    public void initialize() {
        this.performanceTrackingInitializer.initialize();
    }

    public void listenToAppStartUp(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "traces");
        AppStartUpDetector.listenToAppStartUp(this.application, this.performanceTrackingManager, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.performanceTrackingManager.startTrace(str);
    }

    public void stopTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.performanceTrackingManager.stopTrace(str);
    }
}
