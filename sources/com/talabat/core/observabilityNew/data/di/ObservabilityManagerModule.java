package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.observabilityNew.ObservabilityManager;
import com.talabat.observabilityNew.tracker.IObservabilityTracker;
import com.talabat.observabilityNew.tracker.impl.NewRelicObservabilityTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/ObservabilityManagerModule;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "Lcom/talabat/observabilityNew/ObservabilityManager;", "observabilityTracker", "Lcom/talabat/observabilityNew/tracker/IObservabilityTracker;", "newRelicObservabilityTracker", "Lcom/talabat/observabilityNew/tracker/impl/NewRelicObservabilityTracker;", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface ObservabilityManagerModule {
    @NotNull
    @Binds
    @Reusable
    IObservabilityManager observabilityManager(@NotNull ObservabilityManager observabilityManager);

    @NotNull
    @Binds
    @Reusable
    IObservabilityTracker observabilityTracker(@NotNull NewRelicObservabilityTracker newRelicObservabilityTracker);
}
