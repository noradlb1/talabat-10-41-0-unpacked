package com.talabat.feature.tpro.presentation.model.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProPlanDisplayModelMapper_Factory implements Factory<TProPlanDisplayModelMapper> {
    private final Provider<TProMapperUtility> tProMapperProvider;

    public TProPlanDisplayModelMapper_Factory(Provider<TProMapperUtility> provider) {
        this.tProMapperProvider = provider;
    }

    public static TProPlanDisplayModelMapper_Factory create(Provider<TProMapperUtility> provider) {
        return new TProPlanDisplayModelMapper_Factory(provider);
    }

    public static TProPlanDisplayModelMapper newInstance(TProMapperUtility tProMapperUtility) {
        return new TProPlanDisplayModelMapper(tProMapperUtility);
    }

    public TProPlanDisplayModelMapper get() {
        return newInstance(this.tProMapperProvider.get());
    }
}
