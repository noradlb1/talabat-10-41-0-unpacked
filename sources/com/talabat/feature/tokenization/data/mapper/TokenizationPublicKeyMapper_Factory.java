package com.talabat.feature.tokenization.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenizationPublicKeyMapper_Factory implements Factory<TokenizationPublicKeyMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenizationPublicKeyMapper_Factory INSTANCE = new TokenizationPublicKeyMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenizationPublicKeyMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenizationPublicKeyMapper newInstance() {
        return new TokenizationPublicKeyMapper();
    }

    public TokenizationPublicKeyMapper get() {
        return newInstance();
    }
}
