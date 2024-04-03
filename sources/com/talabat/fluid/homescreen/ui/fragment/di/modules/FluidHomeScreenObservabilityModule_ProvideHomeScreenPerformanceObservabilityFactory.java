package com.talabat.fluid.homescreen.ui.fragment.di.modules;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory implements Factory<HomeScreenPerformanceObservability> {
    private final FluidHomeScreenObservabilityModule module;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule, Provider<IObservabilityManager> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.module = fluidHomeScreenObservabilityModule;
        this.observabilityManagerProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory create(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule, Provider<IObservabilityManager> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory(fluidHomeScreenObservabilityModule, provider, provider2);
    }

    public static HomeScreenPerformanceObservability provideHomeScreenPerformanceObservability(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule, IObservabilityManager iObservabilityManager, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return (HomeScreenPerformanceObservability) Preconditions.checkNotNullFromProvides(fluidHomeScreenObservabilityModule.provideHomeScreenPerformanceObservability(iObservabilityManager, iTalabatFeatureFlag));
    }

    public HomeScreenPerformanceObservability get() {
        return provideHomeScreenPerformanceObservability(this.module, this.observabilityManagerProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
