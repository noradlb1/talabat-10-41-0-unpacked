package com.talabat.growth.ui.loyalty.history;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LoyaltyHistoryFragment_MembersInjector implements MembersInjector<LoyaltyHistoryFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public LoyaltyHistoryFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<LoyaltyHistoryFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new LoyaltyHistoryFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.history.LoyaltyHistoryFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(LoyaltyHistoryFragment loyaltyHistoryFragment, ConfigurationLocalRepository configurationLocalRepository) {
        loyaltyHistoryFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(LoyaltyHistoryFragment loyaltyHistoryFragment) {
        injectConfigurationLocalRepository(loyaltyHistoryFragment, this.configurationLocalRepositoryProvider.get());
    }
}
