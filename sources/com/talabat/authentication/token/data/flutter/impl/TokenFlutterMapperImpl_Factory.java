package com.talabat.authentication.token.data.flutter.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenFlutterMapperImpl_Factory implements Factory<TokenFlutterMapperImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenFlutterMapperImpl_Factory INSTANCE = new TokenFlutterMapperImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenFlutterMapperImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenFlutterMapperImpl newInstance() {
        return new TokenFlutterMapperImpl();
    }

    public TokenFlutterMapperImpl get() {
        return newInstance();
    }
}
