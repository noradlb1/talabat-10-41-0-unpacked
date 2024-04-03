package com.talabat.feature.ridertips.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipNetworkModule_ProvideBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RiderTipNetworkModule_ProvideBaseUrlFactory INSTANCE = new RiderTipNetworkModule_ProvideBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static RiderTipNetworkModule_ProvideBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(RiderTipNetworkModule.INSTANCE.provideBaseUrl());
    }

    public String get() {
        return provideBaseUrl();
    }
}
