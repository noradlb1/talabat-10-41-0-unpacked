package com.talabat.core.observabilityNew.data.di;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManagerImpl;
import com.deliveryhero.performance.firebase.FirebasePerformanceProvider;
import com.deliveryhero.performance.firebase.FirebasePerformanceTracker;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.observabilityNew.performance.FirebasePerformanceProviderInitializer;
import com.talabat.observabilityNew.performance.PerformanceAttributesProvider;
import com.talabat.observabilityNew.performance.PerformanceTracker;
import com.talabat.observabilityNew.performance.PerformanceTrackingInitializer;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/observabilityNew/data/di/PerformanceTrackerModule;", "", "()V", "firebasePerformanceInitializer", "Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;", "firebasePerformanceProviderInitializer", "Lcom/talabat/observabilityNew/performance/FirebasePerformanceProviderInitializer;", "performanceAttributesProvider", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "Lcom/talabat/observabilityNew/performance/PerformanceAttributesProvider;", "performanceProvider", "Lcom/deliveryhero/performance/firebase/FirebasePerformanceTracker;", "performanceTracker", "Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "Lcom/talabat/observabilityNew/performance/PerformanceTracker;", "performanceTrackerManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "attributesProvider", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class PerformanceTrackerModule {
    @NotNull
    public static final PerformanceTrackerModule INSTANCE = new PerformanceTrackerModule();

    private PerformanceTrackerModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final PerformanceTrackingInitializer firebasePerformanceInitializer(@NotNull FirebasePerformanceProviderInitializer firebasePerformanceProviderInitializer) {
        Intrinsics.checkNotNullParameter(firebasePerformanceProviderInitializer, "firebasePerformanceProviderInitializer");
        return firebasePerformanceProviderInitializer;
    }

    @NotNull
    @Reusable
    @Provides
    public final PerformanceTrackingAttributesProvider performanceAttributesProvider(@NotNull PerformanceAttributesProvider performanceAttributesProvider) {
        Intrinsics.checkNotNullParameter(performanceAttributesProvider, "performanceAttributesProvider");
        return performanceAttributesProvider;
    }

    @NotNull
    @Reusable
    @Provides
    public final FirebasePerformanceTracker performanceProvider() {
        return FirebasePerformanceProvider.getInstance();
    }

    @NotNull
    @Reusable
    @Provides
    public final IPerformanceTracker performanceTracker(@NotNull PerformanceTracker performanceTracker) {
        Intrinsics.checkNotNullParameter(performanceTracker, "performanceTracker");
        return performanceTracker;
    }

    @NotNull
    @Reusable
    @Provides
    public final PerformanceTrackingManager performanceTrackerManager(@NotNull PerformanceTrackingAttributesProvider performanceTrackingAttributesProvider) {
        Intrinsics.checkNotNullParameter(performanceTrackingAttributesProvider, "attributesProvider");
        return new PerformanceTrackingManagerImpl(CollectionsKt__CollectionsJVMKt.listOf(FirebasePerformanceProvider.getInstance()), performanceTrackingAttributesProvider, new PerformanceTrackingManager.Params(true));
    }
}
