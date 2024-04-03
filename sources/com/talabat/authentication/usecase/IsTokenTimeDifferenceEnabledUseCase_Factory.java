package com.talabat.authentication.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsTokenTimeDifferenceEnabledUseCase_Factory implements Factory<IsTokenTimeDifferenceEnabledUseCase> {
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public IsTokenTimeDifferenceEnabledUseCase_Factory(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagProvider = provider;
    }

    public static IsTokenTimeDifferenceEnabledUseCase_Factory create(Provider<ITalabatFeatureFlag> provider) {
        return new IsTokenTimeDifferenceEnabledUseCase_Factory(provider);
    }

    public static IsTokenTimeDifferenceEnabledUseCase newInstance(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsTokenTimeDifferenceEnabledUseCase(iTalabatFeatureFlag);
    }

    public IsTokenTimeDifferenceEnabledUseCase get() {
        return newInstance(this.featureFlagProvider.get());
    }
}
