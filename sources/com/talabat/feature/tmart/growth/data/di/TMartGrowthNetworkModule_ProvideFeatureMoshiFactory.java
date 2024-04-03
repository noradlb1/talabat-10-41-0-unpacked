package com.talabat.feature.tmart.growth.data.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthNetworkModule_ProvideFeatureMoshiFactory implements Factory<Moshi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TMartGrowthNetworkModule_ProvideFeatureMoshiFactory INSTANCE = new TMartGrowthNetworkModule_ProvideFeatureMoshiFactory();

        private InstanceHolder() {
        }
    }

    public static TMartGrowthNetworkModule_ProvideFeatureMoshiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Moshi provideFeatureMoshi() {
        return (Moshi) Preconditions.checkNotNullFromProvides(TMartGrowthNetworkModule.INSTANCE.provideFeatureMoshi());
    }

    public Moshi get() {
        return provideFeatureMoshi();
    }
}
