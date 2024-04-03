package com.talabat.wallet.ui.walletTransactionDetail.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTransactionDetailFragment_MembersInjector implements MembersInjector<WalletTransactionDetailFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpDeeplinkBuilderProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public WalletTransactionDetailFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<Navigator> provider3, Provider<DeepLinkNavigator> provider4, Provider<IHelpCenterDeeplinkBuilder> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.navigatorProvider = provider3;
        this.deepLinkNavigatorProvider = provider4;
        this.helpDeeplinkBuilderProvider = provider5;
    }

    public static MembersInjector<WalletTransactionDetailFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<Navigator> provider3, Provider<DeepLinkNavigator> provider4, Provider<IHelpCenterDeeplinkBuilder> provider5) {
        return new WalletTransactionDetailFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTransactionDetailFragment walletTransactionDetailFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletTransactionDetailFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(WalletTransactionDetailFragment walletTransactionDetailFragment, DeepLinkNavigator deepLinkNavigator) {
        walletTransactionDetailFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment.helpDeeplinkBuilder")
    public static void injectHelpDeeplinkBuilder(WalletTransactionDetailFragment walletTransactionDetailFragment, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        walletTransactionDetailFragment.helpDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTransactionDetailFragment walletTransactionDetailFragment, LocationConfigurationRepository locationConfigurationRepository) {
        walletTransactionDetailFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment.navigator")
    public static void injectNavigator(WalletTransactionDetailFragment walletTransactionDetailFragment, Navigator navigator) {
        walletTransactionDetailFragment.navigator = navigator;
    }

    public void injectMembers(WalletTransactionDetailFragment walletTransactionDetailFragment) {
        injectConfigurationLocalRepository(walletTransactionDetailFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTransactionDetailFragment, this.locationConfigurationRepositoryProvider.get());
        injectNavigator(walletTransactionDetailFragment, this.navigatorProvider.get());
        injectDeepLinkNavigator(walletTransactionDetailFragment, this.deepLinkNavigatorProvider.get());
        injectHelpDeeplinkBuilder(walletTransactionDetailFragment, this.helpDeeplinkBuilderProvider.get());
    }
}
