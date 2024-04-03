package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Vendor"})
public final class DarkstoresNetworkModule_ProvideVendorBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideVendorBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideVendorBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideVendorBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideVendorBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideVendorBaseUrl());
    }

    public String get() {
        return provideVendorBaseUrl();
    }
}
