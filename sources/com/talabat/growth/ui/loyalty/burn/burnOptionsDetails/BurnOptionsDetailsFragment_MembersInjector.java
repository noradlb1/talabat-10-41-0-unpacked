package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BurnOptionsDetailsFragment_MembersInjector implements MembersInjector<BurnOptionsDetailsFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public BurnOptionsDetailsFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<BurnOptionsDetailsFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new BurnOptionsDetailsFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(BurnOptionsDetailsFragment burnOptionsDetailsFragment, ConfigurationLocalRepository configurationLocalRepository) {
        burnOptionsDetailsFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
        injectConfigurationLocalRepository(burnOptionsDetailsFragment, this.configurationLocalRepositoryProvider.get());
    }
}
