package com.talabat.feature.subscriptions.data;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsFeatureFlagsRepositoryImpl_Factory implements Factory<SubscriptionsFeatureFlagsRepositoryImpl> {
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public SubscriptionsFeatureFlagsRepositoryImpl_Factory(Provider<ITalabatFeatureFlag> provider, Provider<ITalabatExperiment> provider2) {
        this.featureFlagProvider = provider;
        this.experimentProvider = provider2;
    }

    public static SubscriptionsFeatureFlagsRepositoryImpl_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<ITalabatExperiment> provider2) {
        return new SubscriptionsFeatureFlagsRepositoryImpl_Factory(provider, provider2);
    }

    public static SubscriptionsFeatureFlagsRepositoryImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment) {
        return new SubscriptionsFeatureFlagsRepositoryImpl(iTalabatFeatureFlag, iTalabatExperiment);
    }

    public SubscriptionsFeatureFlagsRepositoryImpl get() {
        return newInstance(this.featureFlagProvider.get(), this.experimentProvider.get());
    }
}
