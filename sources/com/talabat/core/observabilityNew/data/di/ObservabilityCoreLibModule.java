package com.talabat.core.observabilityNew.data.di;

import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/ObservabilityCoreLibModule;", "", "()V", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {AppLaunchTrackingManagerModule.class, ObservabilityManagerModule.class, PerformanceTrackerModule.class, ScreenTrackerModule.class, TimeTrackerModule.class})
public final class ObservabilityCoreLibModule {
    @NotNull
    public static final ObservabilityCoreLibModule INSTANCE = new ObservabilityCoreLibModule();

    private ObservabilityCoreLibModule() {
    }
}
