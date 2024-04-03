package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Grocery"})
public final class DarkstoresNetworkModule_ProvideGroceryBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideGroceryBaseUrlFactory INSTANCE = new DarkstoresNetworkModule_ProvideGroceryBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideGroceryBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideGroceryBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideGroceryBaseUrl());
    }

    public String get() {
        return provideGroceryBaseUrl();
    }
}
