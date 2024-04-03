package com.talabat.darkstores.feature.cart.views;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartProgressViewPresenter_Factory implements Factory<CartProgressViewPresenter> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CartProgressViewPresenter_Factory INSTANCE = new CartProgressViewPresenter_Factory();

        private InstanceHolder() {
        }
    }

    public static CartProgressViewPresenter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CartProgressViewPresenter newInstance() {
        return new CartProgressViewPresenter();
    }

    public CartProgressViewPresenter get() {
        return newInstance();
    }
}
