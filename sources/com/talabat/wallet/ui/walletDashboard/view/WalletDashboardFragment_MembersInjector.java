package com.talabat.wallet.ui.walletDashboard.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletDashboardFragment_MembersInjector implements MembersInjector<WalletDashboardFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public WalletDashboardFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<Navigator> provider4, Provider<DeepLinkNavigator> provider5, Provider<TalabatTracker> provider6, Provider<IObservabilityManager> provider7) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.navigatorProvider = provider4;
        this.deepLinkNavigatorProvider = provider5;
        this.talabatTrackerProvider = provider6;
        this.observabilityManagerProvider = provider7;
    }

    public static MembersInjector<WalletDashboardFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<Navigator> provider4, Provider<DeepLinkNavigator> provider5, Provider<TalabatTracker> provider6, Provider<IObservabilityManager> provider7) {
        return new WalletDashboardFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletDashboardFragment walletDashboardFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletDashboardFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(WalletDashboardFragment walletDashboardFragment, DeepLinkNavigator deepLinkNavigator) {
        walletDashboardFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletDashboardFragment walletDashboardFragment, LocationConfigurationRepository locationConfigurationRepository) {
        walletDashboardFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.navigator")
    public static void injectNavigator(WalletDashboardFragment walletDashboardFragment, Navigator navigator) {
        walletDashboardFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.observabilityManager")
    public static void injectObservabilityManager(WalletDashboardFragment walletDashboardFragment, IObservabilityManager iObservabilityManager) {
        walletDashboardFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(WalletDashboardFragment walletDashboardFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        walletDashboardFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.talabatTracker")
    public static void injectTalabatTracker(WalletDashboardFragment walletDashboardFragment, TalabatTracker talabatTracker) {
        walletDashboardFragment.talabatTracker = talabatTracker;
    }

    public void injectMembers(WalletDashboardFragment walletDashboardFragment) {
        injectConfigurationLocalRepository(walletDashboardFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletDashboardFragment, this.locationConfigurationRepositoryProvider.get());
        injectTalabatFeatureFlag(walletDashboardFragment, this.talabatFeatureFlagProvider.get());
        injectNavigator(walletDashboardFragment, this.navigatorProvider.get());
        injectDeepLinkNavigator(walletDashboardFragment, this.deepLinkNavigatorProvider.get());
        injectTalabatTracker(walletDashboardFragment, this.talabatTrackerProvider.get());
        injectObservabilityManager(walletDashboardFragment, this.observabilityManagerProvider.get());
    }
}
