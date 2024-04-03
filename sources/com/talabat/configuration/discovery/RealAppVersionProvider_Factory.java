package com.talabat.configuration.discovery;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealAppVersionProvider_Factory implements Factory<RealAppVersionProvider> {
    private final Provider<Context> contextProvider;

    public RealAppVersionProvider_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static RealAppVersionProvider_Factory create(Provider<Context> provider) {
        return new RealAppVersionProvider_Factory(provider);
    }

    public static RealAppVersionProvider newInstance(Context context) {
        return new RealAppVersionProvider(context);
    }

    public RealAppVersionProvider get() {
        return newInstance(this.contextProvider.get());
    }
}
