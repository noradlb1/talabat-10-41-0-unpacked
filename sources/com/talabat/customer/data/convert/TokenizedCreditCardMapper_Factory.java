package com.talabat.customer.data.convert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenizedCreditCardMapper_Factory implements Factory<TokenizedCreditCardMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenizedCreditCardMapper_Factory INSTANCE = new TokenizedCreditCardMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenizedCreditCardMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenizedCreditCardMapper newInstance() {
        return new TokenizedCreditCardMapper();
    }

    public TokenizedCreditCardMapper get() {
        return newInstance();
    }
}
