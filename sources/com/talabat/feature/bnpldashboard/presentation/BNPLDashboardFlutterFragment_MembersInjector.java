package com.talabat.feature.bnpldashboard.presentation;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BNPLDashboardFlutterFragment_MembersInjector implements MembersInjector<BNPLDashboardFlutterFragment> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;
    private final Provider<WalletAddCard3DSHandler> walletAddCard3DSHandlerProvider;
    private final Provider<WalletMethodCallHandler> walletMethodCallHandlerProvider;

    public BNPLDashboardFlutterFragment_MembersInjector(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        this.walletMethodCallHandlerProvider = provider;
        this.walletAddCard3DSHandlerProvider = provider2;
        this.helpCenterDeeplinkBuilderProvider = provider3;
        this.deepLinkNavigatorProvider = provider4;
    }

    public static MembersInjector<BNPLDashboardFlutterFragment> create(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        return new BNPLDashboardFlutterFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment, DeepLinkNavigator deepLinkNavigator) {
        bNPLDashboardFlutterFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        bNPLDashboardFlutterFragment.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment.walletAddCard3DSHandler")
    public static void injectWalletAddCard3DSHandler(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment, WalletAddCard3DSHandler walletAddCard3DSHandler) {
        bNPLDashboardFlutterFragment.walletAddCard3DSHandler = walletAddCard3DSHandler;
    }

    @InjectedFieldSignature("com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment.walletMethodCallHandler")
    public static void injectWalletMethodCallHandler(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment, WalletMethodCallHandler walletMethodCallHandler) {
        bNPLDashboardFlutterFragment.walletMethodCallHandler = walletMethodCallHandler;
    }

    public void injectMembers(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment) {
        injectWalletMethodCallHandler(bNPLDashboardFlutterFragment, this.walletMethodCallHandlerProvider.get());
        injectWalletAddCard3DSHandler(bNPLDashboardFlutterFragment, this.walletAddCard3DSHandlerProvider.get());
        injectHelpCenterDeeplinkBuilder(bNPLDashboardFlutterFragment, this.helpCenterDeeplinkBuilderProvider.get());
        injectDeepLinkNavigator(bNPLDashboardFlutterFragment, this.deepLinkNavigatorProvider.get());
    }
}
