package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.observabilityNew.domain.ITimeTracker;
import com.talabat.observabilityNew.tracker.TimeTrackerImplementation;
import com.talabat.observabilityNew.tracker.TimeTrackingData;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/TimeTrackerModule;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/ITimeTracker;", "timeTracker", "Lcom/talabat/observabilityNew/tracker/TimeTrackerImplementation;", "Companion", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface TimeTrackerModule {
    @NotNull
    public static final Companion Companion = Companion.f55959a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/TimeTrackerModule$Companion;", "", "()V", "timeCachesHashMap", "Ljava/util/HashMap;", "Lcom/talabat/observabilityNew/tracker/TimeTrackingData;", "Lkotlin/collections/HashMap;", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55959a = new Companion();

        private Companion() {
        }

        @TimeCacheMap
        @NotNull
        @Reusable
        @Provides
        public final HashMap<Object, TimeTrackingData> timeCachesHashMap() {
            return new HashMap<>();
        }
    }

    @NotNull
    @Binds
    @Reusable
    ITimeTracker observabilityManager(@NotNull TimeTrackerImplementation timeTrackerImplementation);
}
