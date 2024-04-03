package com.talabat.core.network.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import okhttp3.OkHttpClient;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class NetworkCoreLibModule_OkHttpClientFactory implements Factory<OkHttpClient> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NetworkCoreLibModule_OkHttpClientFactory INSTANCE = new NetworkCoreLibModule_OkHttpClientFactory();

        private InstanceHolder() {
        }
    }

    public static NetworkCoreLibModule_OkHttpClientFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OkHttpClient okHttpClient() {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(NetworkCoreLibModule.INSTANCE.okHttpClient());
    }

    public OkHttpClient get() {
        return okHttpClient();
    }
}
