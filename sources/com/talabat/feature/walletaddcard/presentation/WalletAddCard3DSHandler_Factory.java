package com.talabat.feature.walletaddcard.presentation;

import androidx.fragment.app.Fragment;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletAddCard3DSHandler_Factory implements Factory<WalletAddCard3DSHandler> {
    private final Provider<Fragment> fragmentProvider;
    private final Provider<WalletMethodCallHandler> walletMethodCallHandlerProvider;

    public WalletAddCard3DSHandler_Factory(Provider<WalletMethodCallHandler> provider, Provider<Fragment> provider2) {
        this.walletMethodCallHandlerProvider = provider;
        this.fragmentProvider = provider2;
    }

    public static WalletAddCard3DSHandler_Factory create(Provider<WalletMethodCallHandler> provider, Provider<Fragment> provider2) {
        return new WalletAddCard3DSHandler_Factory(provider, provider2);
    }

    public static WalletAddCard3DSHandler newInstance(WalletMethodCallHandler walletMethodCallHandler, Fragment fragment) {
        return new WalletAddCard3DSHandler(walletMethodCallHandler, fragment);
    }

    public WalletAddCard3DSHandler get() {
        return newInstance(this.walletMethodCallHandlerProvider.get(), this.fragmentProvider.get());
    }
}
