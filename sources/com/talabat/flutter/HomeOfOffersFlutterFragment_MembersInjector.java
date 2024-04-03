package com.talabat.flutter;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class HomeOfOffersFlutterFragment_MembersInjector implements MembersInjector<HomeOfOffersFlutterFragment> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public HomeOfOffersFlutterFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static MembersInjector<HomeOfOffersFlutterFragment> create(Provider<ITalabatFeatureFlag> provider) {
        return new HomeOfOffersFlutterFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.flutter.HomeOfOffersFlutterFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(HomeOfOffersFlutterFragment homeOfOffersFlutterFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        homeOfOffersFlutterFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(HomeOfOffersFlutterFragment homeOfOffersFlutterFragment) {
        injectTalabatFeatureFlag(homeOfOffersFlutterFragment, this.talabatFeatureFlagProvider.get());
    }
}
