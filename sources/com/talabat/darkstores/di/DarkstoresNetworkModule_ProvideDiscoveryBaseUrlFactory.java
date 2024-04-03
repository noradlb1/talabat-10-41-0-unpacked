package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Discovery"})
public final class DarkstoresNetworkModule_ProvideDiscoveryBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideDiscoveryBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideDiscoveryBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideDiscoveryBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideDiscoveryBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideDiscoveryBaseUrl());
    }

    public String get() {
        return provideDiscoveryBaseUrl();
    }
}
