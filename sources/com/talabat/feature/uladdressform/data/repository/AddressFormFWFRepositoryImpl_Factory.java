package com.talabat.feature.uladdressform.data.repository;

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
public final class AddressFormFWFRepositoryImpl_Factory implements Factory<AddressFormFWFRepositoryImpl> {
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public AddressFormFWFRepositoryImpl_Factory(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.experimentProvider = provider;
        this.featureFlagProvider = provider2;
    }

    public static AddressFormFWFRepositoryImpl_Factory create(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new AddressFormFWFRepositoryImpl_Factory(provider, provider2);
    }

    public static AddressFormFWFRepositoryImpl newInstance(ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AddressFormFWFRepositoryImpl(iTalabatExperiment, iTalabatFeatureFlag);
    }

    public AddressFormFWFRepositoryImpl get() {
        return newInstance(this.experimentProvider.get(), this.featureFlagProvider.get());
    }
}
