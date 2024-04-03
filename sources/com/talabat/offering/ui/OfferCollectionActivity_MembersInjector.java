package com.talabat.offering.ui;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class OfferCollectionActivity_MembersInjector implements MembersInjector<OfferCollectionActivity> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public OfferCollectionActivity_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static MembersInjector<OfferCollectionActivity> create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new OfferCollectionActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.offering.ui.OfferCollectionActivity.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(OfferCollectionActivity offerCollectionActivity, ConfigurationLocalRepository configurationLocalRepository) {
        offerCollectionActivity.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.offering.ui.OfferCollectionActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(OfferCollectionActivity offerCollectionActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        offerCollectionActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(OfferCollectionActivity offerCollectionActivity) {
        injectConfigurationLocalRepository(offerCollectionActivity, this.configurationLocalRepositoryProvider.get());
        injectTalabatFeatureFlag(offerCollectionActivity, this.talabatFeatureFlagProvider.get());
    }
}
