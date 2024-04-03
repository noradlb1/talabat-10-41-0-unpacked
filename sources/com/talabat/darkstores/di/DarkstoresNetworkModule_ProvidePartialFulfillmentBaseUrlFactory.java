package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.PartialFulfillment"})
public final class DarkstoresNetworkModule_ProvidePartialFulfillmentBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvidePartialFulfillmentBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvidePartialFulfillmentBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvidePartialFulfillmentBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String providePartialFulfillmentBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.providePartialFulfillmentBaseUrl());
    }

    public String get() {
        return providePartialFulfillmentBaseUrl();
    }
}
