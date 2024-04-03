package com.talabat.darkstores.domain.banner;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsFlutterBannerProductListingEnabledUseCaseImpl_Factory implements Factory<IsFlutterBannerProductListingEnabledUseCaseImpl> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public IsFlutterBannerProductListingEnabledUseCaseImpl_Factory(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static IsFlutterBannerProductListingEnabledUseCaseImpl_Factory create(Provider<ITalabatFeatureFlag> provider) {
        return new IsFlutterBannerProductListingEnabledUseCaseImpl_Factory(provider);
    }

    public static IsFlutterBannerProductListingEnabledUseCaseImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsFlutterBannerProductListingEnabledUseCaseImpl(iTalabatFeatureFlag);
    }

    public IsFlutterBannerProductListingEnabledUseCaseImpl get() {
        return newInstance(this.talabatFeatureFlagProvider.get());
    }
}
