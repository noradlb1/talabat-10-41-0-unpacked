package com.talabat.core.flutter.channels.impl.data.cart;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartChannelCallbackImpl_Factory implements Factory<CartChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartChannelCallbackImpl_Factory INSTANCE = new CartChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static CartChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartChannelCallbackImpl newInstance() {
        return new CartChannelCallbackImpl();
    }

    public CartChannelCallbackImpl get() {
        return newInstance();
    }
}
