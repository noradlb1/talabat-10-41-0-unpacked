package com.talabat.configuration.payment.flutter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class WalletConfigFlutterEncoder_Factory implements Factory<WalletConfigFlutterEncoder> {
    private final Provider<TokenizedBankCardFlutterEncoder> tokenizedBankCardFlutterEncoderProvider;

    public WalletConfigFlutterEncoder_Factory(Provider<TokenizedBankCardFlutterEncoder> provider) {
        this.tokenizedBankCardFlutterEncoderProvider = provider;
    }

    public static WalletConfigFlutterEncoder_Factory create(Provider<TokenizedBankCardFlutterEncoder> provider) {
        return new WalletConfigFlutterEncoder_Factory(provider);
    }

    public static WalletConfigFlutterEncoder newInstance(TokenizedBankCardFlutterEncoder tokenizedBankCardFlutterEncoder) {
        return new WalletConfigFlutterEncoder(tokenizedBankCardFlutterEncoder);
    }

    public WalletConfigFlutterEncoder get() {
        return newInstance(this.tokenizedBankCardFlutterEncoderProvider.get());
    }
}
