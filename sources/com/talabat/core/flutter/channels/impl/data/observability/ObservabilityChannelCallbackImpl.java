package com.talabat.core.flutter.channels.impl.data.observability;

import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J,\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0013H\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J$\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/observability/ObservabilityChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "performanceTracker", "Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "endTracing", "", "traceId", "", "screenName", "screenType", "observe", "eventName", "featureName", "attributes", "", "startTracing", "trackUnexpectedScenario", "explanation", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityChannelCallbackImpl implements ObservabilityChannelCallback {
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final IPerformanceTracker performanceTracker;
    @NotNull
    private final IScreenTracker screenTracker;

    @Inject
    public ObservabilityChannelCallbackImpl(@NotNull IPerformanceTracker iPerformanceTracker, @NotNull IScreenTracker iScreenTracker, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iPerformanceTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(iScreenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.performanceTracker = iPerformanceTracker;
        this.screenTracker = iScreenTracker;
        this.observabilityManager = iObservabilityManager;
        iPerformanceTracker.initialize();
        iScreenTracker.initialize();
    }

    public void endTracing(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        this.screenTracker.stopTrace(new ScreenTrackerParams(str, str2, str3));
    }

    public void observe(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.observabilityManager.track(str, str2, map);
    }

    public void startTracing(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        this.screenTracker.startTrace(new ScreenTrackerParams(str, str2, str3));
    }

    public void trackUnexpectedScenario(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str, "explanation");
        this.observabilityManager.trackUnExpectedScenario(str, map);
    }
}
