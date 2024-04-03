package com.talabat.splash.core.platform;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class NetworkHandler_Factory implements Factory<NetworkHandler> {
    private final Provider<Context> contextProvider;

    public NetworkHandler_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static NetworkHandler_Factory create(Provider<Context> provider) {
        return new NetworkHandler_Factory(provider);
    }

    public static NetworkHandler newInstance(Context context) {
        return new NetworkHandler(context);
    }

    public NetworkHandler get() {
        return newInstance(this.contextProvider.get());
    }
}
