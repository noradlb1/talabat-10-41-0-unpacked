package com.talabat.configuration.payment.flutter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class TokenizedBankCardFlutterEncoder_Factory implements Factory<TokenizedBankCardFlutterEncoder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenizedBankCardFlutterEncoder_Factory INSTANCE = new TokenizedBankCardFlutterEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenizedBankCardFlutterEncoder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenizedBankCardFlutterEncoder newInstance() {
        return new TokenizedBankCardFlutterEncoder();
    }

    public TokenizedBankCardFlutterEncoder get() {
        return newInstance();
    }
}
