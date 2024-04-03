package com.talabat.authentication.authenticate.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenExchangeRetriesRepositoryImpl_Factory implements Factory<TokenExchangeRetriesRepositoryImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenExchangeRetriesRepositoryImpl_Factory INSTANCE = new TokenExchangeRetriesRepositoryImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenExchangeRetriesRepositoryImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenExchangeRetriesRepositoryImpl newInstance() {
        return new TokenExchangeRetriesRepositoryImpl();
    }

    public TokenExchangeRetriesRepositoryImpl get() {
        return newInstance();
    }
}
