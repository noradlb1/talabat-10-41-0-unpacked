package com.talabat.feature.foodcart2.data.datasources;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.engine.EngineProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FoodCartFlutterDataSourceImpl_Factory implements Factory<FoodCartFlutterDataSourceImpl> {
    private final Provider<EngineProvider> engineProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<IObservabilityManager> talabatObservabilityProvider;

    public FoodCartFlutterDataSourceImpl_Factory(Provider<EngineProvider> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<IObservabilityManager> provider4) {
        this.engineProvider = provider;
        this.talabatExperimentProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.talabatObservabilityProvider = provider4;
    }

    public static FoodCartFlutterDataSourceImpl_Factory create(Provider<EngineProvider> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<IObservabilityManager> provider4) {
        return new FoodCartFlutterDataSourceImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static FoodCartFlutterDataSourceImpl newInstance(EngineProvider engineProvider2, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager) {
        return new FoodCartFlutterDataSourceImpl(engineProvider2, iTalabatExperiment, iTalabatFeatureFlag, iObservabilityManager);
    }

    public FoodCartFlutterDataSourceImpl get() {
        return newInstance(this.engineProvider.get(), this.talabatExperimentProvider.get(), this.talabatFeatureFlagProvider.get(), this.talabatObservabilityProvider.get());
    }
}
