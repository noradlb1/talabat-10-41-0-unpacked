package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopUpScreenFragment_MembersInjector implements MembersInjector<WalletTopUpScreenFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public WalletTopUpScreenFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.featureFlagProvider = provider3;
        this.talabatTrackerProvider = provider4;
    }

    public static MembersInjector<WalletTopUpScreenFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4) {
        return new WalletTopUpScreenFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopUpScreenFragment walletTopUpScreenFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopUpScreenFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment.featureFlag")
    public static void injectFeatureFlag(WalletTopUpScreenFragment walletTopUpScreenFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        walletTopUpScreenFragment.featureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTopUpScreenFragment walletTopUpScreenFragment, LocationConfigurationRepository locationConfigurationRepository) {
        walletTopUpScreenFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment.talabatTracker")
    public static void injectTalabatTracker(WalletTopUpScreenFragment walletTopUpScreenFragment, TalabatTracker talabatTracker) {
        walletTopUpScreenFragment.talabatTracker = talabatTracker;
    }

    public void injectMembers(WalletTopUpScreenFragment walletTopUpScreenFragment) {
        injectConfigurationLocalRepository(walletTopUpScreenFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTopUpScreenFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlag(walletTopUpScreenFragment, this.featureFlagProvider.get());
        injectTalabatTracker(walletTopUpScreenFragment, this.talabatTrackerProvider.get());
    }
}
