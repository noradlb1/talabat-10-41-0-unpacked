package com.talabat.feature.tpro.presentation.model.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProMultiPlanDisplayModelMapper_Factory implements Factory<TProMultiPlanDisplayModelMapper> {
    private final Provider<TProMapperUtility> tProMapperProvider;

    public TProMultiPlanDisplayModelMapper_Factory(Provider<TProMapperUtility> provider) {
        this.tProMapperProvider = provider;
    }

    public static TProMultiPlanDisplayModelMapper_Factory create(Provider<TProMapperUtility> provider) {
        return new TProMultiPlanDisplayModelMapper_Factory(provider);
    }

    public static TProMultiPlanDisplayModelMapper newInstance(TProMapperUtility tProMapperUtility) {
        return new TProMultiPlanDisplayModelMapper(tProMapperUtility);
    }

    public TProMultiPlanDisplayModelMapper get() {
        return newInstance(this.tProMapperProvider.get());
    }
}
