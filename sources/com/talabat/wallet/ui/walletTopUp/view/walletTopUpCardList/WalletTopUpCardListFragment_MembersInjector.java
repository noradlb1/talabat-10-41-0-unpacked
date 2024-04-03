package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopUpCardListFragment_MembersInjector implements MembersInjector<WalletTopUpCardListFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public WalletTopUpCardListFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IObservabilityManager> provider3, Provider<TalabatTracker> provider4) {
        this.configurationLocalRepositoryProvider = provider;
        this.featureFlagProvider = provider2;
        this.observabilityManagerProvider = provider3;
        this.talabatTrackerProvider = provider4;
    }

    public static MembersInjector<WalletTopUpCardListFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IObservabilityManager> provider3, Provider<TalabatTracker> provider4) {
        return new WalletTopUpCardListFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopUpCardListFragment walletTopUpCardListFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopUpCardListFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment.featureFlag")
    public static void injectFeatureFlag(WalletTopUpCardListFragment walletTopUpCardListFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        walletTopUpCardListFragment.featureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment.observabilityManager")
    public static void injectObservabilityManager(WalletTopUpCardListFragment walletTopUpCardListFragment, IObservabilityManager iObservabilityManager) {
        walletTopUpCardListFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment.talabatTracker")
    public static void injectTalabatTracker(WalletTopUpCardListFragment walletTopUpCardListFragment, TalabatTracker talabatTracker) {
        walletTopUpCardListFragment.talabatTracker = talabatTracker;
    }

    public void injectMembers(WalletTopUpCardListFragment walletTopUpCardListFragment) {
        injectConfigurationLocalRepository(walletTopUpCardListFragment, this.configurationLocalRepositoryProvider.get());
        injectFeatureFlag(walletTopUpCardListFragment, this.featureFlagProvider.get());
        injectObservabilityManager(walletTopUpCardListFragment, this.observabilityManagerProvider.get());
        injectTalabatTracker(walletTopUpCardListFragment, this.talabatTrackerProvider.get());
    }
}
