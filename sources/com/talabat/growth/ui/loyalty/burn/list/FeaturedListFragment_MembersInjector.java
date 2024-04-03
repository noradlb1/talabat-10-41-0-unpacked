package com.talabat.growth.ui.loyalty.burn.list;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class FeaturedListFragment_MembersInjector implements MembersInjector<FeaturedListFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public FeaturedListFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3) {
        this.configurationLocalRepositoryProvider = provider;
        this.featureFlagRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
    }

    public static MembersInjector<FeaturedListFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3) {
        return new FeaturedListFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.list.FeaturedListFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(FeaturedListFragment featuredListFragment, ConfigurationLocalRepository configurationLocalRepository) {
        featuredListFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.list.FeaturedListFragment.featureFlagRepository")
    public static void injectFeatureFlagRepository(FeaturedListFragment featuredListFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        featuredListFragment.featureFlagRepository = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.list.FeaturedListFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(FeaturedListFragment featuredListFragment, LocationConfigurationRepository locationConfigurationRepository) {
        featuredListFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(FeaturedListFragment featuredListFragment) {
        injectConfigurationLocalRepository(featuredListFragment, this.configurationLocalRepositoryProvider.get());
        injectFeatureFlagRepository(featuredListFragment, this.featureFlagRepositoryProvider.get());
        injectLocationConfigurationRepository(featuredListFragment, this.locationConfigurationRepositoryProvider.get());
    }
}
