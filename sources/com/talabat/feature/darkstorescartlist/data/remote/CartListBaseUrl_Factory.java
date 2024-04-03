package com.talabat.feature.darkstorescartlist.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartListBaseUrl_Factory implements Factory<CartListBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartListBaseUrl_Factory INSTANCE = new CartListBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static CartListBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartListBaseUrl newInstance() {
        return new CartListBaseUrl();
    }

    public CartListBaseUrl get() {
        return newInstance();
    }
}
