package com.talabat.darkstores.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresNetworkModule_ProvideMoshiFactory implements Factory<Moshi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresNetworkModule_ProvideMoshiFactory INSTANCE = new DarkstoresNetworkModule_ProvideMoshiFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresNetworkModule_ProvideMoshiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Moshi provideMoshi() {
        return (Moshi) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideMoshi());
    }

    public Moshi get() {
        return provideMoshi();
    }
}
