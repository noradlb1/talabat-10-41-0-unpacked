package com.talabat.wallet.debitcarddeflection.ui;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BenefitBinInfoFragment_MembersInjector implements MembersInjector<BenefitBinInfoFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public BenefitBinInfoFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<BenefitBinInfoFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new BenefitBinInfoFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.wallet.debitcarddeflection.ui.BenefitBinInfoFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(BenefitBinInfoFragment benefitBinInfoFragment, ConfigurationLocalRepository configurationLocalRepository) {
        benefitBinInfoFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(BenefitBinInfoFragment benefitBinInfoFragment) {
        injectConfigurationLocalRepository(benefitBinInfoFragment, this.configurationLocalRepositoryProvider.get());
    }
}
