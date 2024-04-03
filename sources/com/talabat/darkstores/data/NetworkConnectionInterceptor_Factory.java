package com.talabat.darkstores.data;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NetworkConnectionInterceptor_Factory implements Factory<NetworkConnectionInterceptor> {
    private final Provider<Context> contextProvider;

    public NetworkConnectionInterceptor_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static NetworkConnectionInterceptor_Factory create(Provider<Context> provider) {
        return new NetworkConnectionInterceptor_Factory(provider);
    }

    public static NetworkConnectionInterceptor newInstance(Context context) {
        return new NetworkConnectionInterceptor(context);
    }

    public NetworkConnectionInterceptor get() {
        return newInstance(this.contextProvider.get());
    }
}
