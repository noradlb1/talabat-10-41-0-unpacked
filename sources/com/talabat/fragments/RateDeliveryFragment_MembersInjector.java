package com.talabat.fragments;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RateDeliveryFragment_MembersInjector implements MembersInjector<RateDeliveryFragment> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RateDeliveryFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static MembersInjector<RateDeliveryFragment> create(Provider<ITalabatFeatureFlag> provider) {
        return new RateDeliveryFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.fragments.RateDeliveryFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RateDeliveryFragment rateDeliveryFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        rateDeliveryFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(RateDeliveryFragment rateDeliveryFragment) {
        injectTalabatFeatureFlag(rateDeliveryFragment, this.talabatFeatureFlagProvider.get());
    }
}
