package com.talabat.fluid.homescreen.data.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J,\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH\u0016J,\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH\u0016J,\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH\u0016J,\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/talabat/fluid/homescreen/data/impl/HomeScreenPerformanceObservabilityImpl;", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getPerseusClientId", "Lkotlin/Function0;", "", "getPerseusSessionId", "timestampProvider", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "Ljava/util/UUID;", "traceId", "getTraceId", "()Ljava/util/UUID;", "createTraceData", "", "level", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Level;", "generateTraceId", "", "isFeatureEnabled", "", "traceEnd", "eventName", "extraAttributes", "", "traceEvent", "traceStart", "trackEvent", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenPerformanceObservabilityImpl implements HomeScreenPerformanceObservability {
    @NotNull
    private final Function0<String> getPerseusClientId;
    @NotNull
    private final Function0<String> getPerseusSessionId;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final Function0<String> timestampProvider;
    @Nullable
    private UUID traceId;

    public HomeScreenPerformanceObservabilityImpl(@NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function0<String> function0, @NotNull Function0<String> function02, @NotNull Function0<String> function03) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function0, "getPerseusClientId");
        Intrinsics.checkNotNullParameter(function02, "getPerseusSessionId");
        Intrinsics.checkNotNullParameter(function03, "timestampProvider");
        this.observabilityManager = iObservabilityManager;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getPerseusClientId = function0;
        this.getPerseusSessionId = function02;
        this.timestampProvider = function03;
    }

    private final Map<String, String> createTraceData(HomeScreenPerformanceObservability.Level level) {
        String str;
        Pair[] pairArr = new Pair[5];
        UUID uuid = this.traceId;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("traceId", str);
        pairArr[1] = TuplesKt.to("traceTime", this.timestampProvider.invoke());
        pairArr[2] = TuplesKt.to("level", level.name());
        pairArr[3] = TuplesKt.to("perseusClientId", this.getPerseusClientId.invoke());
        pairArr[4] = TuplesKt.to("perseusSessionId", this.getPerseusSessionId.invoke());
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    private final boolean isFeatureEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(HomePageFeatureFlagsKeys.ENABLE_TRACE_LOGS, false);
    }

    private final void trackEvent(String str, HomeScreenPerformanceObservability.Level level, Map<String, String> map) {
        if (isFeatureEnabled()) {
            IObservabilityManager iObservabilityManager = this.observabilityManager;
            Map<String, String> createTraceData = createTraceData(level);
            createTraceData.putAll(map);
            Unit unit = Unit.INSTANCE;
            iObservabilityManager.trackEvent(str, "HomeScreenPerformanceObservability", createTraceData);
        }
    }

    public void generateTraceId() {
        this.traceId = UUID.randomUUID();
    }

    @Nullable
    public final UUID getTraceId() {
        return this.traceId;
    }

    public void traceEnd(@NotNull HomeScreenPerformanceObservability.Level level, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "extraAttributes");
        trackEvent(str + ".traceEnd", level, map);
    }

    public void traceEvent(@NotNull HomeScreenPerformanceObservability.Level level, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "extraAttributes");
        trackEvent(str, level, map);
    }

    public void traceStart(@NotNull HomeScreenPerformanceObservability.Level level, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "extraAttributes");
        trackEvent(str + ".traceStart", level, map);
    }
}
