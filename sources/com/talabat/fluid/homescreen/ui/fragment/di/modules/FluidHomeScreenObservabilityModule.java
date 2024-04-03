package com.talabat.fluid.homescreen.ui.fragment.di.modules;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.data.impl.HomeScreenPerformanceObservabilityImplKt;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/di/modules/FluidHomeScreenObservabilityModule;", "", "()V", "provideHomeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FluidHomeScreenObservabilityModule {
    @NotNull
    @Provides
    public final HomeScreenPerformanceObservability provideHomeScreenPerformanceObservability(@NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        return HomeScreenPerformanceObservabilityImplKt.retrieveInstance(HomeScreenPerformanceObservability.Companion, iObservabilityManager, iTalabatFeatureFlag, FluidHomeScreenObservabilityModule$provideHomeScreenPerformanceObservability$1.INSTANCE, FluidHomeScreenObservabilityModule$provideHomeScreenPerformanceObservability$2.INSTANCE, FluidHomeScreenObservabilityModule$provideHomeScreenPerformanceObservability$3.INSTANCE);
    }
}
