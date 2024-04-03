package com.talabat.wallet.bnplmanager.ui;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BNPLInitiatePlaceOrderFragment_MembersInjector implements MembersInjector<BNPLInitiatePlaceOrderFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public BNPLInitiatePlaceOrderFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<IObservabilityManager> provider4, Provider<TermsAndConditionsConfigurationRepository> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.featureFlagRepositoryProvider = provider3;
        this.observabilityManagerProvider = provider4;
        this.termsAndConditionsConfigurationRepositoryProvider = provider5;
    }

    public static MembersInjector<BNPLInitiatePlaceOrderFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<IObservabilityManager> provider4, Provider<TermsAndConditionsConfigurationRepository> provider5) {
        return new BNPLInitiatePlaceOrderFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, ConfigurationLocalRepository configurationLocalRepository) {
        bNPLInitiatePlaceOrderFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment.featureFlagRepository")
    public static void injectFeatureFlagRepository(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        bNPLInitiatePlaceOrderFragment.featureFlagRepository = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, LocationConfigurationRepository locationConfigurationRepository) {
        bNPLInitiatePlaceOrderFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment.observabilityManager")
    public static void injectObservabilityManager(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, IObservabilityManager iObservabilityManager) {
        bNPLInitiatePlaceOrderFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        bNPLInitiatePlaceOrderFragment.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        injectConfigurationLocalRepository(bNPLInitiatePlaceOrderFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(bNPLInitiatePlaceOrderFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepository(bNPLInitiatePlaceOrderFragment, this.featureFlagRepositoryProvider.get());
        injectObservabilityManager(bNPLInitiatePlaceOrderFragment, this.observabilityManagerProvider.get());
        injectTermsAndConditionsConfigurationRepository(bNPLInitiatePlaceOrderFragment, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
