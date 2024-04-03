package com.talabat.feature.tmart.growth.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TMartGrowthNetworkModule_ProvideBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TMartGrowthNetworkModule_ProvideBaseUrlFactory INSTANCE = new TMartGrowthNetworkModule_ProvideBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static TMartGrowthNetworkModule_ProvideBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(TMartGrowthNetworkModule.INSTANCE.provideBaseUrl());
    }

    public String get() {
        return provideBaseUrl();
    }
}
