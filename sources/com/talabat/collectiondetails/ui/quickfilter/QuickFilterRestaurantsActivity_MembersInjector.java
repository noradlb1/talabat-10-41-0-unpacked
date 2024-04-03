package com.talabat.collectiondetails.ui.quickfilter;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class QuickFilterRestaurantsActivity_MembersInjector implements MembersInjector<QuickFilterRestaurantsActivity> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public QuickFilterRestaurantsActivity_MembersInjector(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.configurationLocalCoreLibApiProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static MembersInjector<QuickFilterRestaurantsActivity> create(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new QuickFilterRestaurantsActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity.configurationLocalCoreLibApi")
    public static void injectConfigurationLocalCoreLibApi(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        quickFilterRestaurantsActivity.C = configurationLocalCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        quickFilterRestaurantsActivity.D = iTalabatFeatureFlag;
    }

    public void injectMembers(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity) {
        injectConfigurationLocalCoreLibApi(quickFilterRestaurantsActivity, this.configurationLocalCoreLibApiProvider.get());
        injectTalabatFeatureFlag(quickFilterRestaurantsActivity, this.talabatFeatureFlagProvider.get());
    }
}
