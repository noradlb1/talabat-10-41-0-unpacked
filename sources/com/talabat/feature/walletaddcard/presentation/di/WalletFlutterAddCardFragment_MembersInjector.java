package com.talabat.feature.walletaddcard.presentation.di;

import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletFlutterAddCardFragment_MembersInjector implements MembersInjector<WalletFlutterAddCardFragment> {
    private final Provider<WalletAddCard3DSHandler> walletAddCard3DSHandlerProvider;
    private final Provider<WalletMethodCallHandler> walletMethodCallHandlerProvider;

    public WalletFlutterAddCardFragment_MembersInjector(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2) {
        this.walletMethodCallHandlerProvider = provider;
        this.walletAddCard3DSHandlerProvider = provider2;
    }

    public static MembersInjector<WalletFlutterAddCardFragment> create(Provider<WalletMethodCallHandler> provider, Provider<WalletAddCard3DSHandler> provider2) {
        return new WalletFlutterAddCardFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.feature.walletaddcard.presentation.di.WalletFlutterAddCardFragment.walletAddCard3DSHandler")
    public static void injectWalletAddCard3DSHandler(WalletFlutterAddCardFragment walletFlutterAddCardFragment, WalletAddCard3DSHandler walletAddCard3DSHandler) {
        walletFlutterAddCardFragment.walletAddCard3DSHandler = walletAddCard3DSHandler;
    }

    @InjectedFieldSignature("com.talabat.feature.walletaddcard.presentation.di.WalletFlutterAddCardFragment.walletMethodCallHandler")
    public static void injectWalletMethodCallHandler(WalletFlutterAddCardFragment walletFlutterAddCardFragment, WalletMethodCallHandler walletMethodCallHandler) {
        walletFlutterAddCardFragment.walletMethodCallHandler = walletMethodCallHandler;
    }

    public void injectMembers(WalletFlutterAddCardFragment walletFlutterAddCardFragment) {
        injectWalletMethodCallHandler(walletFlutterAddCardFragment, this.walletMethodCallHandlerProvider.get());
        injectWalletAddCard3DSHandler(walletFlutterAddCardFragment, this.walletAddCard3DSHandlerProvider.get());
    }
}
