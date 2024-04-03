package com.talabat.fragments;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RateRestaurantFragment_MembersInjector implements MembersInjector<RateRestaurantFragment> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RateRestaurantFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static MembersInjector<RateRestaurantFragment> create(Provider<ITalabatFeatureFlag> provider) {
        return new RateRestaurantFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.fragments.RateRestaurantFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RateRestaurantFragment rateRestaurantFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        rateRestaurantFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(RateRestaurantFragment rateRestaurantFragment) {
        injectTalabatFeatureFlag(rateRestaurantFragment, this.talabatFeatureFlagProvider.get());
    }
}
