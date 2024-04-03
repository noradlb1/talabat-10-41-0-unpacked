package com.talabat.observabilityNew.screentracker;

import com.deliveryhero.performance.core.screentracker.ScreenPerformanceParams;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"com/talabat/observabilityNew/screentracker/ScreenTracker$createScreenPerformanceParams$1", "Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceParams;", "screenName", "", "getScreenName", "()Ljava/lang/String;", "screenType", "getScreenType", "trace", "getTrace", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTracker$createScreenPerformanceParams$1 implements ScreenPerformanceParams {
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String trace;

    public ScreenTracker$createScreenPerformanceParams$1(ScreenTrackerParams screenTrackerParams) {
        this.screenName = screenTrackerParams.getScreenName();
        this.screenType = screenTrackerParams.getScreenType();
        this.trace = screenTrackerParams.getTrace();
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public String getTrace() {
        return this.trace;
    }
}
