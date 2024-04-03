package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.banner.IsFlutterBannerProductListingEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildBannerCampaignProductListingNavigationUseCaseImpl_Factory implements Factory<BuildBannerCampaignProductListingNavigationUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;
    private final Provider<IsFlutterBannerProductListingEnabledUseCase> isFlutterBannerProductListingEnabledProvider;

    public BuildBannerCampaignProductListingNavigationUseCaseImpl_Factory(Provider<IsFlutterBannerProductListingEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        this.isFlutterBannerProductListingEnabledProvider = provider;
        this.getFlutterConfigurationParamsProvider = provider2;
    }

    public static BuildBannerCampaignProductListingNavigationUseCaseImpl_Factory create(Provider<IsFlutterBannerProductListingEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        return new BuildBannerCampaignProductListingNavigationUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildBannerCampaignProductListingNavigationUseCaseImpl newInstance(IsFlutterBannerProductListingEnabledUseCase isFlutterBannerProductListingEnabledUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildBannerCampaignProductListingNavigationUseCaseImpl(isFlutterBannerProductListingEnabledUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildBannerCampaignProductListingNavigationUseCaseImpl get() {
        return newInstance(this.isFlutterBannerProductListingEnabledProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
