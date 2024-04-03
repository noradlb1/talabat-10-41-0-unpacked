package com.talabat.darkstores.data.darkstores.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartResponseMapper_Factory implements Factory<CartResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartResponseMapper_Factory INSTANCE = new CartResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CartResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartResponseMapper newInstance() {
        return new CartResponseMapper();
    }

    public CartResponseMapper get() {
        return newInstance();
    }
}
