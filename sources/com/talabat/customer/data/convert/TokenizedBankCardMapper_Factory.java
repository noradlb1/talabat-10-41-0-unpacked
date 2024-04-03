package com.talabat.customer.data.convert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenizedBankCardMapper_Factory implements Factory<TokenizedBankCardMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenizedBankCardMapper_Factory INSTANCE = new TokenizedBankCardMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenizedBankCardMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenizedBankCardMapper newInstance() {
        return new TokenizedBankCardMapper();
    }

    public TokenizedBankCardMapper get() {
        return newInstance();
    }
}
