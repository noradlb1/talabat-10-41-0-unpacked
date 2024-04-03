package com.talabat.feature.darkstorescartlist.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartInfoResponseMapper_Factory implements Factory<CartInfoResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartInfoResponseMapper_Factory INSTANCE = new CartInfoResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CartInfoResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartInfoResponseMapper newInstance() {
        return new CartInfoResponseMapper();
    }

    public CartInfoResponseMapper get() {
        return newInstance();
    }
}
