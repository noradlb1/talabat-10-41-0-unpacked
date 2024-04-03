package com.talabat.gms.maps.data;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsMapsInitializer_Factory implements Factory<DefaultGmsMapsInitializer> {
    private final Provider<Context> contextProvider;

    public DefaultGmsMapsInitializer_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static DefaultGmsMapsInitializer_Factory create(Provider<Context> provider) {
        return new DefaultGmsMapsInitializer_Factory(provider);
    }

    public static DefaultGmsMapsInitializer newInstance(Context context) {
        return new DefaultGmsMapsInitializer(context);
    }

    public DefaultGmsMapsInitializer get() {
        return newInstance(this.contextProvider.get());
    }
}
