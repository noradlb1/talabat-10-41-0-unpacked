package com.talabat.feature.rating.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingNetworkModule_ProvideBaseUrlFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RatingNetworkModule_ProvideBaseUrlFactory INSTANCE = new RatingNetworkModule_ProvideBaseUrlFactory();

        private InstanceHolder() {
        }
    }

    public static RatingNetworkModule_ProvideBaseUrlFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideBaseUrl() {
        return (String) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.provideBaseUrl());
    }

    public String get() {
        return provideBaseUrl();
    }
}
