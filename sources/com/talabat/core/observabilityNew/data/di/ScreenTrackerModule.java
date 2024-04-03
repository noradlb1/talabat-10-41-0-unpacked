package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.observabilityNew.screentracker.ScreenTracker;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/ScreenTrackerModule;", "", "()V", "performanceTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "Lcom/talabat/observabilityNew/screentracker/ScreenTracker;", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ScreenTrackerModule {
    @NotNull
    public static final ScreenTrackerModule INSTANCE = new ScreenTrackerModule();

    private ScreenTrackerModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final IScreenTracker performanceTracker(@NotNull ScreenTracker screenTracker) {
        Intrinsics.checkNotNullParameter(screenTracker, "performanceTracker");
        return screenTracker;
    }
}
