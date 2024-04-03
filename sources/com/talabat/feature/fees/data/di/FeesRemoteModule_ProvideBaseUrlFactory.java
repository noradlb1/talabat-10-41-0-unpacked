package com.talabat.feature.fees.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class FeesRemoteModule_ProvideBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FeesRemoteModule_ProvideBaseUrlFactory INSTANCE = new FeesRemoteModule_ProvideBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static FeesRemoteModule_ProvideBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(FeesRemoteModule.INSTANCE.provideBaseUrl());
    }

    public String get() {
        return provideBaseUrl();
    }
}
