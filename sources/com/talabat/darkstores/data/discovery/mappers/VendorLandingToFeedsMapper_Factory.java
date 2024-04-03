package com.talabat.darkstores.data.discovery.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorLandingToFeedsMapper_Factory implements Factory<VendorLandingToFeedsMapper> {
    private final Provider<BannerDomainToViewModelMapper> bannerMapperProvider;

    public VendorLandingToFeedsMapper_Factory(Provider<BannerDomainToViewModelMapper> provider) {
        this.bannerMapperProvider = provider;
    }

    public static VendorLandingToFeedsMapper_Factory create(Provider<BannerDomainToViewModelMapper> provider) {
        return new VendorLandingToFeedsMapper_Factory(provider);
    }

    public static VendorLandingToFeedsMapper newInstance(BannerDomainToViewModelMapper bannerDomainToViewModelMapper) {
        return new VendorLandingToFeedsMapper(bannerDomainToViewModelMapper);
    }

    public VendorLandingToFeedsMapper get() {
        return newInstance(this.bannerMapperProvider.get());
    }
}
