package com.talabat.growth.ui.loyalty.burn.details;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BurnOptionsDetailsDialogFragment_MembersInjector implements MembersInjector<BurnOptionsDetailsDialogFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public BurnOptionsDetailsDialogFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<BurnOptionsDetailsDialogFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new BurnOptionsDetailsDialogFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.details.BurnOptionsDetailsDialogFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment, ConfigurationLocalRepository configurationLocalRepository) {
        burnOptionsDetailsDialogFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
        injectConfigurationLocalRepository(burnOptionsDetailsDialogFragment, this.configurationLocalRepositoryProvider.get());
    }
}
