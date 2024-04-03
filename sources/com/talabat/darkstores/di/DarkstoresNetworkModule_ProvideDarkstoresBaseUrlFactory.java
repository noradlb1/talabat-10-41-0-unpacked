package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores"})
public final class DarkstoresNetworkModule_ProvideDarkstoresBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideDarkstoresBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideDarkstoresBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideDarkstoresBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideDarkstoresBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideDarkstoresBaseUrl());
    }

    public String get() {
        return provideDarkstoresBaseUrl();
    }
}
