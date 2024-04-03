package com.talabat.feature.bnplcheckout.presentation;

import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BNPLCheckoutFlutterFragment_MembersInjector implements MembersInjector<BNPLCheckoutFlutterFragment> {
    private final Provider<WalletAddCard3DSHandler> walletAddCard3DSHandlerProvider;
    private final Provider<WalletMethodCallHandler> walletMethodCallHandlerProvider;

    public BNPLCheckoutFlutterFragment_MembersInjector(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2) {
        this.walletMethodCallHandlerProvider = provider;
        this.walletAddCard3DSHandlerProvider = provider2;
    }

    public static MembersInjector<BNPLCheckoutFlutterFragment> create(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2) {
        return new BNPLCheckoutFlutterFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment.walletAddCard3DSHandler")
    public static void injectWalletAddCard3DSHandler(BNPLCheckoutFlutterFragment bNPLCheckoutFlutterFragment, WalletAddCard3DSHandler walletAddCard3DSHandler) {
        bNPLCheckoutFlutterFragment.walletAddCard3DSHandler = walletAddCard3DSHandler;
    }

    @InjectedFieldSignature("com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment.walletMethodCallHandler")
    public static void injectWalletMethodCallHandler(BNPLCheckoutFlutterFragment bNPLCheckoutFlutterFragment, WalletMethodCallHandler walletMethodCallHandler) {
        bNPLCheckoutFlutterFragment.walletMethodCallHandler = walletMethodCallHandler;
    }

    public void injectMembers(BNPLCheckoutFlutterFragment bNPLCheckoutFlutterFragment) {
        injectWalletMethodCallHandler(bNPLCheckoutFlutterFragment, this.walletMethodCallHandlerProvider.get());
        injectWalletAddCard3DSHandler(bNPLCheckoutFlutterFragment, this.walletAddCard3DSHandlerProvider.get());
    }
}
