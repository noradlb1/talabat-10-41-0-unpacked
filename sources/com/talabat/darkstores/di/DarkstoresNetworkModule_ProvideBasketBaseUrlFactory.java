package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Basket"})
public final class DarkstoresNetworkModule_ProvideBasketBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideBasketBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideBasketBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideBasketBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideBasketBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideBasketBaseUrl());
    }

    public String get() {
        return provideBasketBaseUrl();
    }
}
