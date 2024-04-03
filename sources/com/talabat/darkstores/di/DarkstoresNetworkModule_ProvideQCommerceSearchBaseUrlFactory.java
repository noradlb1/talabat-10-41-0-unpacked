package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.QCommerce"})
public final class DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideQCommerceSearchBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideQCommerceSearchBaseUrl());
    }

    public String get() {
        return provideQCommerceSearchBaseUrl();
    }
}
