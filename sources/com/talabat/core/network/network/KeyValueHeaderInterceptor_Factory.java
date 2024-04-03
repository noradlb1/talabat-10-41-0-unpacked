package com.talabat.core.network.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.network.di.KeyValueHeaderKey", "com.talabat.core.network.di.KeyValueHeaderValue", "com.talabat.core.network.di.KeyValueHeaderValueShouldBase64Decoded"})
public final class KeyValueHeaderInterceptor_Factory implements Factory<KeyValueHeaderInterceptor> {
    private final Provider<String> keyProvider;
    private final Provider<Boolean> shouldBase64DecodedProvider;
    private final Provider<String> valueProvider;

    public KeyValueHeaderInterceptor_Factory(Provider<String> provider, Provider<String> provider2, Provider<Boolean> provider3) {
        this.keyProvider = provider;
        this.valueProvider = provider2;
        this.shouldBase64DecodedProvider = provider3;
    }

    public static KeyValueHeaderInterceptor_Factory create(Provider<String> provider, Provider<String> provider2, Provider<Boolean> provider3) {
        return new KeyValueHeaderInterceptor_Factory(provider, provider2, provider3);
    }

    public static KeyValueHeaderInterceptor newInstance(String str, String str2, boolean z11) {
        return new KeyValueHeaderInterceptor(str, str2, z11);
    }

    public KeyValueHeaderInterceptor get() {
        return newInstance(this.keyProvider.get(), this.valueProvider.get(), this.shouldBase64DecodedProvider.get().booleanValue());
    }
}
